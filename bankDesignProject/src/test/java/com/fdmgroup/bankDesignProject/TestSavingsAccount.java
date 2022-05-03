package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSavingsAccount {

	SavingsAccount savingsAccount1;
	SavingsAccount savingsAccount2;
	
	@Before
	public void setUp() throws Exception {
		savingsAccount1 = new SavingsAccount();
		savingsAccount2 = new SavingsAccount();
	}

	@Test
	public void test_interestIsAddedCorrectly() {
		savingsAccount1.deposit(1000);
		savingsAccount1.setInterestRate(2.51);
		savingsAccount1.addInterest();
		assertEquals(1025.1,savingsAccount1.getBalance(),0.00001);
	}
	
	@Test
	public void test_withdrawWorks() {
		savingsAccount1.deposit(50);
		savingsAccount2.deposit(100);
		double amountWithdrawn1 = savingsAccount1.withdraw(500);
		double amountWithdrawn2 = savingsAccount2.withdraw(20);
		
		assertEquals(0,amountWithdrawn1,0.0000001);
		assertEquals(20,amountWithdrawn2,0.0000001);
		assertEquals(50,savingsAccount1.getBalance(),0.000001);
		assertEquals(80,savingsAccount2.getBalance(),0.000001);
	}

}
