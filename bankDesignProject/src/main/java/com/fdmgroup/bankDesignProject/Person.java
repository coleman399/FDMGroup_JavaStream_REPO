package com.fdmgroup.bankDesignProject;

public class Person extends Customer {

    public Person(String name, String address) {
        super(name, address);
    }

    @Override
    public void chargeAllAccounts(double amount) {
        for (Account account : super.getAccounts()) {
            account.withdraw(amount);
        }
    }

}
