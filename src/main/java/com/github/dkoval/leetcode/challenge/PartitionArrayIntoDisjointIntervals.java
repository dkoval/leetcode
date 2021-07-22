package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3823/">Partition Array into Disjoint Intervals</a>
 * <p>
 * Given an array nums, partition it into two (contiguous) subarrays left and right so that:
 * <ul>
 *  <li>Every element in left is less than or equal to every element in right.</li>
 *  <li>left and right are non-empty.</li>
 *  <li>left has the smallest possible size.</li>
 * </ul>
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 * <p>
 * Note:
 * <ul>
 *  <li>2 <= nums.length <= 30000</li>
 *  <li>0 <= nums[i] <= 10^6</li>
 *  <li>It is guaranteed there is at least one way to partition nums as described.</li>
 * </ul>
 */
public class PartitionArrayIntoDisjointIntervals {

    // O(N) time | O(N) space
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        // minRight[i] is the minimum number in nums[i:n-1]
        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        // the maximum number in the `left` subarray so far
        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1; // length of the `left` subarray
            }
        }
        return -1;
    }
}
