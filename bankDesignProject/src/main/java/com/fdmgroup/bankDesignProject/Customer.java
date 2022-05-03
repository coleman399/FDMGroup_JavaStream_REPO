package com.fdmgroup.bankDesignProject;

import java.util.ArrayList;

public abstract class Customer {
    private final long CUSTOMER_ID;
    private static long nextCustomerId = 1999993;
    private String name;
    private String address;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        CUSTOMER_ID = nextCustomerId += 7;
        nextCustomerId = CUSTOMER_ID;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public abstract void chargeAllAccounts(double amount);

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
