package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3816/">4Sum</a>
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <ul>
 *  <li>0 <= a, b, c, d < n</li>
 *  <li>a, b, c, and d are distinct</li>
 *  <li>nums[a] + nums[b] + nums[c] + nums[d] == target</li>
 * </ul>
 * You may return the answer in any order.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // Since nums[] is now sorted in the asc order,
        // for indices i < j < k < l, values nums[i] <= nums[j] <= nums[k] <= nums[l]
        int n = nums.length;

        // List<Integer> stores (nums[i], nums[j]) pair along with the index j
        Map<Integer, List<List<Integer>>> sumOfPair = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sumOfPair.computeIfAbsent(nums[i] + nums[j], key -> new ArrayList<>())
                        .add(Arrays.asList(nums[i], nums[j], j));
            }
        }

        Set<List<Integer>> result = new HashSet<>();
        for (int k = 0; k < n - 1; k++) {
            for (int l = k + 1; l < n; l++) {
                int complement = target - nums[k] - nums[l];
                if (sumOfPair.containsKey(complement)) {
                    for (List<Integer> pairAndIndex : sumOfPair.get(complement)) {
                        // Since indices i < j and k < l already, the only constraint to assure here is j < k
                        if (pairAndIndex.get(2) < k) {
                            result.add(Arrays.asList(pairAndIndex.get(0), pairAndIndex.get(1), nums[k], nums[l]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
