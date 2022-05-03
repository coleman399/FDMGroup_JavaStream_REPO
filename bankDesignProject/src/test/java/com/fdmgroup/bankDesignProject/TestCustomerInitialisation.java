package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCustomerInitialisation {
	
	Customer person1;
	Customer person2;
	Customer company1;
	Customer company2;
	
	@Before
	public void setUp() throws Exception {
		person1 = new Person("person1","address1");
		person2 = new Person("person2","address2");
		company1 = new Company("company1","address3");
		company2 = new Company("company2","address4");
	}

	@Test
	public void test_correctCustomerIdsSet() {
		assertEquals(2000000,person1.getCUSTOMER_ID());
		assertEquals(2000007,person2.getCUSTOMER_ID());
		assertEquals(2000014,company1.getCUSTOMER_ID());
		assertEquals(2000021,company2.getCUSTOMER_ID());
	}
	


}
