package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimize-deviation-in-array/">Minimize Deviation in Array (Hard)</a>
 * <p>
 * You are given an array nums of n positive integers.
 * <p>
 * You can perform two types of operations on any element of the array any number of times:
 * <p>
 * If the element is even, divide it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
 * If the element is odd, multiply it by 2.
 * For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
 * The deviation of the array is the maximum difference between any two elements in the array.
 * <p>
 * Return the minimum deviation the array can have after performing some number of operations.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^9</li>
 * </ul>
 */
public class MinimizeDeviationInArray {

    public int minimumDeviation(int[] nums) {
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x % 2 != 0) {
                // observation: an odd number can be multiplied by 2 only once, since odd * 2 -> even
                x *= 2;
            }
            min = Math.min(min, x);
            pq.offer(x);
        }

        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int max = pq.poll();
            ans = Math.min(ans, max - min);
            if (max % 2 == 0) {
                max /= 2;
                min = Math.min(min, max);
                pq.offer(max);
            } else {
                break;
            }
        }
        return ans;
    }
}
