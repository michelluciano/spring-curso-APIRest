package br.com.springcurso.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcurso.dto.RequestSavedto;
import br.com.springcurso.dto.RequestStageSavedto;
import br.com.springcurso.model.RequestStage;
import br.com.springcurso.service.RequestStageService;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {

	@Autowired 
	private RequestStageService stageService;
	
	//save
	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody @Valid RequestStageSavedto requestStagedto){
		RequestStage requestStage = requestStagedto.trasnformToRequestStage();
		RequestStage createdRequestStage = stageService.save(requestStage);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
	}
	
	//getby
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable() Long id){
		RequestStage stage =stageService.getById(id);
		return ResponseEntity.ok(stage);
	}
	
	//list all by request id
}
