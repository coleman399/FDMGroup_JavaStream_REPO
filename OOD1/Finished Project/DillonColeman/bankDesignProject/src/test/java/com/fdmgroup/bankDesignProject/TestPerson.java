package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	Person person;
	CheckingAccount checkingAccount;
	SavingsAccount savingsAccount;
	
	@Before
	public void setUp() throws Exception {
		person = new Person("person1","address1");
		checkingAccount = new CheckingAccount();
		savingsAccount = new SavingsAccount();
		person.addAccount(checkingAccount);
		person.addAccount(savingsAccount);
	}

	@Test
	public void test_correctChargesDeductedFromAllAccounts() {
		checkingAccount.correctBalance(150);
		savingsAccount.correctBalance(1000000);
		person.chargeAllAccounts(10);
		
		assertEquals(140,checkingAccount.getBalance(),0.000001);
		assertEquals(999990,savingsAccount.getBalance(),0.00001);
	}

}
