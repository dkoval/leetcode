package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn/">Delete and Earn</a>
 * <p>
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following
 * operation any number of times:
 * <p>
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to
 * nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2 * 10^4</li>
 * <li>1 <= nums[i] <= 10^4</li>
 * </ul>
 */
public interface DeleteAndEarn {

    int deleteAndEarn(int[] nums);

    // O(N * logN) time | O(N) space
    class DeleteAndEarnDPTopDown implements DeleteAndEarn {

        @Override
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            SortedMap<Integer, Integer> counts = counts(nums);
            return doDeleteAndEarn(new ArrayList<>(counts.keySet()), 0, counts, new Integer[n]);
        }

        private SortedMap<Integer, Integer> counts(int[] nums) {
            SortedMap<Integer, Integer> counts = new TreeMap<>();
            for (int x : nums) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }
            return counts;
        }

        // DP: top-down
        private int doDeleteAndEarn(List<Integer> uniq, int idx, SortedMap<Integer, Integer> counts, Integer[] memo) {
            if (idx >= uniq.size()) {
                return 0;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            int x = uniq.get(idx);

            // option #1: take x
            int take = x * counts.get(x);
            take += (idx + 1 < uniq.size() && uniq.get(idx + 1) == x + 1)
                    ? doDeleteAndEarn(uniq, idx + 2, counts, memo)
                    : doDeleteAndEarn(uniq, idx + 1, counts, memo);

            // option #2: skip x
            int skip = doDeleteAndEarn(uniq, idx + 1, counts, memo);
            return memo[idx] = Math.max(take, skip);
        }
    }
}
