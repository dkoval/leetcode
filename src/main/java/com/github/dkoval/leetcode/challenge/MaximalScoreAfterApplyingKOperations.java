package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximal-score-after-applying-k-operations/">Maximal Score After Applying K Operations</a>
 * <p>
 * You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.
 * <p>
 * In one operation:
 * <ol>
 *  <li>choose an index i such that 0 <= i < nums.length,</li>
 *  <li>increase your score by nums[i], and</li>
 *  <li>replace nums[i] with ceil(nums[i] / 3).</li>
 * </ol>
 * Return the maximum possible score you can attain after applying exactly k operations.
 * <p>
 * The ceiling function ceil(val) is the least integer greater than or equal to val.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length, k <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface MaximalScoreAfterApplyingKOperations {

    long maxKelements(int[] nums, int k);

    class MaximalScoreAfterApplyingKOperationsRev1 implements MaximalScoreAfterApplyingKOperations {

        @Override
        public long maxKelements(int[] nums, int k) {
            Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int x : nums) {
                maxHeap.offer(x);
            }

            long total = 0;
            while (!maxHeap.isEmpty() && k-- > 0) {
                int x = maxHeap.poll();
                total += x;

                x = (x + 2) / 3; // ceil(x / 3)
                maxHeap.offer(x);
            }
            return total;
        }
    }
}
