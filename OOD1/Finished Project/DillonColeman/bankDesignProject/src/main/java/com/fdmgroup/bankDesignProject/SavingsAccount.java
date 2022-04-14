package com.fdmgroup.bankDesignProject;

public class SavingsAccount extends Account {
    private double interestRate;


    public void addInterest() {
        super.balance = super.getBalance() + (super.getBalance() * interestRate / 100); 
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public double withdraw(double amount) {
        if (super.balance - amount > 0) {
            super.withdraw(amount);
            return amount;
        } 
        return 0;
    }

}
