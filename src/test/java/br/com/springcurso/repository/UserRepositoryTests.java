package br.com.springcurso.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springcurso.model.User;
import br.com.springcurso.model.enums.Role;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Ignore
	@Test
	public void AsaveTest() {
		User user = new User();
		user.setId(null);
		user.setName("Marcos");
		user.setEmail("teste@teste.com");
		user.setPassword("123");
		user.setRole(Role.ADMINISTRADOR);
		user.setRequest(null);
		user.setStages(null);
		
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
		
	}
	@Ignore
	@Test
	public void updateTest() {
		User user = new User();
		user.setId(1L);
		user.setName("Marcos Michel");
		user.setEmail("teste@teste.com");
		user.setPassword("123");
		user.setRole(Role.ADMINISTRADOR);
		user.setRequest(null);
		user.setStages(null);
		
		User updatedUser = userRepository.save(user);
		
		assertThat(updatedUser.getName()).isEqualTo("Marcos Michel");

		
	}
	@Ignore
	@Test
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("123");
	}
	@Ignore
	@Test
	public void listTest() {
	
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
		
	}
	@Ignore
	@Test
	public void loginTest() {
			
		Optional<User> result = userRepository.login("teste@teste.com", "123");
		User loggedUser = result.get();
		
		assertThat(loggedUser.getId()).isEqualTo(1L);
		
	}
	
	@Test
	public void updateRoleTest() {
		int affectedRows = userRepository.updateRole(2L, Role.ADMINISTRADOR);
		assertThat(affectedRows).isEqualTo(1);
	}
}
