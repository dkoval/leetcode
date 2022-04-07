package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">Last Stone Weight</a>
 * <p>
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * <p>
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * <ul>
 *  <li>If x == y, both stones are destroyed, and</li>
 * <li>If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.</li>
 * </ul>
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= stones.length <= 30</li>
 *  <li>1 <= stones[i] <= 1000</li>
 * </ul>
 */
public class LastStoneWeight {

    // O(NlogN) time | O(N) space
    public int lastStoneWeight(int[] stones) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : stones) {
            pq.offer(x);
        }

        // O(N) iterations
        while (pq.size() >= 2) {
            // O(logN) time
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.offer(Math.abs(x - y));
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
