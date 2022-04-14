package com.fdmgroup.bankDesignProject;

public abstract class Account {
    private final long ACCOUNT_ID;
    private static long nextAccountId = 995;
    protected double balance;

    public Account(){
        ACCOUNT_ID = nextAccountId += 5;
        nextAccountId = ACCOUNT_ID;
    }

    public double withdraw(double amount) {
        balance -= amount;  
        return amount;       
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void correctBalance(double amount) {
        balance = amount;
    }

    public long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public double getBalance() {
        return balance;
    }
}
