package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/">Find All K-Distant Indices in an Array</a>
 * <p>
 * You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums
 * for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
 * <p>
 * Return a list of all k-distant indices sorted in increasing order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 1000</li>
 *  <li>key is an integer from the array nums.</li>
 *  <li>1 <= k <= nums.length</li>
 * </ul>
 */
public interface FindAllKDistantIndicesInArray {

    List<Integer> findKDistantIndices(int[] nums, int key, int k);

    class FindAllKDistantIndicesInArrayRev1 implements FindAllKDistantIndicesInArray {

        @Override
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            final var n = nums.length;

            final var indices = new boolean[n];
            for (var j = 0; j < n; j++) {
                if (nums[j] != key) {
                    continue;
                }

                final var start = Math.max(j - k, 0);
                final var end = Math.min(j + k, n - 1);
                for (var i = start; i <= end; i++) {
                    indices[i] = true;
                }
            }

            final var ans = new ArrayList<Integer>();
            for (var i = 0; i < n; i++) {
                if (indices[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
