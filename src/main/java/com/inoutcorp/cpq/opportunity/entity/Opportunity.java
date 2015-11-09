package com.inoutcorp.cpq.opportunity.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.inoutcorp.cpq.opportunity.entity.base.AbstractEntity;

/*CREATE TABLE `MY_OPPORTUNITIES` (
 `PKEY` int(11) NOT NULL AUTO_INCREMENT,
 `NAME` varchar(50) DEFAULT NULL,
 `DESCRIPTION` varchar(200) DEFAULT NULL,
 `AMOUNT` int(11) DEFAULT NULL,
 `IS_CLOSED` tinyint(1) DEFAULT NULL,
 `ISO_CODE` varchar(3) DEFAULT NULL,
 `IS_DELETED` tinyint(1) DEFAULT NULL,
 `IS_WON` tinyint(1) DEFAULT NULL,
 `CREATED_BY` varchar(50) DEFAULT NULL,
 `CREATED_TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `CHANGED_BY` varchar(50) DEFAULT NULL,
 `CHANGED_TS` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `CLOSED_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `VERSION` int(11) DEFAULT NULL  ,
 PRIMARY KEY (`PKEY`)
 ) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;*/

@Entity
@Table(name = "MY_OPPORTUNITIES")
public class Opportunity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -7801994616907492313L;

	/** The name. */
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
	@Column(name = "NAME")
	public String getName() {
		return name;
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
	@Column(name = "AMOUNT")
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
	@Column(name = "CLOSED_DATE")
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
	@Column(name = "ISO_CODE")
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
	@Column(name = "DESCRIPTION")
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
	@Column(name = "IS_CLOSED")
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
	 * Gets the checks if is won.
	 *
	 * @return the checks if is won
	 */
	@Column(name = "IS_WON")
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
