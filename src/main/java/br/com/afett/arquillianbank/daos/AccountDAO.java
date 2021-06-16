/*
  	AccountDAO.java

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
package br.com.afett.arquillianbank.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.afett.arquillianbank.entities.Account;

/**
 * Account DAO.
 * 
 * @author Andre Fettermann <a href="mailto:andre.fettermann@gmail.com">
 * andre.fettermann@gmail.com</a>
 * <br/>
 * published under the terms and conditions of the GPL License, for details see 
 * file gpl-3.0.txt in the distribution package of this software
 */
@Stateless
public class AccountDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Integer insert(Account account) {
		this.manager.persist(account);
		this.manager.flush();
		return account.getId();
	}
	
	public Account read(Integer id) {
		return this.manager.find(Account.class, id);
	}

}
