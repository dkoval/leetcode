package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3569/">4Sum II</a>
 * <p>
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
 */
public class FourSum2 {

    // O(N^2) time | O(N^2) space
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                int count = sums.getOrDefault(sum, 0);
                sums.put(sum, count + 1);
            }
        }

        int answer = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                answer += sums.getOrDefault(-sum, 0);
            }
        }
        return answer;
    }
}
