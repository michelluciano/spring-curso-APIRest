package br.com.springcurso.dto;

import javax.validation.constraints.NotNull;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.RequestStage;
import br.com.springcurso.model.User;
import br.com.springcurso.model.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestStageSavedto {
	
	private String description;
	@NotNull(message = "State Required")
	private RequestState state;
	
	@NotNull(message = "Request required")
	private Request request;
	
	@NotNull(message = "Owner required")
	private User owner;
	
	public RequestStage trasnformToRequestStage(){
		RequestStage stage = new RequestStage(null, description, null, state, request, owner);
		return stage;
	}
}
