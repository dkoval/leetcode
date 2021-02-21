package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/">Roman to Integer</a>
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <ul>
 *  <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 *  <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 *  <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 15</li>
 *  <li>s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').</li>
 *  <li>It is guaranteed that s is a valid roman numeral in the range [1, 3999].</li>
 * </ul>
 */
public class RomanToInteger {

    private static final Map<Character, Integer> mapping = new HashMap<>();

    static {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        int prev = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = mapping.get(s.charAt(i));
            if (curr < prev) {
                num -= curr;
            } else {
                num += curr;
            }
            prev = curr;
        }
        return num;
    }
}
