package br.com.springcurso.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.springcurso.model.Request;
import br.com.springcurso.model.RequestStage;
import br.com.springcurso.model.User;
import br.com.springcurso.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSavedto {
	
	@NotBlank(message = "Name required")
	private String name;
	
	@Email(message = "Invalid email address")
	private String email;
	
	@Size(min = 4, max = 99, message ="Password must be between 4 and 99 characters" )
	private String password;
	
	@NotNull(message = "Role required")
	private Role role;
	
	private List<Request> requests = new ArrayList<Request>();
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public User TransformToUser() {
		User user = new User(null,this.name,this.email, this.password, this.role, this.requests, this.stages); 
		return user;
		
	}
	
}
