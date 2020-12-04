package br.com.springcurso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.springcurso.model.enums.Role;
import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = false)
	private String nome;
	
	@Column(length = 75, nullable = false, unique = true)
	private String email;
	
	@Column(length = 75, nullable = false)	
	private String password;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "usuario")
	private List<Ticket> ticket = new ArrayList<Ticket>();
	
	@OneToMany(mappedBy = "usuario")
	private List<TicketStage> stages = new ArrayList<TicketStage>();

}
