/*
  	AccountsMB.java

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
package br.com.afett.arquillianbank.mb;

import javax.inject.Inject;

import br.com.afett.arquillianbank.daos.AccountDAO;
import br.com.afett.arquillianbank.entities.Account;

/**
 * Accounts business rules.
 * 
 * @author Andre Fettermann <a href="mailto:andre.fettermann@gmail.com">
 * andre.fettermann@gmail.com</a>
 * <br/>
 * published under the terms and conditions of the GPL License, for details see 
 * file gpl-3.0.txt in the distribution package of this software
 */
public class AccountsMB {
	
	@Inject
	private AccountDAO accountDAO;
	
	public Account add() {
		return new Account();
	}
	
	public Integer insert(Account account) {
		return accountDAO.insert(account);
	}
	
	public Account read(Integer id) {
		return accountDAO.read(id);
	}

}
