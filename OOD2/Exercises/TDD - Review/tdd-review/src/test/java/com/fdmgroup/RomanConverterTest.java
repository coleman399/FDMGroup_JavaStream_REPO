package com.fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RomanConverterTest {
    private int testCount = 0;
    
    @Test
    public void convert_ConvertStringRomanInputToInt_ReturnInt() {
        int result = 16;
        RomanConverter romanConverter = new RomanConverter();
        ArrayList<String> inputList = new ArrayList<String>();
        inputList.add("I");
        inputList.add("V");
        inputList.add("X");
        for (String input : inputList) {
            addToCount(romanConverter.convert(input));
        }
        assertEquals(result, this.testCount);                  
    }

    

    public int addToCount(int value) {
        this.testCount = this.testCount + value;
        return testCount;
    }
}
