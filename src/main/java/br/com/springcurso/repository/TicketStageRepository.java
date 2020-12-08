package br.com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springcurso.model.TicketStage;

@Repository
public interface TicketStageRepository extends JpaRepository<TicketStage, Long>{

	public List<TicketStage> findAllTicketId(Long id);
	


}
