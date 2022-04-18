

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

        // 1.2 Writing lambdas to implement functional interfaces

        /**
         * 1. Write a lambda expression which implements the Function interface. It
         * should take a bank account as an argument and return a String containing the
         * customer’s name and balance. Test using account3 (should return “Dr T
         * Williams: 4763.32”) and account4 (should return “Ms S Taylor: 10598.01”)
         */

        Function<BankAccount, String> getNameAndBalance = account -> account.getAccountHolders() + " "
                + account.getBalance();

        System.out.println("1A: " + getNameAndBalance.apply(account3));
        System.out.println("1B: " + getNameAndBalance.apply(account4));

        /**
         * 2. Write a lambda expression which implements the Function interface. It
         * should take a bank account as an argument and return a double containing the
         * amount of interest due on the account. This can be calculated as follows:
         * balance * interest rate / 100. Test this using account2. It should return
         * 1.1.
         */

        Function<BankAccount, Double> getInterestDue = account -> account.getBalance() * account.getInterestRate()
                / 100;

        System.out.println("2: " + getInterestDue.apply(account2));

        /**
         * 3. Write a modified version of your previous lambda expression which returns
         * 0 if the account is overdrawn. Test with account2 (should return 1.1) and
         * account8 (should return 0.0). You will need to use a ternary operator.
         */

        Function<BankAccount, Double> getInterestDueReturnsZeroIfAccountIsOverdrawn = account -> account.getBalance()
                * account.getInterestRate()
                / 100 > 0 ? getInterestDue.apply(account) : 0.0;

        System.out.println("3A: " + getInterestDueReturnsZeroIfAccountIsOverdrawn.apply(account2));
        System.out.println("3B: " + getInterestDueReturnsZeroIfAccountIsOverdrawn.apply(account8));

        /**
         * 4. Write a lambda expression which implements the Predicate interface. It
         * should take a bank account as an argument. If the bank account is a current
         * account the expression should return true, otherwise it should return false.
         * Test with account1 (should return false) and account6 (should return true)
         */

        CharSequence current = "current";
        Predicate<BankAccount> getCurrentAccounts = account -> account.getAccountType().contains(current);

        System.out.println("4A: " + getCurrentAccounts.test(account1));
        System.out.println("4B: " + getCurrentAccounts.test(account6));

        /**
         * 5. Write a lambda expression which implements the Predicate interface. It
         * should take a bank account as an argument. If the bank account is overdrawn
         * it should return true, otherwise it should return false. Test with account5
         * (should return true) and account7 (should return false)
         */

        Predicate<BankAccount> isAccountOverdrawn = account -> account.getBalance() < 0 ? true : false;

        System.out.println("5A: " + isAccountOverdrawn.test(account5));
        System.out.println("5B: " + isAccountOverdrawn.test(account7));

        /**
         * 6. Write a lambda expression which implements the BinaryOperator interface.
         * It should take 2 bank accounts as arguments and return the bank account which
         * has the highest balance. Test using account3 and account4 as arguments, it
         * should return account4 (balance is 10598.01). You will need to use a ternary
         * operator.
         */

        BinaryOperator<BankAccount> getHighestBalance = (acc1, acc2) -> acc1.getBalance() > acc2.getBalance() ? acc1
                : acc2;

        System.out.println("6: " + getHighestBalance.apply(account3, account4));

        /**
         * 7. Write a lambda expression which implements the Consumer interface. It
         * should take a bank account as an argument. It should then deduct a £10 fee
         * from the balance. Test using account2 and account6. Call the getBalance()
         * method on the two objects to check that their balances have been updated
         * (account2 should be 540.0 and account6 should be -513.47).
         */

        Consumer<BankAccount> deduct10FromBalance = account -> account.setBalance(account.getBalance() - 10);

        deduct10FromBalance.accept(account2);
        System.out.println("7A: " + account2.getBalance());
        deduct10FromBalance.accept(account6);
        System.out.println("7B: " + account6.getBalance());

        /**
         * 8. Write a lambda expression which implements the BiConsumer interface. It
         * should take 2 arguments: a bank account and an integer. It should deduct the
         * integer value from the account’s balance. Test using account1 and 100. The
         * getBalance() method should show that account1’s balance is now 25262.91. Also
         * test with account5 and 50. The balance afterwards should be -245.74
         */

        BiConsumer<BankAccount, Integer> deductFromBalance = (account, amountDeducted) -> account
                .setBalance(account.getBalance() - amountDeducted);

        deductFromBalance.accept(account1, 100);
        System.out.println("8A: " + account1.getBalance());
        deductFromBalance.accept(account5, 50);
        System.out.println("8B: " + account5.getBalance());

        // 1.3 Writing lambdas for List methods

        /**
         * 1. Create an ArrayList of type BankAccount. Add all the BankAccount objects
         * to it.
         */

        List<BankAccount> bankAccounts = new ArrayList<>(
                Arrays.asList(account1, account2, account3, account4, account5, account6,
                        account7, account8));

        /**
         * 2. Call the ArrayList’s forEach method using a lambda expression to display
         * the account number, account holder, their account type and their balance.
         */

        bankAccounts.forEach(account -> {
            System.out.println("2. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 3. Call the ArrayList’s forEach method using a lambda expression to deduct
         * £10 from each account’s balance. Test by running the code from question 2.
         */

        bankAccounts.forEach(account -> {
            account.setBalance(account.getBalance() - 10);
        });

        bankAccounts.forEach(account -> {
            System.out.println("3. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 4. Call the ArrayList’s removeIf method using a lambda expression to remove
         * accounts which are overdrawn by more than £500. Test by running the code from
         * question 2.
         */
        Predicate<BankAccount> isAccountOverdrawnBy500 = account -> account.getBalance() <= -500 ? true : false;
        bankAccounts.removeIf(isAccountOverdrawnBy500);

        bankAccounts.forEach(account -> {
            System.out.println("4. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 5. Call the ArrayList’s removeIf method using a lambda expression to remove
         * savings accounts. Test by running the code from question 1.
         */

        CharSequence savings = "savings";
        Predicate<BankAccount> getSavingsAccounts = account -> account.getAccountType().contains(savings);
        bankAccounts.removeIf(getSavingsAccounts);

        bankAccounts.forEach(account -> {
            System.out.println("5. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        // 1.4 Writing lambdas for Comparators

        /**
         * 1. Write a lambda expression to implement the Comparator interface. It should
         * sort the ArrayList by account balance. Pass the comparator into the
         * ArrayList’s sort method. Test by running the code from question 1.3.2.
         */

        Comparator<BankAccount> sortByAccountBalance = new Comparator<BankAccount>() {

            @Override
            public int compare(BankAccount o1, BankAccount o2) {
                if (o1.getBalance() > o2.getBalance()) {
                    return 1;
                } else {
                    return 0;
                }
            }

        };
        bankAccounts.sort(sortByAccountBalance);
        bankAccounts.forEach(account -> {
            System.out.println("1. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 2. Write a lambda expression to implement the Comparator interface. It should
         * sort the ArrayList by account type. Pass the comparator into the ArrayList’s
         * sort method. Test by running the code from question 1.3.2.
         */

        Comparator<BankAccount> sortByAccountType = new Comparator<BankAccount>() {

            @Override
            public int compare(BankAccount o1, BankAccount o2) {
                if (o1.getAccountType().equals(o2.getAccountType())) {
                    return 1;
                } else {
                    return 0;
                }
            }

        };
        bankAccounts.sort(sortByAccountType);
        bankAccounts.forEach(account -> {
            System.out.println("2. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 3. Write a lambda expression to implement the Comparator interface. It should
         * sort the ArrayList by account number. Pass the comparator into the
         * ArrayList’s sort method. Test by running the code from question 1.3.2.
         */

        Comparator<BankAccount> sortByAccountNumber = new Comparator<BankAccount>() {

            @Override
            public int compare(BankAccount o1, BankAccount o2) {
                if (o1.getAccountNumber() > o2.getAccountNumber()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        bankAccounts.sort(sortByAccountNumber);
        bankAccounts.forEach(account -> {
            System.out.println("3. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        /**
         * 4. Combine the comparators from questions 1 and 2 to make a new comparator
         * which sorts by account type and then account balance. Test by running the
         * code from question 1.3.2.
         */

        Comparator<BankAccount> sortByAccountTypeAndBalance = sortByAccountType.thenComparing(sortByAccountType);
        bankAccounts.sort(sortByAccountTypeAndBalance);
        bankAccounts.forEach(account -> {
            System.out.println("4. | account number: " + account.getAccountNumber() + " account holder: "
                    + account.getAccountHolders() + " account type: " + account.getAccountType()
                    + " account balance: "
                    + account.getBalance());
        });

        // 1.5 Writing lambdas for Map.merge()

        /**
         * 1. Create a Map of type <Integer,Integer>. The key will represent the bank
         * code. The value will represents the number of bank accounts for that bank
         * code.
         */

        Map<Integer, Integer> accountMap = new HashMap<>();
        bankAccounts.forEach(account -> {
            accountMap.put(account.getBankCode(), accountMap.getOrDefault(account.getBankCode(), 0));
        });

        /**
         * 2. Loop through the List of bank accounts. Use the Map.merge() method to
         * populate the Map. Do not use the put method.
         */

        BiFunction<Integer, Integer, Integer> addToCount = (currentValue, amountToAdd) -> currentValue + amountToAdd;
        bankAccounts.forEach(account -> accountMap.merge(account.getBankCode(), 1, addToCount));

        /**
         * 3. Create another Map, this time of type <Integer,Double>. The key will
         * represent the bank code. The value will represent the sum of the account
         * balances for that bank code.
         */

        Map<Integer, Double> secondBankMap = new HashMap<>();

        /**
         * 4. Loop through the List of bank accounts. Use the Map.merge() method to
         * populate the Map. Do not use the put method.
         */

        BiFunction<Double, Double, Double> sumOfBalance = (currentValue, amountToAdd) -> currentValue + amountToAdd;
        bankAccounts.forEach(account -> secondBankMap.merge(account.getBankCode(), account.getBalance(), sumOfBalance));

    }
}
