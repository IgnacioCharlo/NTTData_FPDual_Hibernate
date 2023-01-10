package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoria | Usuario que actualiza */
	private String updatedUser;


	/**
	 * GET ID
	 *
	 * @return Long
	 */
	@Transient
	public abstract Long getId();


	/**
	 * @return the updatedClient
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedClient to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

}
