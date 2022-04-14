package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompany {
	
	Company company;
	CheckingAccount checkingAccount1;
	CheckingAccount checkingAccount2;
	SavingsAccount savingsAccount1;
	SavingsAccount savingsAccount2;

	@Before
	public void setUp() throws Exception {
		company = new Company("company1","address1");
		checkingAccount1 = new CheckingAccount();
		checkingAccount2 = new CheckingAccount();
		savingsAccount1 = new SavingsAccount();
		savingsAccount2 = new SavingsAccount();
		company.addAccount(checkingAccount1);
		company.addAccount(checkingAccount2);
		company.addAccount(savingsAccount1);
		company.addAccount(savingsAccount2);
	}
 
	@Test
	public void test_chargeAllAccountsWorks() {
		checkingAccount1.correctBalance(10000);
		checkingAccount2.correctBalance(7500);
		savingsAccount1.correctBalance(150000);
		savingsAccount2.correctBalance(250000);
		
		company.chargeAllAccounts(10);
		
		assertEquals(9990,checkingAccount1.getBalance(),0.00001);
		assertEquals(7490,checkingAccount2.getBalance(),0.00001);
		assertEquals(149980,savingsAccount1.getBalance(),0.00001);
		assertEquals(249980,savingsAccount2.getBalance(),0.00001);
	}

}
