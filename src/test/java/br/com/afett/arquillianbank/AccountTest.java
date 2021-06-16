/*
  	AccountTest.java

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
package br.com.afett.arquillianbank;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.afett.arquillianbank.entities.Account;
import br.com.afett.arquillianbank.mb.AccountsMB;

/**
 * Unit tests for Account using Arquillian.
 * 
 * @author Andre Fettermann <a href="mailto:andre.fettermann@gmail.com">
 * andre.fettermann@gmail.com</a>
 * <br/>
 * published under the terms and conditions of the GPL License, for details see 
 * file gpl-3.0.txt in the distribution package of this software
 */
@RunWith(Arquillian.class)
public class AccountTest {
	
	@Deployment
	public static WebArchive createDeployment() {
        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                //.importRuntimeDependencies()
                .importTestDependencies()
                .importCompileAndRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

		WebArchive war = ShrinkWrap.create(WebArchive.class
				, "arquillianbank-tests.war")
				.addAsLibraries(files)
				.addPackage(AccountsMB.class.getPackage())
				.addPackages(true, "br.com.afett.arquillianbank")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("META-INF/persistence.xml"
						, "META-INF/persistence.xml")
				.addAsManifestResource("META-INF/MANIFEST.MF","MANIFEST.MF");
		
		war.merge(ShrinkWrap.create(GenericArchive.class)
				.as(ExplodedImporter.class)
				.importDirectory("src/main/webapp")
				.as(GenericArchive.class), "/", Filters.includeAll());  
		
		//war.as(ZipExporter.class).exportTo(new File("teste.war"), true);
		//System.out.println(war.toString(true));
		return war;
	}

	@Inject
	private AccountsMB model;
	
	/**
	 * <b>Given</b> i want to register a new account<br/>
	 * <b>Given</b> i filled all the necessary data<br/>
	 * <b>When</b> i send an insert request<br/>
	 * <b>Then</b> the account should be inserted<br/>
	 */
	@Test
	public void testShouldInsertAccount() {
		Account newAccount = model.add();
		newAccount.setCustomerName("Customer #01");
		newAccount.setBankName("Bank #01");
		newAccount.setBankAgency("Agency 001");
		newAccount.setNumber("Account #001");
		
		int id = model.insert(newAccount);
		
		Account readAccount = model.read(id);
		assertEquals(newAccount.getNumber(), readAccount.getNumber());
	}

}