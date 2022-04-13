package com.fdmgroup;

import java.io.BufferedReader;
import java.io.IOException;

public class IO {
    private BufferedReader reader;
    private StringBuilder stringBuilder;
    private String string;
    
    public IO(BufferedReader reader, StringBuilder stringBuilder) throws IOException {
        this.reader = reader;
        this.stringBuilder = stringBuilder;
        this.string = reader.readLine();
    }

    public String readFile() throws IOException {
        String result;
        while (string != null) {
            stringBuilder.append(string);
            stringBuilder.append(System.lineSeparator());
            string = reader.readLine();
        }
        result = stringBuilder.toString();
        return result;
    }

    public int countChars(char c, String string) {
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }   
}
