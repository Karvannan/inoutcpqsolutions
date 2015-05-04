package com.inoutcorp.cpq.opportunity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class OpportunityVo.
 */
public class OpportunityVo implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4527560594852046176L;

	/** The id. */
	private String id;

	/** The name. */
	private String name;

	/** The amount. */
	private Long amount;

	/** The closed date. */
	private Date closedDate;

	/** The iso code. */
	private String isoCode;

	/** The description. */
	private String description;

	/** The is closed. */
	private Boolean isClosed;

	/** The is deleted. */
	private Boolean isDeleted;

	/** The is won. */
	private Boolean isWon;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * Gets the closed date.
	 *
	 * @return the closed date
	 */
	public Date getClosedDate() {
		return closedDate;
	}

	/**
	 * Sets the closed date.
	 *
	 * @param closedDate
	 *            the new closed date
	 */
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	/**
	 * Gets the iso code.
	 *
	 * @return the iso code
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * Sets the iso code.
	 *
	 * @param isoCode
	 *            the new iso code
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the checks if is closed.
	 *
	 * @return the checks if is closed
	 */
	public Boolean getIsClosed() {
		return isClosed;
	}

	/**
	 * Sets the checks if is closed.
	 *
	 * @param isClosed
	 *            the new checks if is closed
	 */
	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * Gets the checks if is deleted.
	 *
	 * @return the checks if is deleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * Sets the checks if is deleted.
	 *
	 * @param isDeleted
	 *            the new checks if is deleted
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * Gets the checks if is won.
	 *
	 * @return the checks if is won
	 */
	public Boolean getIsWon() {
		return isWon;
	}

	/**
	 * Sets the checks if is won.
	 *
	 * @param isWon
	 *            the new checks if is won
	 */
	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

}
