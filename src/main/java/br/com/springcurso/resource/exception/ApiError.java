package br.com.springcurso.resource.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ApiError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Date date;
	
}
