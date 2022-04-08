package com.fdmgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class CollectionsTest {
    
    // Test One
    @Test
    public void eliminateDuplicates_TakesMultipleFirstNamesAndRemovesDuplicates_ReturnSet() {
        Collections collections = new Collections();
        String name = "name";
        ArrayList<String> set = new ArrayList<String>();
        Set<String> result = new HashSet<String>();
        set.add(name);
        set.add(name);
        set.add(name);
        result.add(name);
        assertEquals(result, collections.eliminateDuplicates(set));
    }

    // Test Two
    @Test
    public void getColorHashMap_ReturnsColorHashMap() {
        Collections collections = new Collections();
        HashMap<String, Object> colorHashMap = new HashMap<String, Object>();
        colorHashMap.put("Black", Color.BLACK);
        colorHashMap.put("Blue", Color.BLUE);
        colorHashMap.put("Cyan", Color.CYAN);
        colorHashMap.put("Dark Grey", Color.DARK_GRAY);
        colorHashMap.put("Grey", Color.GRAY);
        colorHashMap.put("Green", Color.GREEN);
        colorHashMap.put("Light Grey", Color.LIGHT_GRAY);
        colorHashMap.put("Magenta", Color.MAGENTA);
        colorHashMap.put("Orange", Color.ORANGE);
        colorHashMap.put("Pink", Color.PINK);
        colorHashMap.put("Red", Color.RED);
        colorHashMap.put("White", Color.WHITE);
        colorHashMap.put("Yellow", Color.YELLOW);
        assertEquals(colorHashMap, collections.getColorHashMap());
    }

    // Test Three
    @Test
    public void countLetterOccurrencesInString_TakesStringCountsOccurrencesOfLetters_ReturnsObject() {
        Collections collections = new Collections();
        String string = "aabbccdd";
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        result.put('a', 2);
        result.put('b', 2);
        result.put('c', 2);
        result.put('d', 2);
        assertEquals(result, collections.countLetterOccurrencesInString(string));
    }

    // Test Four
    @Test
    public void countWordOccurrencesInString_TakesStringCountsOccurrencesOfWords_ReturnsObject() {
        Collections collections = new Collections();
        String string = "I am Dillon, I am a Programmer, I am Tired";
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("I", 3);
        result.put("am", 3);
        result.put("Dillon,", 1);
        result.put("Programmer,", 1);
        result.put("Tired", 1);
        result.put("a", 1);
        assertEquals(result, collections.countWordOccurrencesInString(string));
    }

    // Test Five
    @Test
    public void reverseLinkedList_TakesLinkedListReversesLinkedLink_ReturnsLinkedList() {
        Collections collections = new Collections();
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        result.add(5);
        result.add(4);
        result.add(3);
        result.add(2);
        result.add(1);
        assertEquals(result, collections.reverseLinkedList(list));
    }

    // Test Six
    @Test
    public void tokenizeString_TakesStringSplitsItIntoWordsAddsWordsToTreeSet_ReturnsTreeSet() {
        Collections collections = new Collections();
        String string = "Hello my name is Dillon";
        TreeSet<String> result = new TreeSet<String>();
        result.add("Hello");
        result.add("my");
        result.add("name");
        result.add("is");
        result.add("Dillon");
        assertEquals(result, collections.tokenizeString(string));
    }
}
