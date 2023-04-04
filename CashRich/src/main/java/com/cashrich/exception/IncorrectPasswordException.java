package com.cashrich.exception;

public class IncorrectPasswordException extends RuntimeException {

	private String msg;

	public IncorrectPasswordException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
