package com.github.dkoval.leetcode.interview.recursion;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/62/recursion-4/3078/">Letter Combinations of a Phone Number</a>
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public abstract class LetterCombinationsOfPhoneNumber {

    public abstract List<String> letterCombinations(String digits);

    public static class LetterCombinationsOfPhoneNumberRecursive extends LetterCombinationsOfPhoneNumber {

        private static final Map<Character, List<Character>> mapping = new HashMap<>();

        static {
            mapping.put('2', Arrays.asList('a', 'b', 'c'));
            mapping.put('3', Arrays.asList('d', 'e', 'f'));
            mapping.put('4', Arrays.asList('g', 'h', 'i'));
            mapping.put('5', Arrays.asList('j', 'k', 'l'));
            mapping.put('6', Arrays.asList('m', 'n', 'o'));
            mapping.put('7', Arrays.asList('p', 'q', 'r', 's'));
            mapping.put('8', Arrays.asList('t', 'u', 'v'));
            mapping.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }

        @Override
        public List<String> letterCombinations(String digits) {
            // base case
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }

            List<String> result = new ArrayList<>();
            List<String> prev = letterCombinations(digits.substring(0, digits.length() - 1));
            if (prev.isEmpty()) {
                prev.add("");
            }

            char digit = digits.charAt(digits.length() - 1);
            List<Character> letters = mapping.get(digit);
            for (String s : prev) {
                for (char letter : letters) {
                    result.add(s + letter);
                }
            }
            return result;
        }
    }
}
