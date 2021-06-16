/*
  	Account.java

  	Copyright (c) 2021, Andre Fettermann,  andre.fettermann@gmail.com
  	All rights reserved.

	This file is part of ArquillianBank.

    ArquillianBank is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    ArquillianBank is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with ArquillianBank.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.afett.arquillianbank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bank customer account data.
 * 
 * @author Andre Fettermann <a href="mailto:andre.fettermann@gmail.com">
 * andre.fettermann@gmail.com</a>
 * <br/>
 * published under the terms and conditions of the GPL License, for details see 
 * file gpl-3.0.txt in the distribution package of this software
 */
@Table(name = "tbl_account")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "cust_name")
	private String customerName;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "bank_agency")
	private String bankAgency;
	
	private String number;
	
	/**
	 * @return the id.
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the customerName.
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	/**
	 * @param customerName the customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the bankName.
	 */
	public String getBankName() {
		return this.bankName;
	}
	/**
	 * @param bankName the bankName to set.
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the bankAgency.
	 */
	public String getBankAgency() {
		return this.bankAgency;
	}
	/**
	 * @param bankAgency the bankAgency to set.
	 */
	public void setBankAgency(String bankAgency) {
		this.bankAgency = bankAgency;
	}
	/**
	 * @return the number.
	 */
	public String getNumber() {
		return this.number;
	}
	/**
	 * @param number the number to set.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
