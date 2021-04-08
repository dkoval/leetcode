package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3701/">Letter Combinations of a Phone Number</a>
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
public class LetterCombinationsOfPhoneNumber {

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
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, "", result);
        return result;
    }

    private void letterCombinations(String digits, int idx, String combination, List<String> result) {
        if (combination.length() == digits.length()) {
            result.add(combination);
            return;
        }
        char digit = digits.charAt(idx);
        String letters = mapping.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            letterCombinations(digits, idx + 1, combination + letter, result);
        }
    }
}
