package com.dxc.forum.custom_exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
	
	private static final long serialVersionUID=1L;
	private String errorcode;
	private String errorMsg;
	
	public ControllerException() {
		super();
	}
	
	public ControllerException(String errorcode, String errorMsg) {
		super();
		this.errorcode = errorcode;
		this.errorMsg = errorMsg;
	}
	
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		System.out.println(errorcode+""+errorMsg);
		return "ControllerException [errorcode=" + errorcode + ", errorMsg=" + errorMsg + "]";
	}
	
	
	
	
	
	

}
