package com.fdmgroup.method_module;

import java.util.Arrays;

public class Module_5 {

    public static void main(String[] args) {
        int points = getPoints("Green");
        System.out.println("You've scored " + points + " points!");
    }
    
    public static boolean leapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int getPoints(String alienColor) {
        if (alienColor.equals("Green")) {
            return 5;
        } else if (alienColor.equals("Red")) {
            return 10;
        } else if (alienColor.equals("Yellow")) {
            return 15;
        }
        return 0;
    }

    public static long sumOfNumbersUpTo(int endNumber) {
        long total = 0;

        for (int i = 0; i <= endNumber; i++) {
            total += i;
        }
        return total;
    }

    public static void displayTimesTable(int table) {
        for (int i = 0; i <= 12; i++) {
            System.out.println(i + " x " + table + " = " + (i * table));
        }
    }

    public static int arrayFrequency(int[] array, int number) {
        int count = 0;

        for (int element : array) {
            if (element == number ){
                count ++;
            }
        }
        return count;
    }

    public int maxNumber(int[] array) {
        Arrays.sort(array);
        int highestIndex = array.length - 1;
        int maximum = array[highestIndex];
        return maximum;        
    }

    public static int[] extractEvenArray(int[] array){
        int newArrayLength = 0;
        for (int number : array){
            if (number % 2 == 0) {
                newArrayLength ++;
            }
        }
        int[] evenNumbers = new int[newArrayLength];
        int evenNumberIndex = 0;
        for (int number : array) {
            if (number % 2 == 0) {
                evenNumbers[evenNumberIndex] = number;
                evenNumberIndex ++;
            }
        }
        return evenNumbers;
    }

    public static String[] reverseStringArray(String[] array) {
        int length = array.length;
        String[] reversed = new String[length];
        
        for (int i = 0; i < length; i++) {
            int reversedIndex = length - 1 - i;
            reversed[reversedIndex] = array[i];
        }

        return reversed;
    }

    public static boolean isAnagram(String string1, String string2) {
        char[] string1Array = string1.toCharArray();
        char[] string2Array = string2.toCharArray();

        Arrays.sort(string1Array);
        Arrays.sort(string2Array);

        string1 = new String(string1Array);
        string2 = new String(string2Array);

        return string1.equals(string2);
    }

    public double medianNumber(double[] numbers) {
        Arrays.sort(numbers);
        int middleIndex = numbers.length / 2;

        if (numbers.length % 2 == 0) {
            return (numbers[middleIndex] + numbers[middleIndex - 1]) / 2;
        } else {
            return numbers[middleIndex];
        }
    }
}
