package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * <a href="https://leetcode.com/problems/subarrays-with-k-different-integers/">Subarrays with K Different Integers (Hard)</a>
 * <p>
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 * <p>
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 2 * 10^4</li>
 *  <li>1 <= nums[i], k <= nums.length</li>
 * </ul>
 */
public interface SubarraysWithKDifferentIntegers {

    int subarraysWithKDistinct(int[] nums, int k);

    // O(N) time | O(K) space
    class SubarraysWithKDifferentIntegersRev1 implements SubarraysWithKDifferentIntegers {

        @Override
        public int subarraysWithKDistinct(int[] nums, int k) {
            // idea: sliding window
            // 1st pass: count1 = the number of subarrays with <= k distinct elements
            // 2nd pass: count2 = the number of subarrays with < k distinct elements
            // answer = count1 - count2
            return countDistinct(nums, numDistinct -> numDistinct <= k) - countDistinct(nums, numDistinct -> numDistinct < k);
        }

        private int countDistinct(int[] nums, Predicate<Integer> condition) {
            // [..., left, left + 1 ..., right - 1, right, ...]
            //       T     T             T          T
            //                                      <--->
            //                           <-------------->
            //                      <-- ... ------------>
            //             <---------------------------->
            //       <---------------------------------->
            //
            // the total number of subarrays where the condition holds true = right - left + 1
            int n = nums.length;

            int ans = 0;
            // x -> count
            Map<Integer, Integer> distinct = new HashMap<>();
            int left = 0;
            for (int right = 0; right < n; right++) {
                distinct.put(nums[right], distinct.getOrDefault(nums[right], 0) + 1);
                // if the number of distinct elements is too big,
                // keep on shrinking the window from the left until the condition is met again
                while (!condition.test(distinct.size())) {
                    int curr = distinct.get(nums[left]);
                    if (curr > 1) {
                        distinct.put(nums[left], curr - 1);
                    } else {
                        distinct.remove(nums[left]);
                    }
                    left++;
                }
                ans += right - left + 1;
            }
            return ans;
        }
    }
}
