package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/house-robber-iv/">House Robber IV</a>
 * <p>
 * There are several consecutive houses along a street, each of which has some money inside.
 * There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
 * <p>
 * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
 * <p>
 * You are given an integer array nums representing how much money is stashed in each house.
 * More formally, the ith house from the left has nums[i] dollars.
 * <p>
 * You are also given an integer k, representing the minimum number of houses the robber will steal from.
 * It is always possible to steal at least k houses.
 * <p>
 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 *  <li>1 <= k <= (nums.length + 1) / 2</li>
 * </ul>
 */
public interface HouseRobber4 {

    int minCapability(int[] nums, int k);

    class HouseRobber4Rev1 implements HouseRobber4 {

        @Override
        public int minCapability(int[] nums, int k) {
            var min = Integer.MAX_VALUE;
            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            // Guess the answer using binary search.
            // Condition: given capability X, at least k houses can be robbed.
            // FF ... FTT...T
            //         ^ answer
            var left = min;
            var right = max;
            while (left < right) {
                var mid = left + (right - left) / 2;
                if (good(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean good(int[] nums, int k, int threshold) {
            var i = 0;
            while (i < nums.length && k > 0) {
                if (nums[i] <= threshold) {
                    k--;
                    i++;
                }
                i++;
            }
            return k == 0;
        }
    }
}
