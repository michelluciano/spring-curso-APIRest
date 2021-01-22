package br.com.springcurso.dto;

import br.com.springcurso.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRoledto {
	
	private Role role;
	
}
