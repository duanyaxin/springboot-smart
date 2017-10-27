package org.zt.ccty.springboot_mybatis_demo.model;

import java.io.Serializable;

public class UserIntegral implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserIntegral() {
		
	}
	
	
	
	public UserIntegral(Integer uid, String integral, String description) {
		super();
		this.uid = uid;
		this.integral = integral;
		this.description = description;
	}



	private Long id;
	private Integer uid;
	private String integral;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getIntegral() {
		return integral;
	}
	public void setIntegral(String integral) {
		this.integral = integral;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
