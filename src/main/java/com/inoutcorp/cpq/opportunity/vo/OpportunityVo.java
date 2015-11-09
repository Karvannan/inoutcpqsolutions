package com.inoutcorp.cpq.opportunity.vo;

import java.io.Serializable;
import java.util.Date;

import com.inoutcorp.cpq.opportunity.vo.base.BaseVo;

/**
 * The Class OpportunityVo.
 */
public class OpportunityVo extends BaseVo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4527560594852046176L;

	private String name;

	/** The description. */

	private String description;

	/** The amount. */

	private Long amount;

	/** The closed date. */

	private Date closedDate;

	/** The iso code. */
	private String isoCode;

	/** The is closed. */
	private Boolean isClosed;

	/** The is won. */
	private Boolean isWon;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Boolean getIsWon() {
		return isWon;
	}

	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

}
