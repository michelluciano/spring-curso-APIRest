package br.com.springcurso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcurso.model.Request;
import br.com.springcurso.service.RequestService;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

	@Autowired
	private RequestService requestService;
	
	//save
	@PostMapping
	public ResponseEntity<Request> save(@RequestBody Request request){
		Request createdRequest = requestService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}
		
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Request> update (@PathVariable(name = "id") Long id, @RequestBody Request request){
		request.setId(id);
		Request updateRequest = requestService.update(request);
		return ResponseEntity.ok(updateRequest);
	}
	
	//getbyid
	@GetMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
		Request request = requestService.getById(id);
		return ResponseEntity.ok(request);
	}
	
	//listall
	
	@GetMapping
	public ResponseEntity<List<Request>> listAll(){
		List<Request> requests = requestService.listAll();
		return ResponseEntity.ok(requests);
	}
	
	
}
