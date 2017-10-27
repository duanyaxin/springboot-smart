package org.zt.ccty.springboot_mybatis_demo.common;

public class ResponseBean {
	private Integer code;
	private Boolean isCorrect;
	private Object message;
	private String failedReason;
	
	public ResponseBean() {
		
	}
	
	public ResponseBean(Integer code, Boolean isCorrect, Object message, String failedReason) {
		super();
		this.code = code;
		this.isCorrect = isCorrect;
		this.message = message;
		this.failedReason = failedReason;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public String getFailedReason() {
		return failedReason;
	}
	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}
	
	
	
}
