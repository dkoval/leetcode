package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/">Least Number of Unique Integers after K Removals</a>
 * <p>
 * Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= arr.length <= 10^5</li>
 * <li>1 <= arr[i] <= 10^9</li>
 * <li>0 <= k <= arr.length</li>
 * </ul>
 */
public interface LeastNumberOfUniqueIntegersAfterKRemovals {

    int findLeastNumOfUniqueInts(int[] arr, int k);

    // O(N * logN) time | O(N) space
    class LeastNumberOfUniqueIntegersAfterKRemovalsRev1 implements LeastNumberOfUniqueIntegersAfterKRemovals {

        @Override
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : arr) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            List<Integer> counts = new ArrayList<>(freq.values());
            Collections.sort(counts);

            int uniq = counts.size();
            for (int count : counts) {
                if (k == 0 || count > k) {
                    break;
                }

                uniq--;
                k -= count;
            }
            return uniq;
        }
    }
}
