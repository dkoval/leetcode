package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/split-array-largest-sum/">Split Array Largest Sum (Hard)</a>
 * <p>
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * <p>
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Constraints:
 * <ul>
 * <li>1 <= nums.length <= 1000</li>
 *  <li>0 <= nums[i] <= 10^6</li>
 *  <li>1 <= m <= min(50, nums.length)</li>
 * </ul>
 */
public interface SplitArrayLargestSum {

    int splitArray(int[] nums, int m);

    class SplitArrayLargestSumUsingBinarySearch implements SplitArrayLargestSum {

        // O(N * logS) time, where S = sum(nums) | O(1) space
        @Override
        public int splitArray(int[] nums, int m) {
            // 0 <= nums[i] <= 10^6, therefore
            // can binary search for the min sum in [0 : sum(nums)] range
            int l = 0;
            int r = sum(nums);
            // check all possible sums in [l : r] range;
            // for each sum = x, count how many continuous subarrays with their individual sums <= maxSum there are in nums
            while (l < r) {
                int mid = l + (r - l) / 2;
                int count = countContinuousSubarraysWithSum(nums, mid);
                // note that even if count < m, we can still split nums[] in m contiguous subarrays
                // FF...FTT...T
                //       ^ want to find
                if (count != -1 && count <= m) {
                    // `mid` is a possible solution; check if there exists a better solution to the right of `mid`
                    r = mid;
                } else {
                    // `mid` is not a solution; also, every number to the left of `mid` can't be a solution
                    l = mid + 1;
                }
            }
            return l;
        }

        private int sum(int[] nums) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            return sum;
        }

        private int countContinuousSubarraysWithSum(int[] nums, int maxSum) {
            // Greedy
            int count = 1;
            int currSum = 0;
            for (int x : nums) {
                if (x > maxSum) {
                    // impossible to split nums[]
                    return -1;
                }

                currSum += x;
                if (currSum > maxSum) {
                    count++;
                    currSum = x;
                }
            }
            return count;
        }
    }
}
