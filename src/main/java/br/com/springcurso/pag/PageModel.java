package br.com.springcurso.pag;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageModel <E> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalElements;
	private int pageSize;
	private int totalPages;
	private List<E> elements;
}
