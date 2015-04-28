package com.inoutcorp.cpq.opportunity.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InOutCorpResponse {
	
	private Map<String, Object> data = new HashMap<String, Object>();
	
	private List errors;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List getErrors() {
		return errors;
	}

	public void setErrors(List errors) {
		this.errors = errors;
	}

	public void putMessage(String name, Object message) {
		data.put(name, message);
	}

	public boolean removeMessage(String name) {
		if (data.remove(name) != null)
			return true;
		else
			return false;
	}
}
