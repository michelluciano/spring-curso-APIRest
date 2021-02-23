
package br.com.springcurso.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
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
public class RequestUpdatedto {
	@NotBlank(message = "Subject requerid")
	private String subject;
	private String description;
	@NotNull(message = "State requerid")
	private RequestState state;
	@NotNull(message = "Owner required")
	private User owner;
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public Request trasnformeToRequest() {
		Request request = new Request(null, this.subject, this.description, null,this.state, this.owner, stages );
		return request;
	}
}
