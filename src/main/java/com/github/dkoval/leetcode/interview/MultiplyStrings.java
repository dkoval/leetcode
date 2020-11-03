package com.github.dkoval.leetcode.interview;

/**
 * <a href="https://leetcode.com/explore/featured/card/google/59/array-and-strings/3051/">Multiply Strings</a>
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        // length of result can't exceed m + n characters (3 * 5 = 15)
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mult + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10; // carry over to the position right before
            }
        }
        // skip leading 0s
        int i = 0;
        while (result[i] == 0) i++;
        // include remaining digits in the result
        StringBuilder sb = new StringBuilder();
        while (i < result.length) {
            sb.append(result[i++]);
        }
        return sb.toString();
    }
}
