package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3982/">Max Consecutive Ones</a>
 * <p>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>nums[i] is either 0 or 1</li>
 * </ul>
 */
public class MaxConsecutiveOnes {

    // O(N) time | O(1) space
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] == 1) {
                // start of the window
                int j = i + 1;
                while (j < n && nums[j] == 1) {
                    j++;
                }
                int currLength = j - i;
                maxLength = Math.max(maxLength, currLength);
                i = j + 1;
            } else {
                i++;
            }
        }
        return maxLength;
    }
}
