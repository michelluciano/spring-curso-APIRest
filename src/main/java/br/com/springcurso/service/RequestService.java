package br.com.springcurso.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.enums.RequestState;
import br.com.springcurso.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;
	
	public Request save(Request request) {
		request.setState(RequestState.ABERTO);
		request.setCreationDate(new Date());
		
		Request createdRequest = requestRepository.save(request);
		return createdRequest;
	}
	
	public Request update(Request request) {
		Request updatedRequest = requestRepository.save(request);
		return updatedRequest;
	}
	
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.get();
	}
	
	public List<Request> listAll() {
		List<Request> requests = requestRepository.findAll();
		return requests;
	}
	
	public List<Request> listAllByOwnerId(Long ownerId){
		List<Request> requests = requestRepository.findAllByOwnerId(ownerId);
		return requests;
	}
}

