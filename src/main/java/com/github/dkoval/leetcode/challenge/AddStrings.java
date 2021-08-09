package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/">Add Strings</a>
 *
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 */
public class AddStrings {

    // O(max(N1, N2)) time | O(max(N1, N2)) space
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += num1.charAt(p1--) - '0';
            }

            if (p2 >= 0) {
                sum += num2.charAt(p2--) - '0';
            }

            int digit = sum % 10;
            carry = sum / 10;
            sb.append(digit);
        }

        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
