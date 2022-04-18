

import java.util.ArrayList;
import java.util.List;

public class ThreadLambdasMultipleStatement {
    public static void main(String[] args) {
        Runnable r = () -> findTenPrimeNumbers();

        Thread t = new Thread(r);
        t.start();
    }

    private static List<Integer> findTenPrimeNumbers() {
        int count = 0;
        List<Integer> numbers = new ArrayList<Integer>();
        while (count < 10) {
            if (isPrime(count) == true) {
                Integer prime = Integer.valueOf(count);
                numbers.add(prime);
                count++;
            } else {
                count++;
            }
        }
        return numbers;
    }

    private static boolean isPrime(int number) {
        if (number == 1 || number < 0)
            return false;
        for (int i = 2; i < Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }
}
