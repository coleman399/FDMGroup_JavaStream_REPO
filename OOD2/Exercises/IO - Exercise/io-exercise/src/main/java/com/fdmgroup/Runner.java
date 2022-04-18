package com.fdmgroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        try {
            File file = new File("MyTestFile.txt");
            if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
            } else {
                    System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
        try {
            FileWriter myWriter = new FileWriter("MyTestFile.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        try {
            IO questionOne = new IO(new BufferedReader(new FileReader("MyTestFile.txt")), new StringBuilder());
            System.out.println("Number of character 'i' in MyTestFile.txt: " + questionOne.countChars('i', questionOne.readFile()));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File file = new File("QuestionTwoFile.txt");
            if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
            } else {
                    System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("QuestionTwoFile.txt", true);
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please provide a username: ");
            String userName = userInput.nextLine();
            System.out.println("Please provide your address: ");
            String userAddress = userInput.nextLine();
            System.out.println("Please provide your email: ");
            String userEmail = userInput.nextLine();
            myWriter.write("USER: " + userName + " ADDRESS: " + userAddress + " EMAIL: " + userEmail + "\n");
            myWriter.close();
            userInput.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File file = new File("QuestionTwoFile.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
