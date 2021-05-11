package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3737/">Construct Target Array With Multiple Sums</a>
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

    // Resource: https://dev.to/seanpgallivan/solution-construct-target-array-with-multiple-sums-24d4
    public boolean isPossible(int[] target) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int x : target) {
            sum += x;
            maxHeap.offer(x);
        }
        // simulation - check if we can convert target[] to A[] consisting of all 1's
        while (maxHeap.peek() != 1) {
            int currMaxValue = maxHeap.poll();
            sum -= currMaxValue; // remaining sum
            if (currMaxValue <= sum || sum < 1) {
                return false;
            }
            int replacedValue = currMaxValue % sum;
            sum += replacedValue;
            maxHeap.offer(replacedValue);
        }
        return true;
    }
}
