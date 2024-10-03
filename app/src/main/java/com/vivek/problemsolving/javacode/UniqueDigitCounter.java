package com.vivek.problemsolving.javacode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueDigitCounter {

    // Function to count how many numbers have all unique digits
    static void countNumbers(List<List<Integer>> arr) {
        for (List<Integer> range : arr) {
            int n = range.get(0);
            int m = range.get(1);
            int count = 0;

            for (int i = n; i <= m; i++) {
                if (hasUniqueDigits(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // Function to check if a number has unique digits
    private static boolean hasUniqueDigits(int num) {
        String str = Integer.toString(num);
        Set<Character> digits = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (digits.contains(c)) {
                return false;
            }
            digits.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> ranges = Arrays.asList(
                Arrays.asList(80, 120) // Example range given in the image
        );

        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1, 20),
                Arrays.asList(9, 19)
        );

        countNumbers(arr);
        // Expected to print the number of valid numbers with unique digits
    }
}
