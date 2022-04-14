package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAccountInitialisation {

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
	public void test_accountIdSetCorrectly() {
		assertEquals(1000,savingsAccount1.getACCOUNT_ID());
		assertEquals(1005,savingsAccount2.getACCOUNT_ID());
		assertEquals(1010,checkingAccount1.getACCOUNT_ID());
		assertEquals(1015,checkingAccount2.getACCOUNT_ID());
	}
	


}
