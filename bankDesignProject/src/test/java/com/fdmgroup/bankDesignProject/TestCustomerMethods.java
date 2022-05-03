package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCustomerMethods {

	Customer person1;
	Customer company1;
	CheckingAccount checkingAccount1;
	CheckingAccount checkingAccount2;
	SavingsAccount savingsAccount1;
	SavingsAccount savingsAccount2;
	
	
	@Before
	public void setUp() throws Exception {
		person1 = new Person("person1","address1");
		company1 = new Company("company1","address2");
		checkingAccount1 = new CheckingAccount();
		checkingAccount2 = new CheckingAccount();
		savingsAccount1 = new SavingsAccount();
		savingsAccount2 = new SavingsAccount();
	}
	
	@Test
	public void test_nameAndAddressSetByConstructor() {
		assertEquals("person1",person1.getName());
		assertEquals("address1",person1.getAddress());
		assertEquals("company1",company1.getName());
		assertEquals("address2",company1.getAddress());
	}

	@Test
	public void test_addAccountWorks() {
		person1.addAccount(checkingAccount1);
		person1.addAccount(savingsAccount1);
		company1.addAccount(checkingAccount2);
		company1.addAccount(savingsAccount2);
		
		assertEquals(2,person1.getAccounts().size());
		assertEquals(2,company1.getAccounts().size());
		assertTrue(person1.getAccounts().contains(checkingAccount1) && person1.getAccounts().contains(savingsAccount1));
		assertTrue(company1.getAccounts().contains(checkingAccount2) && company1.getAccounts().contains(savingsAccount2));
	}
	
	@Test
	public void test_removeAccountWorks() {
		person1.addAccount(checkingAccount1);
		person1.addAccount(savingsAccount1);
		company1.addAccount(checkingAccount2);
		company1.addAccount(savingsAccount2);
		
		person1.removeAccount(checkingAccount1);
		company1.removeAccount(savingsAccount2);
		
		assertEquals(1,person1.getAccounts().size());
		assertEquals(1,company1.getAccounts().size());
		assertTrue(person1.getAccounts().contains(savingsAccount1));
		assertTrue(company1.getAccounts().contains(checkingAccount2));

	}

}
