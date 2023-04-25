package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set/">Smallest Number in Infinite Set</a>
 * <p>
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * <p>
 * Implement the SmallestInfiniteSet class:
 * <ul>
 *  <li>SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.</li>
 *  <li>int popSmallest() Removes and returns the smallest integer contained in the infinite set.</li>
 *  <li>void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= num <= 1000</li>
 *  <li>At most 1000 calls will be made in total to popSmallest and addBack.</li>
 * </ul>
 */
public interface SmallestNumberInInfiniteSet {

    int popSmallest();

    void addBack(int num);

    class SmallestNumberInInfiniteSetRev1 implements SmallestNumberInInfiniteSet {
        // min heap + hash set record the unique numbers added back to the infinite set
        private final Queue<Integer> minHeap = new PriorityQueue<>();
        private final Set<Integer> unique = new HashSet<>();
        // the current smallest number in the infinite set
        private int smallest = 1;

        public int popSmallest() {
            if (!minHeap.isEmpty() && minHeap.peek() < smallest) {
                int num = minHeap.poll();
                unique.remove(num);
                return num;
            }
            return smallest++;
        }

        public void addBack(int num) {
            if (num < smallest && !unique.contains(num)) {
                unique.add(num);
                minHeap.offer(num);
            }
        }
    }
}
