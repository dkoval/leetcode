package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/">Max Number of K-Sum Pairs</a>
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * <p>
 * Return the maximum number of operations you can perform on the array.
 */
public interface MaxNumberOfKSumPairs {

    int maxOperations(int[] nums, int k);

    class MaxNumberOfKSumPairsUsingHashMap implements MaxNumberOfKSumPairs {

        // O(N) time | O(N) space
        @Override
        public int maxOperations(int[] nums, int k) {
            int numOperations = 0;
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                int complement = k - num;
                if (count.containsKey(complement)) {
                    // pair num with its complement
                    numOperations++;
                    int currCount = count.get(complement);
                    if (currCount > 1) {
                        count.put(complement, currCount - 1);
                    } else {
                        count.remove(complement);
                    }
                } else {
                    count.put(num, count.getOrDefault(num, 0) + 1);
                }
            }
            return numOperations;
        }
    }

    class MaxNumberOfKSumPairsUsingSorting implements MaxNumberOfKSumPairs {

        // O(NlogN) time | O(1) space
        @Override
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int count = 0;
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > k) {
                    r--;
                } else if (sum < k) {
                    l++;
                } else {
                    count++;
                    l++;
                    r--;
                }
            }
            return count;
        }
    }
}
