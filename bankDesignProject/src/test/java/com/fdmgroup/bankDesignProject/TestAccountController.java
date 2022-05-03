package com.fdmgroup.bankDesignProject;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestAccountController {
	
	AccountController accountController;

	@Before
	public void setUp() throws Exception {
		accountController = new AccountController();
	}

	@Test
	public void test_createCustomerWorksForPerson() {
		Customer customer = accountController.createCustomer("person1","address1","person");
		List<Customer> customers = accountController.getCustomers();
		
		assertTrue(customer instanceof Person);
		assertEquals("person1",customer.getName());
		assertEquals("address1",customer.getAddress());
		assertTrue(customers.contains(customer));
		assertEquals(1,customers.size());
	}
	
	@Test
	public void test_createCustomerWorksForCompany() {
		Customer customer = accountController.createCustomer("company1","address1","company");
		List<Customer> customers = accountController.getCustomers();
		
		assertTrue(customer instanceof Company);
		assertEquals("company1",customer.getName());
		assertEquals("address1",customer.getAddress());
		assertTrue(customers.contains(customer));
		assertEquals(1,customers.size());
	}
	
	@Test
	public void test_createAccountWorksForCheckingAccount() {
		Customer customer = new Person("person1","address1");
		Account account = accountController.createAccount(customer,"checking");
		List<Account> allAccounts = accountController.getAccounts();
		List<Account> customerAccounts = customer.getAccounts();
		
		assertTrue(account instanceof CheckingAccount);
		assertTrue(allAccounts.contains(account));
		assertTrue(customerAccounts.contains(account));
	}
	
	@Test
	public void test_createAccountWorksForSavingsAccount() {
		Customer customer = new Person("person1","address1");
		Account account = accountController.createAccount(customer,"savings");
		List<Account> allAccounts = accountController.getAccounts();
		List<Account> customerAccounts = customer.getAccounts();
		
		assertTrue(account instanceof SavingsAccount);
		assertTrue(allAccounts.contains(account));
		assertTrue(customerAccounts.contains(account));
	}
	
	@Test
	public void test_removeAccountRemovesTheAccountFromAccountControllersListOfAccounts() {
		Customer customer1 = accountController.createCustomer("person1", "address1", "person");
		Customer customer2 = accountController.createCustomer("person2", "address2", "person");
		Account account1 = accountController.createAccount(customer1,"savings");
		Account account2 = accountController.createAccount(customer1,"checking");
		Account account3 = accountController.createAccount(customer2,"savings");
		Account account4 = accountController.createAccount(customer2,"checking");
		
		accountController.removeAccount(account2);
		List<Account> allAccounts = accountController.getAccounts();

		assertEquals(3,allAccounts.size());
		assertTrue(! allAccounts.contains(account2));
		assertTrue(allAccounts.contains(account1));
		assertTrue(allAccounts.contains(account3));
		assertTrue(allAccounts.contains(account4));
	}
	
	@Test
	public void test_removeAccountRemovesTheAccountFromAccountCustomersListOfAccounts() {
		Customer customer1 = accountController.createCustomer("person1", "address1", "person");
		Customer customer2 = accountController.createCustomer("person2", "address2", "person");
		Account account1 = accountController.createAccount(customer1,"savings");
		Account account2 = accountController.createAccount(customer1,"checking");
		Account account3 = accountController.createAccount(customer2,"savings");
		Account account4 = accountController.createAccount(customer2,"checking");
		
		accountController.removeAccount(account2);
		List<Account> customer1Accounts = customer1.getAccounts();
		List<Account> customer2Accounts = customer2.getAccounts();
		
		assertEquals(1,customer1Accounts.size());
		assertEquals(2,customer2Accounts.size());
		assertTrue(! customer1Accounts.contains(account2));
		assertTrue(customer1Accounts.contains(account1));
		assertTrue(customer2Accounts.contains(account3));
		assertTrue(customer2Accounts.contains(account4));
	}
	
	@Test
	public void test_removeCustomerRemovesCustomerFromListOfCustomers() {
		Customer customer1 = accountController.createCustomer("person1", "address1", "person");
		Customer customer2 = accountController.createCustomer("person2", "address2", "person");
		accountController.createAccount(customer1,"savings");
		accountController.createAccount(customer1,"checking");
		accountController.createAccount(customer2,"savings");
		accountController.createAccount(customer2,"checking");
	
		accountController.removeCustomer(customer2);

		List<Customer> allCustomers = accountController.getCustomers();
	
		assertEquals(1,allCustomers.size());
		assertTrue(allCustomers.contains(customer1));
		assertTrue(! allCustomers.contains(customer2));
	}
	
	@Test
	public void test_removeCustomerRemovesAllOfCustomersAccountsFromListOfAccounts() {
		Customer customer1 = accountController.createCustomer("person1", "address1", "person");
		Customer customer2 = accountController.createCustomer("person2", "address2", "person");
		Account account1 = accountController.createAccount(customer1,"savings");
		Account account2 = accountController.createAccount(customer1,"checking");
		Account account3 = accountController.createAccount(customer2,"savings");
		Account account4 = accountController.createAccount(customer2,"checking");
	
		accountController.removeCustomer(customer2);

		List<Account> allAccounts = accountController.getAccounts();

		assertEquals(2,allAccounts.size());
		assertTrue(! allAccounts.contains(account3) & ! allAccounts.contains(account4));
		assertTrue(allAccounts.contains(account1) & allAccounts.contains(account2));
	}

}
