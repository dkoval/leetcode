package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">Letter Combinations of a Phone Number</a>
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= digits.length <= 4</li>
 *  <li>digits[i] is a digit in the range ['2', '9'].</li>
 * </ul>
 */
public interface LetterCombinationsOfPhoneNumber {

    List<String> letterCombinations(String digits);

    class LetterCombinationsOfPhoneNumberRev1 implements LetterCombinationsOfPhoneNumber {

        private static final Map<Character, String> mapping = new HashMap<>();

        static {
            mapping.put('2', "abc");
            mapping.put('3', "def");
            mapping.put('4', "ghi");
            mapping.put('5', "jkl");
            mapping.put('6', "mno");
            mapping.put('7', "pqrs");
            mapping.put('8', "tuv");
            mapping.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return Collections.emptyList();
            }
            List<String> ans = new ArrayList<>();
            generate(digits, 0, new StringBuilder(), ans);
            return ans;
        }

        private void generate(String digits, int idx, StringBuilder combination, List<String> ans) {
            if (combination.length() == digits.length()) {
                ans.add(combination.toString());
                return;
            }
            char digit = digits.charAt(idx);
            String letters = mapping.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                generate(digits, idx + 1, combination, ans);
                combination.deleteCharAt(combination.length() - 1); // backtrack
            }
        }
    }

    class LetterCombinationsOfPhoneNumberRev2 implements LetterCombinationsOfPhoneNumber {

        private static final String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            generate(digits, 0, new StringBuilder(), ans);
            return ans;
        }

        private void generate(String digits, int idx, StringBuilder combination, List<String> ans) {
            int n = digits.length();

            if (idx >= n) {
                if (combination.length() > 0) {
                    ans.add(combination.toString());
                }
                return;
            }

            int digit = digits.charAt(idx) - '0';
            for (char c : mapping[digit].toCharArray()) {
                combination.append(c);
                generate(digits, idx + 1, combination, ans);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
