package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/">Divide an Array Into Subarrays With Minimum Cost I</a>
 * <p>
 * You are given an array of integers nums of length n.
 * <p>
 * The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
 * <p>
 * You need to divide nums into 3 disjoint contiguous subarrays.
 * <p>
 * Return the minimum possible sum of the cost of these subarrays.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= n <= 50</li>
 *  <li>1 <= nums[i] <= 50</li>
 * </ul>
 */
public interface DivideArrayIntoSubarraysWithMinimumCost1 {

    int minimumCost(int[] nums);

    class DivideArrayIntoSubarraysWithMinimumCost1Rev1 implements DivideArrayIntoSubarraysWithMinimumCost1 {

        @Override
        public int minimumCost(int[] nums) {
            final var n = nums.length;

            // the result always includes nums[0]
            var total = nums[0];

            // find 2 smallest elements in nums[1:]
            final var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
            for (var i = 1; i < n; i++) {
                maxHeap.offer(nums[i]);
                if (maxHeap.size() > 2) {
                    maxHeap.poll();
                }
            }

            // compute the total cost
            while (!maxHeap.isEmpty()) {
                total += maxHeap.poll();
            }
            return total;
        }
    }
}
