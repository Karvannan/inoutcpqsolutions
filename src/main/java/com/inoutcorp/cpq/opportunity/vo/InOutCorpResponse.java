package com.inoutcorp.cpq.opportunity.vo;

import java.util.HashMap;
import java.util.Map;

public class InOutCorpResponse {

	private Map<String, Object> data = new HashMap<String, Object>();

	private Exception errors;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Exception getErrors() {
		return errors;
	}

	public void setErrors(Exception errors) {
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
