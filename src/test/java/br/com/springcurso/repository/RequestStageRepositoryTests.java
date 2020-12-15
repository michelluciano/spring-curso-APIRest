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
import br.com.springcurso.model.RequestStage;
import br.com.springcurso.model.User;
import br.com.springcurso.model.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestStageRepositoryTests {
	@Autowired
	private RequestStageRepository requestStageRepository;
	
	@Test
	public void AsaveTest() {
		
		User owner = new User();
		owner.setId(1L);
		
		Request request = new Request();
		request.setId(6L);
		RequestStage stage = new RequestStage();
		
		stage.setId(null);
		stage.setDescription("Foi comprado um novo laptop de marca HP e com 16 GB de RAM");
		stage.setRealizationDate(new Date());
		stage.setState(RequestState.FECHADO);
		stage.setRequest(request);
		stage.setOwner(owner);
		
		RequestStage createdStage = requestStageRepository.save(stage);
		
		assertThat(createdStage.getId()).isEqualTo(1L);
	}
	
	@Test
	public void getByIdTest() {
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		RequestStage stage = result.get();
		
		assertThat(stage.getDescription()).isEqualTo("Foi comprado um novo laptop de marca HP e com 16 GB de RAM");
	}
	
	@Test
	public void listByRequestIdTest() {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);
		assertThat(stages.size()).isEqualTo(1);
	}
}
