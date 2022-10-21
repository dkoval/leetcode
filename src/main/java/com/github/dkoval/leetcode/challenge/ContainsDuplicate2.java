package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 * <p>
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 *  <li>0 <= k <= 10^5</li>
 * </ul>
 */
public interface ContainsDuplicate2 {

    boolean containsNearbyDuplicate(int[] nums, int k);

    class ContainsDuplicate2Rev1 implements ContainsDuplicate2 {

        @Override
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;

            // x -> sorted list of indices at which x occurs in nums[]
            Map<Integer, List<Integer>> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                seen.computeIfAbsent(nums[i], __ -> new ArrayList<>()).add(i);
            }

            for (Map.Entry<Integer, List<Integer>> entry : seen.entrySet()) {
                int x = entry.getKey();
                List<Integer> indices = entry.getValue();

                int j = 0;
                for (int i = 1; i < indices.size(); i++) {
                    if (indices.get(i) - indices.get(j) <= k) {
                        return true;
                    } else {
                        j = i;
                    }
                }
            }
            return false;
        }
    }

    class ContainsDuplicate2Rev2 implements ContainsDuplicate2 {


        @Override
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;

            // x -> last index at which x occurs in nums[]
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (seen.containsKey(nums[i])) {
                    int j = seen.get(nums[i]);
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                seen.put(nums[i], i);
            }
            return false;
        }
    }
}
