package com.fdmgroup.streams_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
        BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Smith", "current/checking", 0.2, 550);
        BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4769.32);
        BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
        BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current/checking", 0.2, -195.74);
        BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current/checking", 0.2, -503.47);
        BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
        BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current/checking", 0.2, -947.72);

        List<BankAccount> accounts = new ArrayList<>(
                Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));
        System.out.println(accounts.size());

        // 1.2 Use streams to find the following information

        // 1. The number of current/checking accounts in the ArrayList.
        long numberOfCurrentCheckingAccounts = accounts.stream()
                .filter(account -> account.getAccountType().equals("current/checking")).count();
        System.out.println(numberOfCurrentCheckingAccounts);

        // 2. The number of accounts which are overdrawn.
        long numberOfOverdrawnAccounts = accounts.stream().filter(account -> account.getBalance() < 0).count();
        System.out.println(numberOfOverdrawnAccounts);

        // 3. The highest account balance.
        BinaryOperator<BankAccount> highestBalance = (firstAccount,
                secondAccount) -> firstAccount.getBalance() > secondAccount.getBalance() ? firstAccount : secondAccount;
        System.out.println(highestBalance);

        // 4. The average account balance.
        OptionalDouble optionalAverageBalance = accounts.stream().mapToDouble(account -> account.getBalance())
                .average();
        System.out.println("optional average balance: " + optionalAverageBalance);

        // 5. The average balance of accounts which are in credit.
        OptionalDouble optionalAverageBalanceOfPositiveAccounts = accounts.stream()
                .filter(account -> account.getBalance() > 0).mapToDouble(account -> account.getBalance()).average();
        System.out
                .println("optional average balance of positive accounts: " + optionalAverageBalanceOfPositiveAccounts);

        // 6. The sum of all overdrafts.
        Double sumOfAllOverdrafts = accounts.stream().filter(account -> account.getBalance() < 0)
                .map(account -> account.getBalance()).reduce(0.0, (subtotal, balance) -> subtotal + balance);
        System.out.println("sum of all overdrafts: " + sumOfAllOverdrafts);

        // 7. The total amount interest due to be paid to accounts which are in credit.
        Double test = accounts.stream().filter(account -> account.getBalance() < 0)
                .collect(Collectors.reducing(0.0, account -> account.getBalance() * account.getInterestRate(),
                        (subtotal, balance) -> subtotal + balance));
        System.out.println("total interest due to be paid to accounts which are in credit: " + test);

    }
}
