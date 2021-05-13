package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3741/">Ambiguous Coordinates</a>
 * <p>
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we removed all commas, decimal points,
 * and spaces, and ended up with the string s.  Return a list of strings representing all possibilities for what our
 * original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00",
 * "1.0", "001", "00.01", or any other number that can be represented with less digits. Also, a decimal point within
 * a number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order. Also note that all coordinates in the final answer have exactly
 * one space between them (occurring after the comma).
 * <p>
 * Note:
 * <ul>
 *  <li>4 <= s.length <= 12.</li>
 *  <li>s[0] = "(", s[s.length - 1] = ")", and the other elements in s are digits.</li>
 *  </ul>
 */
public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        // remove '(' and ')' brackets from s
        String str = s.substring(1, s.length() - 1);

        List<String> result = new ArrayList<>();
        for (int commaIdx = 1; commaIdx < str.length(); commaIdx++) {
            String x = str.substring(0, commaIdx);
            String y = str.substring(commaIdx);

            List<String> xs = possibleNumbers(x);
            List<String> ys = possibleNumbers(y);

            // compute cartesian product xs * ys
            for (String px : xs) {
                for (String py : ys) {
                    result.add(String.format("(%s, %s)", px, py));
                }
            }
        }
        return result;
    }

    private List<String> possibleNumbers(String n) {
        List<String> result = new ArrayList<>();
        if (!hasLeadingZero(n)) {
            result.add(n);
        }
        for (int decimalPointIdx = 1; decimalPointIdx < n.length(); decimalPointIdx++) {
            String whole = n.substring(0, decimalPointIdx);
            String fraction = n.substring(decimalPointIdx);
            if (!hasLeadingZero(whole) && !hasTrailingZero(fraction)) {
                result.add(String.format("%s.%s", whole, fraction));
            }
        }
        return result;
    }

    // Sequences, like "00", "0.0", "001", "00.01", are not allowed; "0" is a valid one though
    private boolean hasLeadingZero(String n) {
        return n.length() > 1 && n.charAt(0) == '0';
    }

    // Sequences, like "0.0", "0.00", "1.0", are not allowed
    private boolean hasTrailingZero(String n) {
        return !n.isEmpty() && n.charAt(n.length() - 1) == '0';
    }
}
