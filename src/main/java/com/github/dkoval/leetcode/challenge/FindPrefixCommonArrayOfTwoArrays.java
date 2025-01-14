package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/">Find the Prefix Common Array of Two Arrays</a>
 * <p>
 * You are given two 0-indexed integer permutations A and B of length n.
 * <p>
 * A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at
 * or before the index i in both A and B.
 * <p>
 * Return the prefix common array of A and B.
 * <p>
 * A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= A.length == B.length == n <= 50</li>
 *  <li>1 <= A[i], B[i] <= n</li>
 *  <li>It is guaranteed that A and B are both a permutation of n integers.</li>
 * </ul>
 */
public interface FindPrefixCommonArrayOfTwoArrays {

    int[] findThePrefixCommonArray(int[] A, int[] B);

    // O(N) time | O(N) space
    class FindPrefixCommonArrayOfTwoArraysRev1 implements FindPrefixCommonArrayOfTwoArrays {

        @Override
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            final var n = A.length;

            final var ans = new int[n];
            final var as = new HashSet<Integer>();
            final var bs = new HashSet<Integer>();
            var common = 0;
            for (var i = 0; i < n; i++) {
                as.add(A[i]);
                bs.add(B[i]);

                if (as.contains(B[i])) {
                    common++;
                }

                if (bs.contains(A[i])) {
                    common++;
                }

                // fix double counting
                if (A[i] == B[i]) {
                    common--;
                }

                ans[i] = common;
            }
            return ans;
        }
    }

    // O(N) time | O(N) space
    class FindPrefixCommonArrayOfTwoArraysRev2 implements FindPrefixCommonArrayOfTwoArrays {

        @Override
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            final var n = A.length;

            final var ans = new int[n];
            // 1 <= A[i], B[i] <= n
            final var counts = new int[n + 1];
            for (var i = 0; i < n; i++) {
                if (++counts[A[i]] == 2) {
                    ans[i]++;
                }

                if (++counts[B[i]] == 2) {
                    ans[i]++;
                }

                ans[i] += (i > 0) ? ans[i - 1] : 0;
            }
            return ans;
        }
    }
}
