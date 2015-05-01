package com.inoutcorp.cpq.opportunity.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class InOutCorpResponse.
 */
public class InOutCorpResponse {

	/** The data. */
	private Map<String, Object> data = new HashMap<String, Object>();

	/** The errors. */
	private Exception errors;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the data
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public Exception getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(Exception errors) {
		this.errors = errors;
	}

	/**
	 * Put message.
	 *
	 * @param name the name
	 * @param message the message
	 */
	public void putMessage(String name, Object message) {
		data.put(name, message);
	}

	/**
	 * Removes the message.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	public boolean removeMessage(String name) {
		if (data.remove(name) != null)
			return true;
		else
			return false;
	}
}
