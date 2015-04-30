package com.inoutcorp.cpq.opportunity.vo;

import java.io.Serializable;
import java.util.Date;

public class OpportunityVo implements Serializable {

	private static final long serialVersionUID = -4527560594852046176L;

	private String id;

	private String name;

	private Long amount;

	private Date closedDate;

	private String isoCode;

	private String description;

	private Boolean isClosed;

	private Boolean isDeleted;

	private Boolean isWon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsWon() {
		return isWon;
	}

	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

}
