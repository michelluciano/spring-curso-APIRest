package br.com.springcurso.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.User;
import br.com.springcurso.model.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTests {

	@Autowired
	private RequestRepository requestRepository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request();
		
		request.setId(null);
		request.setSubject("Novo LapTop HP");
		request.setDescription("Pretendo obter um laptopHP");
		request.setCreationDate(new Date());
		request.setState(RequestState.ABERTO);
		request.setOwner(owner);
		request.setStages(null);
		
		Request createdRequest = requestRepository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request();
		
		request.setId(1L);
		request.setSubject("Novo LapTop HP");
		request.setDescription("Pretendo obter um laptopHP, com 16 GB de RAM");
		request.setCreationDate(null);
		request.setState(RequestState.ABERTO);
		request.setOwner(owner);
		request.setStages(null);
		
		Request updatedRequest = requestRepository.save(request);
		
		assertThat(updatedRequest.getDescription()).isEqualTo("Pretendo obter um laptopHP, com 16 GB de RAM");
	}
	
	@Test
	public void getByIdTest() {
		
		Optional<Request> result = requestRepository.findById(1L);
		
		Request request = result.get();
		
		assertThat(request.getSubject()).isEqualTo("Novo LapTop HP");
	}
	
	@Test
	public void listTest() {
		List<Request> requests = requestRepository.findAll();
		
		assertThat(requests.size()).isEqualTo(1);
	}
	
	@Test
	public void listByOwnerIdTest() {
		List<Request> requests = requestRepository.findAllByOwnerId(1L);
		
		assertThat(requests.size()).isEqualTo(1);
	}
}
