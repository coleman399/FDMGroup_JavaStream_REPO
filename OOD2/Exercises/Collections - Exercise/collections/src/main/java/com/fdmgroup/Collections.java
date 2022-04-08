package com.fdmgroup;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Collections {
    public Set<String> eliminateDuplicates(ArrayList<String> list) {
        Set<String> result = new HashSet<String>();
        result.addAll(list);
        return result;
    }

    public HashMap<String, Object> getColorHashMap() {
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
        return colorHashMap;
    }

    public Object countLetterOccurrencesInString(String string) {
        char[] charArray = string.toCharArray();
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (char c : charArray) {
            if(result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            } else { 
                result.put(c, 1);
            }
        }
        return result;
    }

    public Object countWordOccurrencesInString(String string) {
        String[] words = string.split(" ");
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (String word : words) {
            if(result.get(word) != null) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

    public LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for(int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    public TreeSet<String> tokenizeString(String string) {
        TreeSet<String> result = new TreeSet<String>();
        String[] tokens = string.split(" ");
        for(String token : tokens) {
            result.add(token);
        }
        return result;
    }
}
