package com.fiber.web.app.common;

import java.util.HashMap;
import java.util.Map;

public class FiberRestResponse {
	
	public static final String DATA = "data";
	
	public static final String INPUTERROR = "inputerror";
	
	public static final String MESSAGE="message";
	
	public boolean success= false;
	
	private Map<String, Object> result=new HashMap<String, Object>();
	
	public boolean isSuccess() {
		return success;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public FiberRestResponse() {
		
	}
	
	public FiberRestResponse(boolean success) {
		this.success=success;
	}
	
	public FiberRestResponse(boolean success, String message ) {
		this.success=success;
		addMessage(message);
	}
	
	public FiberRestResponse(boolean success, String message, Object value) {
		this.success=success;
		addMessage(message);
		addData(value);
	}
	
	public void addData(Object value){
		result.put(DATA, value);
	}
	
	public void addMessage(Object value) {
	result.put(MESSAGE, value);	
	}
	
	public void addInputError(Object value) {
	result.put(INPUTERROR, value);	
	}
	
	public void addResult(String key, Object value) {
    result.put(key, value);		
	}
}