package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCheckingAccount {

	CheckingAccount checkingAccount;
	
	@Before
	public void setUp() throws Exception {
		checkingAccount = new CheckingAccount();
	}

	@Test
	public void test_getNextCheckNumberWorks() {
		int check1 = checkingAccount.getNextCheckNumber();
		int check2 = checkingAccount.getNextCheckNumber();
		int check3 = checkingAccount.getNextCheckNumber();
		
		assertEquals(1,check1);
		assertEquals(2,check2);
		assertEquals(3,check3);
	}

}
