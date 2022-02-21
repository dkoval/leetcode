package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert/">Sum of Digits of Strin AfterConvert</a>
 * <p>
 * You are given a string s consisting of lowercase English letters, and an integer k.
 * <p>
 * First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26).
 * Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.
 * <p>
 * For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
 * <p>
 * Convert: "zbax" -> "(26)(2)(1)(24)" -> "262124" -> 262124
 * <p>
 * Transform #1: 262124 -> 2 + 6 + 2 + 1 + 2 + 4 -> 17
 * <p>
 * Transform #2: 17 -> 1 + 7 -> 8
 * <p>
 * Return the resulting integer after performing the operations described above.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 100</li>
 *  <li>1 <= k <= 10</li>
 *  <li>s consists of lowercase English letters</li>
 * </ul>
 */
public class SumOfDigitsOfStringAfterConvert {

    public int getLucky(String s, int k) {
        int sum = decodeThenSumDigits(s);
        while (k-- > 1) {
            sum = sumOfDigits(sum);
        }
        return sum;
    }

    private int decodeThenSumDigits(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int code = s.charAt(i) - 'a' + 1;
            sum += sumOfDigits(code);
        }
        return sum;
    }

    private int sumOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
