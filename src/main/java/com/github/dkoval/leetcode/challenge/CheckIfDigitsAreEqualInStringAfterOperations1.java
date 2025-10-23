package com.github.dkoval.leetcode.challenge;

/**
 * <a hre="https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/">Check If Digits Are Equal in String After Operations I</a>
 * <p>
 * You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
 * <p>
 * For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
 * Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
 * <p>
 * Return true if the final two digits in s are the same; otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= s.length <= 100</li>
 *  <li>s consists of only digits.</li>
 * </ul>
 */
public interface CheckIfDigitsAreEqualInStringAfterOperations1 {

    boolean hasSameDigits(String s);

    class CheckIfDigitsAreEqualInStringAfterOperations1Rev1 implements CheckIfDigitsAreEqualInStringAfterOperations1 {

        @Override
        public boolean hasSameDigits(String s) {
            var curr = s;
            while (curr.length() > 2) {
                final var sb = new StringBuilder();
                for (var i = 0; i < curr.length() - 1; i++) {
                    final var digit = ((curr.charAt(i) - '0') + (curr.charAt(i + 1) - '0')) % 10;
                    sb.append(digit);
                }
                curr = sb.toString();
            }
            return curr.charAt(0) == curr.charAt(1);
        }
    }
}
