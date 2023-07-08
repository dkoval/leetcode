package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/put-marbles-in-bags/">Put Marbles in Bags (Hard)</a>
 * <p>
 * You have k bags. You are given a 0-indexed integer array weights where weights[i] is the weight of the ith marble.
 * You are also given the integer k.
 * <p>
 * Divide the marbles into the k bags according to the following rules:
 * <ul>
 *  <li>No bag is empty.</li>
 *  <li>If the ith marble and jth marble are in a bag, then all marbles with an index between the ith and jth indices should also be in that same bag.</li>
 *  <li>If a bag consists of all the marbles with an index from i to j inclusively, then the cost of the bag is weights[i] + weights[j].</li>
 * </ul>
 * The score after distributing the marbles is the sum of the costs of all the k bags.
 * <p>
 * Return the difference between the maximum and minimum scores among marble distributions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= weights.length <= 10^5</li>
 *  <li>1 <= weights[i] <= 109</li>
 * </ul>
 */
public interface PutMarblesInBags {

    long putMarbles(int[] weights, int k);

    // O(N * log K) time | O(K) space
    class PutMarblesInBagsRev1 implements PutMarblesInBags {

        @Override
        public long putMarbles(int[] weights, int k) {
            int n = weights.length;

            // corner case: both the maximal and minimal score are the same
            if (k == n) {
                return 0;
            }

            // Given k, we need to put k - 1 dividers somewhere.
            // Note that in order to minimize/maximize the score after distributing the marbles,
            // only adjacent numbers of weights[] matter.
            //
            // Bags:
            // cost = weights[start] + weights[end]
            // ... + | +__+ | +__+ | +___+ | + ...

            // store k - 1 (weights[i] + weights[i + 1]) numbers
            Queue<Integer> minHeap = new PriorityQueue<>();
            Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            long maxScore = 0L;
            long minScore = 0L;
            for (int i = 0; i < n - 1; i++) {
                int x = weights[i] + weights[i + 1];
                maxScore = enqueue(minHeap, x, k - 1, maxScore);
                minScore = enqueue(maxHeap, x, k - 1, minScore);
            }
            return maxScore - minScore;
        }

        private long enqueue(Queue<Integer> q, int x, int k, long score) {
            q.offer(x);
            score += x;
            if (q.size() > k) {
                score -= q.poll();
            }
            return score;
        }
    }
}
