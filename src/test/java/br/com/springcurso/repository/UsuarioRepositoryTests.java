package br.com.springcurso.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springcurso.model.Usuario;
import br.com.springcurso.model.enums.Role;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UsuarioRepositoryTests {

	
	//injeção de dependencia
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void AsaveTest() {
		Usuario usuario = new Usuario();
		
		usuario.setNome("Marcos");
		usuario.setEmail("teste@email.com");
		usuario.setPassword("123");
		usuario.setRole(Role.ADMINISTRADOR);
		
		
		Usuario createdUser = usuarioRepository.save(usuario);
		
		assertThat(createdUser.getId()).isEqualTo(1L); 
	}
	
	@Test
	public void updateTest() {
		Usuario usuario = new Usuario();
		
	    usuario.setId(1L);
		usuario.setNome("Marcos Michel");
		usuario.setEmail("teste@email.com");
		usuario.setPassword("123");
		usuario.setRole(Role.ADMINISTRADOR);
		
		
		Usuario updateUser = usuarioRepository.save(usuario);
		
		assertThat(updateUser.getNome()).isEqualTo("Marcos Michel"); 
	}
	
	@Test
	public void getByIdTest() {
	
		Optional<Usuario> result = usuarioRepository.findById(1L);
		Usuario usuario = result.get();
		
		assertThat(usuario.getPassword()).isEqualTo("123");
	}

	@Test
	public void listTest() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		assertThat(usuarios.size()).isEqualTo(1);
	
	}

	@Test
	public void loginTest() {
		
		Optional<Usuario> result =  usuarioRepository.login("teste@email.com", "123");
		Usuario loggedUser = result.get();
		
		assertThat(loggedUser.getId()).isEqualTo(1L);
	
	}
}
