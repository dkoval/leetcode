package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/">Smallest String With A Given Numeric Value</a>
 * <p>
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet,
 * so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * <p>
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values.
 * For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 * <p>
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 * <p>
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is,
 * either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>n <= k <= 26 * n</li>
 * </ul>
 */
public interface SmallestStringWithGivenNumericValue {

    String getSmallestString(int n, int k);

    class SmallestStringWithGivenNumericValueGreedyRev1 implements SmallestStringWithGivenNumericValue {

        @Override
        public String getSmallestString(int n, int k) {
            // Idea: greedy, build the string from the end to the beginning
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                if (n % k == 0) {
                    sb.append('a');
                    k--;
                } else {
                    int i = 26;
                    while (k - i < n - 1) {
                        i--;
                    }
                    sb.append((char)('a' + i - 1));
                    k -= i;
                }
                n--;
            }
            return sb.reverse().toString();
        }
    }
}
