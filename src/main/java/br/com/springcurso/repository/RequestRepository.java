package br.com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

	public List<Request> findAllByOwnerId(Long id);
	
	@Query("UPDATE request SET state = ?2 where id= ?1")
	public Request updateStatus(Long id, RequestState state);
}
