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

    // Time complexity: O(3^N * 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
    // and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N + M is the total number digits in the input.
    // Space complexity: O(3^N * 4^M) since one has to keep 3^N * 4^M solutions.
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
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

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

    public static class LetterCombinationsOfPhoneNumberRecursiveUsingArrayToKeepMapping extends LetterCombinationsOfPhoneNumber {

        private static final char[][] mapping = new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'}
        };

        @Override
        public List<String> letterCombinations(String digits) {
            // base case
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            List<String> prev = letterCombinations(digits.substring(0, digits.length() - 1));
            if (prev.isEmpty()) {
                prev.add("");
            }

            char digit = digits.charAt(digits.length() - 1);
            char[] letters = mapping[digit  - '2'];
            for (String s : prev) {
                for (char letter : letters) {
                    result.add(s + letter);
                }
            }
            return result;
        }
    }

    public static class LetterCombinationsOfPhoneNumberIter extends LetterCombinationsOfPhoneNumber {

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
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            result.add("");
            for (int i = 0; i < digits.length(); i++) {
                char digit = digits.charAt(i);
                result = expand(result, mapping.get(digit));
            }
            return result;
        }

        private List<String> expand(List<String> result, List<Character> letters) {
            List<String> newResult = new ArrayList<>();
            for (String s : result) {
                for (char letter : letters) {
                    newResult.add(s + letter);
                }
            }
            return newResult;
        }
    }

    public static class LetterCombinationsOfPhoneNumberIterUsingArrayToKeepMapping extends LetterCombinationsOfPhoneNumber {

        private static final char[][] mapping = new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'}
        };

        @Override
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            result.add("");
            for (char digit : digits.toCharArray()) {
                result = expand(result, mapping[digit - '2']);
            }
            return result;
        }

        private List<String> expand(List<String> result, char[] letters) {
            List<String> newResult = new ArrayList<>();
            for (String s : result) {
                for (char letter : letters) {
                    newResult.add(s + letter);
                }
            }
            return newResult;
        }
    }
}
