
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Module_3 {
    public static void main(final String[] args) {
        Random random = new Random();
        ArrayList<String> alienColour = new ArrayList<String>(Arrays.asList("green", "yellow", "red"));
        int playerScore = 0;
        int playerChoice = random.nextInt(3);

        if (alienColour.get(playerChoice).equals("green")) {
            playerScore = playerScore + 5;
            System.out.println(playerScore);
        } else if (alienColour.get(playerChoice).equals("yellow")) {
            playerScore = playerScore + 15;
            System.out.println(playerScore);
        } else if (alienColour.get(playerChoice).equals("red")){
            playerScore = playerScore + 10;
            System.out.println(playerScore);
        } else {
            System.out.println("invalid colour");
        }

        int age = random.nextInt(100);

        if (age < 2) {
            System.out.println("Person is a baby");
        } else if (age >= 2 && age < 4) {
            System.out.println("Person is a toddler");
        } else if (age >= 4 && age < 13) {
            System.out.println("Person is a child");
        } else if (age >= 13 && age < 20) {
            System.out.println("Person is a teenager");
        } else if (age >= 20 && age < 65) {
            System.out.println("Person is working age");
        } else {
            System.out.println("Person is a pensioner");
        }

        int salary = random.nextInt(200000);

        if (salary > 150000) {
            System.out.println("45%");
        } else if (salary > 50000 && salary <= 150000) {
            System.out.println("40%");
        } else if (salary > 12500 && salary <= 50000) {
            System.out.println("20%");
        } else {
            System.out.println("0%");
        }

        int high = 999;
        int low = 100;

        int pinNum = random.nextInt(high - low) + low;

        if (pinNum > 500 && pinNum < 700) {
            System.out.println("valid pin");
        } else {
            System.out.println("invalid pin");
        }
        
        String flightCode = "BA5678";
        String airlineCode = flightCode.substring(0,2);

        if (airlineCode.equals("LH") || flightCode.equals("BA") || flightCode.equals("FR")) {
            System.out.println("valid airline");
        } else {
            System.out.println("invalid airline");
        }

        boolean validPassport = false;
        boolean validDriversLicense = true;

        if (validPassport || validDriversLicense) {
            System.out.println("ID verified");
        } else {
            System.out.println("Unable to verify ID");
        }

        boolean hasLicense = true;
        boolean isDead = true;
        boolean hasPassedEyeTest = true;

        if (hasLicense && ! isDead && hasPassedEyeTest) {
            System.out.println("can drive");
        } else {
            System.out.println("not licensed to drive");
        }
    }   
}