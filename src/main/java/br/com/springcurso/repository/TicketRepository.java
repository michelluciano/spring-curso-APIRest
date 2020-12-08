package br.com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springcurso.model.Ticket;
import br.com.springcurso.model.enums.TicketEstado;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	public List<Ticket> findAllByUsuarioId(Long id);
	
	@Query("UPDATE ticket SET estado =?2 where id= ?1")
	public Ticket updateStataus(Long id, TicketEstado estado);
	
}
