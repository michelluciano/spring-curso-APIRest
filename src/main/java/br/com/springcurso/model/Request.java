package br.com.springcurso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.springcurso.model.enums.RequestState;
import lombok.Data;



@Data
@Entity(name = "request")
public class Request implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	private String description;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private User owner;
	
	@OneToMany(mappedBy = "request")
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	

}
