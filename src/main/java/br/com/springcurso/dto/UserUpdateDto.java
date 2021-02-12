package br.com.springcurso.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.RequestStage;
import br.com.springcurso.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateDto {
	@NotBlank(message = "Name invalid")
	private String name;
	
	@Email(message = "Invalid email adress")
	private String email;
	
	@Size(min = 4, max = 99, message ="Password must be between 4 and 99 characters" )
	private String password;

	private List<Request> requests = new ArrayList<Request>();
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public User TransformToUser() {
		User user = new User(null,this.name,this.email, this.password, null, this.requests, this.stages); 
		return user;
		
	}
}
