package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/">Integer to Roman</a>
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <ul>
 *  <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 *  <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 *  <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
public class IntegerToRoman {
    private static final Map<Integer, String> nums = new LinkedHashMap<>();
    private static final Map<Integer, String> digits = new HashMap<>();

    static {
        // x >= 10
        nums.put(1000, "M");
        nums.put(900, "CM");
        nums.put(500, "D");
        nums.put(400, "CD");
        nums.put(100, "C");
        nums.put(90, "XC");
        nums.put(50, "L");
        nums.put(40, "XL");
        nums.put(10, "X");
        // x < 10
        digits.put(1, "I");
        digits.put(2, "II");
        digits.put(3, "III");
        digits.put(4, "IV");
        digits.put(5, "V");
        digits.put(6, "VI");
        digits.put(7, "VII");
        digits.put(8, "VIII");
        digits.put(9, "IX");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 10) {
            for (Map.Entry<Integer, String> entry : nums.entrySet()) {
                int x = entry.getKey();
                String roman = entry.getValue();
                if (num >= x) {
                    int times = num / x;
                    append(sb, roman, times);
                    num %= x;
                }
            }
        }
        if (num != 0) {
            append(sb, digits.get(num), 1);
        }
        return sb.toString();
    }

    private static void append(StringBuilder sb, String roman, int times) {
        while (times-- > 0) {
            sb.append(roman);
        }
    }
}
