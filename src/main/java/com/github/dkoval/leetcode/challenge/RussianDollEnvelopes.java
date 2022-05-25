package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/russian-doll-envelopes/">Russian Doll Envelopes</a>
 * <p>
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * <p>
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * <p>
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * <p>
 * Note: You cannot rotate an envelope.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= envelopes.length <= 10^5</li>
 *  <li>envelopes[i].length == 2</li>
 *  <li>1 <= wi, hi <= 10^5</li>
 * </ul>
 */
public interface RussianDollEnvelopes {

    int maxEnvelopes(int[][] envelopes);

    class RussianDollEnvelopesTLE implements RussianDollEnvelopes {

        // O(N^2) time | O(N) space
        // Correct but fails with TLE on Leetcode
        @Override
        public int maxEnvelopes(int[][] envelopes) {
            // ~ the longest increasing subsequence DP problem
            int n = envelopes.length;
            // sort envelopes by their width in asc order
            Arrays.sort(envelopes, Comparator.comparingInt(envelop -> envelop[0]));

            // dp[i] - is the length of the longest increasing subsequence ending at i
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            int best = 1;
            for (int i = 1; i < n; i++) {
                // can we extend previous subsequences with envelopes[i]?
                for (int j = i - 1; j >= 0; j--) {
                    // width and height of envelopers[i] bust be greater than those of envelopes[j]
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                best = Math.max(best, dp[i]);
            }
            return best;
        }
    }


    // O(N*logN) time | O(N) space
    class RussianDollEnvelopesUsingBinarySearch implements RussianDollEnvelopes {

        // Resource: https://www.youtube.com/watch?v=YLUVx8lXe90
        @Override
        public int maxEnvelopes(int[][] envelopes) {
            // sort envelopes by their width in asc order & height in desc (!!!) order
            Arrays.sort(envelopes, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : b[1] - a[1]);

            // LIS of heights (remember that envelopes[] is already sorted by width)
            List<Integer> lis = new ArrayList<>();
            // use binary search for find a proper index to insert envelopes[i] into the LIS
            for (int[] envelop : envelopes) {
                int idx = findIndexOfMinValueGreaterThan(lis, envelop[1]);
                if (idx >= lis.size()) {
                    // extend LIS by appending the current envelop
                    lis.add(envelop[1]);
                } else {
                    // greedy - replace lis[idx] with a smaller envelop because it may give us a better LIS in the future
                    lis.set(idx, envelop[1]);
                }
            }
            return lis.size();
        }

        private int findIndexOfMinValueGreaterThan(List<Integer> lis, int target) {
            // Example #1:
            // lis = [0, 2, 8, 10, 12], target = 3
            //              ^ lis[2] is the smallest number that is > target
            // ---
            // Example #2:
            // lis = [0, 2, 8] _, target = 10
            //                 ^ idx = len(lis) as there's no number in lis[] that is > target
            // ---
            // Example #3:
            // lis = [0, 2, 8], target = 2 (duplicate)
            //           ^
            // ---
            // Example #4:
            // lis = [0, 2, 8], target = 8 (duplicate)
            //              ^
            if (lis.isEmpty() || lis.get(lis.size() - 1) < target) {
                return lis.size() + 1;
            }

            int left = 0;
            int right = lis.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int curr = lis.get(mid);
                if (curr >= target) {
                    // lis[mid] is a possible solution
                    // check if there's a better solution to the left of mid
                    right = mid;
                } else {
                    // lis[mid] is not a solution
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
