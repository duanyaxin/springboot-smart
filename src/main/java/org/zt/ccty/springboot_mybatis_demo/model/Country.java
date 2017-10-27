package org.zt.ccty.springboot_mybatis_demo.model;

import java.io.Serializable;

public class Country implements Serializable{

	public Country() {
		
	}
	
	public Country(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String code;
	private String name;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
