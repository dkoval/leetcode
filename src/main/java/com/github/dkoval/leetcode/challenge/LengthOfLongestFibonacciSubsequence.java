package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/">Length of Longest Fibonacci Subsequence</a>
 * <p>
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 * <p>
 * n >= 3
 * <p>
 * xi + xi+1 == xi+2 for all i + 2 <= n
 * <p>
 * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest
 * Fibonacci-like subsequence of arr. If one does not exist, return 0.
 * <p>
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr,
 * without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8]
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= arr.length <= 1000</li>
 *  <li>1 <= arr[i] < arr[i + 1] <= 10^9</li>
 * </ul>
 */
public interface LengthOfLongestFibonacciSubsequence {

    int lenLongestFibSubseq(int[] arr);

    class LengthOfLongestFibonacciSubsequenceRev1 implements LengthOfLongestFibonacciSubsequence {

        @Override
        public int lenLongestFibSubseq(int[] arr) {
            final var n = arr.length;

            final var uniq = new HashSet<>();
            for (var x : arr) {
                uniq.add(x);
            }

            // first 2 numbers determine a Fibonacci sequence
            var best = 0;
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    var x1 = arr[i];
                    var x2 = arr[j];

                    var length = 2;
                    var x3 = x1 + x2;
                    while (uniq.contains(x3)) {
                        length++;
                        x1 = x2;
                        x2 = x3;
                        x3 = x1 + x2;
                    }

                    if (length > 2) {
                        best = Math.max(best, length);
                    }
                }
            }
            return best;
        }
    }
}
