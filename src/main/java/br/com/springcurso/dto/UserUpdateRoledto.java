package br.com.springcurso.dto;

import javax.validation.constraints.NotNull;

import br.com.springcurso.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRoledto {
	
	@NotNull
	private Role role;
	
}
