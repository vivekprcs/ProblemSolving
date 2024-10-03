package com.vivek.problemsolving.javacode;

import java.util.HashMap;
import java.util.Map;

public class StringDuplicate {
    public static void main(String args[]) {
        String str = "test string";
        printDups(str);
    }

    static void printDups(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), 1);
            else
                count.put(str.charAt(i),
                        count.get(str.charAt(i)) + 1);
        }
        /*Print duplicates in sorted order*/
        for (Map.Entry<Character, Integer> mapElement : count.entrySet()) {
            if (mapElement.getValue() > 1)   //if the count of characters is greater than 1 then duplicate found
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
        }
    }
}
