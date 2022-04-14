package com.fdmgroup.bankDesignProject;

public class Company extends Customer {

    public Company(String name, String address) {
        super(name, address);
    }

    @Override
    public void chargeAllAccounts(double amount) {
        for (Account account : super.getAccounts()) {
            if (account instanceof SavingsAccount) {
                account.withdraw((amount + amount));
            } else {
                account.withdraw(amount);
            }
        }
        
    }
}
