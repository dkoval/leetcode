package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">Kth Largest Element in a Stream</a>
 * <p>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <ul>
 *  <li>KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.</li>
 *  <li>int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= 10^4</li>
 *  <li>0 <= nums.length <= 10^4</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 *  <li>-10^4 <= val <= 10^4</li>
 *  <li>At most 10^4 calls will be made to add</li>
 *  <li>It is guaranteed that there will be at least k elements in the array when you search for the kth element</li>
 * </ul>
 */
public interface KthLargestElementInStream {

    // O(N * logK) time | O(K) space
    class KthLargest {
        private final int k;
        private final Queue<Integer> pq = new PriorityQueue<>(); // min heap

        public KthLargest(int k, int[] nums) {
            this.k = k;
            enqueue(nums);
        }

        public int add(int val) {
            enqueue(val);
            // it is guaranteed that there will be at least k elements in the array when you search for the kth element
            return pq.peek();
        }

        private void enqueue(int... nums) {
            for (int x : nums) {
                pq.offer(x);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
    }
}
