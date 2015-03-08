package com.privilege.beans;

import java.io.Serializable;

public class Json implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean success=true;
	private String msg="";
	private Object obj=null;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
