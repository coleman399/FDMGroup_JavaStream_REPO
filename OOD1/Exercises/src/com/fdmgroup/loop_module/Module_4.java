package com.fdmgroup.loop_module;

import java.util.ArrayList;
import java.util.Arrays;

public class Module_4 {
    public static void main(String[] args) {
        String[] strings = {"string1","string2","string3"};

        for (String string : strings) {
            System.out.println(string);
        }

        ArrayList<String> arrayListStrings = new ArrayList<String>(Arrays.asList("string1", "string2", "string3"));

        for (String string : arrayListStrings) {
            System.out.println(string);
        }

        for (char letter = 'a'; letter <= 'z'; letter++) {
            System.out.println(letter);
        }

        String[] courses = {"UNIX","SQL","java","Python","Web Apps"};

        for (String course : courses) {
            System.out.println("I love learning "+ course);
        }

        ArrayList<String> courseList = new ArrayList<String>();

        for (String course: courses){
            courseList.add(course);
        }

        ArrayList<Double> prices = new ArrayList<Double>();
        
        prices.add(4.50);
        prices.add(1.99);
        prices.add(9.75);
        prices.add(3.15);
        prices.add(10.25);

        double total = 0.0;

        for(double price : prices){
            total += price;
        }

        System.out.println(total);

        double[] priceArray = new double[5];

        int index = 0;

        for(double price : prices){
            priceArray[index] = price;
            index ++;
        }

        String string = "10,7,25,3,8";

        String[] numbers = string.split(",");
        
        total = 0;

        for (String number : numbers){
            total += Integer.parseInt(number);
        }

        System.out.println(total);

        String reverseString = "desrever neeb sah txet siht";

        char[] reverseStringChar = reverseString.toCharArray();

        String reversed = "";

        for (char letter : reverseStringChar){
            reversed = letter + reversed;
        }

        System.out.println(reversed);
        
        //Best way to reverse a string
        for (int i = reverseString.length() - 1; i >= 0; i--){
            reversed += reverseString.charAt(i);
        } 

        System.out.println(reversed);

        // Print 1 through 1000000
        for (int i = 0; i <= 1000000; i++){
            System.out.println(i);
        }

        // Summing a million
        Long longTotal = Long.valueOf(1000000);

        for (int i = 0; i <= 100000; i++){
            longTotal += i;
        }
        
        System.out.println(longTotal);
        
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " x 3 = " + (i * 3));
        }

        int[] scores = {25,15,99,75,47,59,82};

        for(int i = 1; i < scores.length; index +=2) {
            scores[i] ++;
        }

        for(int i = 0; i < scores.length; i ++) {
            System.out.println(scores[i]);
        }

        for(char letter = 'b'; letter <= 'z'; letter +=2){
            System.out.println(letter);
        }

        int previousNumber = 1;
        int currentNumber = 0;

        while(currentNumber <= 1000){
            System.out.println(currentNumber);
            int temp = currentNumber;
            currentNumber += previousNumber;
            previousNumber = temp;
        }

        String[] cities = {"Glasgow", "London", "Birmingham", "Cardiff", "Manchester", "Newcastle"};

        for (String city : cities){
            if (city.charAt(0) == 'B'){
                System.out.println(city + " - match");
            } else {
                System.out.println(city + " - doesn't match");
            }
        }

        int[] numberArray = {6, 15, 75, 32, 89, 24, 103, 17, 5, 250, 63, 91};

        for (int number : numberArray){
            if(number > 100){
                System.out.println(number);
                break;
            }
        }
    }
}
