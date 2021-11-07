package com.github.dkoval.leetcode.interview;

/**
 * <a href="https://leetcode.com/explore/featured/card/google/59/array-and-strings/3051/">Multiply Strings</a>
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    // O(L1 * L2) time | O(L1 + L2) space
    // Resource: https://www.youtube.com/watch?v=1vZswirL8Y8
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();

        // length of result can't exceed l1 + l2 characters (3 * 5 = 15)
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = prod + ans[i + j + 1];

                int digit = sum % 10;
                int carry = sum / 10;
                ans[i + j + 1] = digit;
                ans[i + j] += carry; // carry over to the position right before
            }
        }

        // skip leading 0s
        int i = 0;
        while (ans[i] == 0) i++;

        // include remaining digits in the result
        StringBuilder sb = new StringBuilder();
        while (i < ans.length) {
            sb.append(ans[i++]);
        }
        return sb.toString();
    }
}
