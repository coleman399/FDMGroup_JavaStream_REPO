package com.fdmgroup.streams_exercise;

public class BankAccount {
    private int accountNumber;
    private int bankCode;
    private String accountHolders;
    private String accountType;
    private double interestRate;
    private double balance;

    public BankAccount(int accountNumber, int bankCode, String accountHolders, String accountType, double interestRate,
            double balance) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
        this.accountHolders = accountHolders;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountHolders() {
        return accountHolders;
    }

    public void setAccountHolders(String accountHolders) {
        this.accountHolders = accountHolders;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount [accountHolders=" + accountHolders + ", accountNumber=" + accountNumber + ", accountType="
                + accountType + ", balance=" + balance + ", bankCode=" + bankCode + ", interestRate=" + interestRate
                + "]";
    }
}
