package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAccountMethods {

	Account savingsAccount1;
	Account savingsAccount2;
	Account checkingAccount1;
	Account checkingAccount2;
	
	@Before
	public void setUp() throws Exception {
		savingsAccount1 = new SavingsAccount();
		savingsAccount2 = new SavingsAccount();
		checkingAccount1 = new CheckingAccount();
		checkingAccount2 = new CheckingAccount();
	}


	
	@Test
	public void test_depositMethodWorks() {
		savingsAccount1.deposit(100);
		checkingAccount1.deposit(250);
		
		assertEquals(100,savingsAccount1.getBalance(),0.0000001);
		assertEquals(250,checkingAccount1.getBalance(),0.0000001);
		
	}
	
	@Test
	public void test_withdrawMethodWorks() {
		savingsAccount1.deposit(100);
		checkingAccount1.deposit(250);
		
		double amountWithdrawn1 = savingsAccount1.withdraw(50);
		double amountWithdrawn2 = checkingAccount1.withdraw(60);
		
		assertEquals(50,amountWithdrawn1,0.000001);
		assertEquals(60,amountWithdrawn2,0.000001);
		
		assertEquals(50,savingsAccount1.getBalance(),0.000001);
		assertEquals(190,checkingAccount1.getBalance(),0.000001);
	}
	
	@Test
	public void test_checkingAccountCanGoOverdrawn() {
		checkingAccount1.deposit(50);
		double amountWithdrawn = checkingAccount1.withdraw(500);
		
		assertEquals(500,amountWithdrawn,0.0000001);
		assertEquals(-450,checkingAccount1.getBalance(),0.000001);
	}
	

	
	@Test
	public void test_correctBalanceWorks() {
		savingsAccount1.deposit(1500);
		checkingAccount1.deposit(299);
		
		savingsAccount1.correctBalance(1350);
		checkingAccount1.correctBalance(750);
		
		assertEquals(1350,savingsAccount1.getBalance(),000000.1);
		assertEquals(750,checkingAccount1.getBalance(),000000.1);
	}

}
