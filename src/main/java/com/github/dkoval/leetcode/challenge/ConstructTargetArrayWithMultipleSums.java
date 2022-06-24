package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="Construct Target Array With Multiple Sums">Construct Target Array With Multiple Sums</a>
 * <p>
 * Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure:
 * <ul>
 *  <li>let x be the sum of all elements currently in your array</li>
 *  <li>choose index i, such that 0 <= i < target.size and set the value of A at index i to x</li>
 *  <li>You may repeat this procedure as many times as needed</li>
 * </ul>
 * <p>
 * Return True if it is possible to construct the target array from A otherwise return False.
 * <p>
 * Constraints:
 * <ul>
 *  <li>N == target.length</li>
 *  <li>1 <= target.length <= 5 * 10^4</li>
 *  <li>1 <= target[i] <= 10^9</li>
 * </ul>
 */
public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int x : target) {
            sum += x;
            maxHeap.offer(x);
        }

        // simulation - check if we can convert target[] to [1, 1, ..., 1]
        while (maxHeap.peek() != 1) {
            int max = maxHeap.poll();
            sum -= max;

            // Replace max with y in the next iteration
            // y = max - sum, where y >= 1 and sum variable stores the remaining sum
            if (sum <= 0 || max <= sum) {
                return false;
            }

            // Below is an optimization to fix TLE by replacing "-" operation with "%"
            int y = max % sum;

            // a % a = 0
            // a % 1 = 0
            if (y == 0 && sum != 1) {
                return false;
            }

            sum += y;
            maxHeap.offer(y);
        }
        return true;
    }
}
