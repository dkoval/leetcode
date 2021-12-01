package com.github.dkoval.leetcode.problems;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= nums.length <= 10^4</li>
 *  <li>-104 <= nums[i] <= 10^4</li>
 * </ul>
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.offer(x);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
