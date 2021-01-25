package br.com.springcurso.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcurso.dto.UserLogindto;
import br.com.springcurso.dto.UserUpdateRoledto;
import br.com.springcurso.model.Request;
import br.com.springcurso.model.User;
import br.com.springcurso.pag.PageModel;
import br.com.springcurso.pag.PageRequestModel;
import br.com.springcurso.service.RequestService;
import br.com.springcurso.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;
	
	//save
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		User createdUser = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(name = "id") Long id, @RequestBody User user){
		user.setId(id);
		User updatedUser = userService.update(user);
		return ResponseEntity.ok(updatedUser);
	}
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Long id){
		User user = userService.getById(id);
		return ResponseEntity.ok(user);
	}
	
	//list
	@GetMapping
	public ResponseEntity<PageModel<User>> listAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<User> pm = userService.listAllOnLazyMode(pr);
		
		return ResponseEntity.ok(pm);
	}
	
	//login
	@PostMapping("/login")
	public ResponseEntity<User> login (@RequestBody @Valid UserLogindto user){
		User loggedUser = userService.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}
	
	//listall by ownerid
	//@GetMapping("/{id}/requests")
	//public ResponseEntity<List<Request>> listAllRequestsById(@PathVariable(name = "id") Long id){
	//	List<Request> requests = requestService.listAllByOwnerId(id);
	//	return ResponseEntity.ok(requests);
	//}
	
	@GetMapping("/{id}/requests")
	public ResponseEntity<PageModel<Request>> listAllRequestsById(
			@PathVariable(name = "id") Long id,
			@RequestParam(name = "size",defaultValue = "10") int size,
			@RequestParam(name = "page",defaultValue = "0") int page){
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<Request> pm = requestService.listAllByOwnerIdOnLazyModel(id, pr);
		return ResponseEntity.ok(pm);
	}
	
	@PatchMapping("/role/{id}")
	public ResponseEntity<?> updateRole(@PathVariable(name = "id") Long id, @RequestBody @Valid UserUpdateRoledto userDto){
		User user = new User();
		user.setId(id);
		user.setRole(userDto.getRole());
		
		userService.updateRole(user);
		
		return ResponseEntity.ok().build();
		
	}
	
}
