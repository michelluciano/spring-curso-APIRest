package br.com.springcurso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.springcurso.Util.HashUtil;
import br.com.springcurso.exception.NotFoundException;
import br.com.springcurso.model.User;
import br.com.springcurso.pag.PageModel;
import br.com.springcurso.pag.PageRequestModel;
import br.com.springcurso.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		String hash = HashUtil.getSecurehash(user.getPassword());
		user.setPassword(hash);
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	public User update (User user) {
		String hash = HashUtil.getSecurehash(user.getPassword());
		user.setPassword(hash);
				
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);

		return result.orElseThrow(()-> new NotFoundException("There are not User with id = " + id));
	}
	
	public List<User> listAll(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public PageModel<User> listAllOnLazyMode(PageRequestModel pr){
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<User> page = userRepository.findAll(pageable);
		
		PageModel<User> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		return pm;
	}
	
	public User login(String email, String password) {
		password = HashUtil.getSecurehash(password);
			
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}
	
	public int updateRole(User user) {
		return userRepository.updateRole(user.getId(), user.getRole()); 
	}
}
