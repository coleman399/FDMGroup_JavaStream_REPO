package com.fdmgroup;

public class RomanConverter implements IRoman {
    private final int ERROR_MESSAGE = 0;
    @Override
    public int convert(String input) {
        if (input.length() != 0 && input.length() < 6 && input.isBlank() == false && input.isEmpty() == false) {
            switch (input) {
                case "I": 
                    return 1;
                case "V": 
                    return 5;
                case "X":
                    return 10;
            }
        }
        return ERROR_MESSAGE;
    }
    
}
