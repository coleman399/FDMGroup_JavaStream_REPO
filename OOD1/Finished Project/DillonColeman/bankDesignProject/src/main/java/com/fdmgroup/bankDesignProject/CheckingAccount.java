package com.fdmgroup.bankDesignProject;

public class CheckingAccount extends Account{
    private int nextCheckNumber;

    public int getNextCheckNumber() {
        nextCheckNumber += 1;
        return nextCheckNumber;
    }
}
