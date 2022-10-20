package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
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
public interface IntegerToRoman {

    String intToRoman(int num);

    class IntegerToRomanRev1 implements IntegerToRoman {

        private static final Map<Integer, String> lookup = new LinkedHashMap<>();

        static {
            lookup.put(1000, "M");
            lookup.put(900, "CM");
            lookup.put(500, "D");
            lookup.put(400, "CD");
            lookup.put(100, "C");
            lookup.put(90, "XC");
            lookup.put(50, "L");
            lookup.put(40, "XL");
            lookup.put(10, "X");
            lookup.put(9, "IX");
            lookup.put(5, "V");
            lookup.put(4, "IV");
            lookup.put(1, "I");
        }

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : lookup.entrySet()) {
                int x = entry.getKey();
                String roman = entry.getValue();
                if (num >= x) {
                    int times = num / x;
                    repeat(sb, roman, times);
                    num %= x;
                }
            }
            return sb.toString();
        }

        private void repeat(StringBuilder sb, String roman, int times) {
            while (times-- > 0) {
                sb.append(roman);
            }
        }
    }

    class IntegerToRomanRev2 implements IntegerToRoman {

        private static final Map<Integer, Character> lookup = new HashMap<>();

        static {
            lookup.put(1000, 'M');
            lookup.put(500, 'D');
            lookup.put(100, 'C');
            lookup.put(50, 'L');
            lookup.put(10, 'X');
            lookup.put(5, 'V');
            lookup.put(1, 'I');
        }

        @Override
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            num = process(sb, num, 1000);
            num = process(sb, num, 100);
            num = process(sb, num, 10);
            process(sb, num, 1);
            return sb.toString();
        }

        private int process(StringBuilder sb, int num, int multiple) {
            if (num >= multiple) {
                char symbol = lookup.get(multiple);
                int x = num / multiple;
                if (x < 4) {
                    repeat(sb, symbol, x);
                } else  {
                    char mid = lookup.get(5 * multiple);
                    if (x == 4) {
                        sb.append(symbol);
                        sb.append(mid);
                    } else if (x < 9) {
                        sb.append(mid);
                        repeat(sb, symbol, x - 5);
                    } else /* if (x == 9) */ {
                        char next = lookup.get(10 * multiple);
                        sb.append(symbol);
                        sb.append(next);
                    }
                }
                num %= multiple;
            }
            return num;
        }

        private void repeat(StringBuilder sb, char symbol, int times) {
            while (times-- > 0) {
                sb.append(symbol);
            }
        }
    }
}
