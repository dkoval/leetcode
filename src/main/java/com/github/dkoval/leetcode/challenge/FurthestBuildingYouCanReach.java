package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/furthest-building-you-can-reach/">Furthest Building You Can Reach</a>
 * <p>
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * <p>
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * <p>
 * While moving from building i to building i+1 (0-indexed),
 * <ul>
 *  <li>If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.</li>
 *  <li>If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.</li>
 * </ul>
 * <p>
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= heights.length <= 10^5</li>
 *  <li>1 <= heights[i] <= 10^6</li>
 *  <li>0 <= bricks <= 10^9</li>
 *  <li>0 <= ladders <= heights.length</li>
 * </ul>
 */
public class FurthestBuildingYouCanReach {

    // O(N * logL) time | O(L) space
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        // Hint #2: You'll have to do a set of jumps, and choose for each one whether to do it using a ladder or bricks.
        // It's always optimal to use ladders in the largest jumps.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores L largest jumps
        int bricksRemaining = bricks;
        for (int i = 0; i < n - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int height = heights[i + 1] - heights[i];
            if (minHeap.size() < ladders) {
                // At first, try to use ladders until there are none available
                minHeap.offer(height);
            } else {
                // Optimize: save a ladder for a larger jump and use bricks, if possible
                int bricksNeeded = height;
                if (!minHeap.isEmpty() && minHeap.peek() < height) {
                    bricksNeeded = minHeap.poll();
                    minHeap.offer(height);
                }
                bricksRemaining -= bricksNeeded;
                if (bricksRemaining < 0) {
                    return i;
                }
            }
        }
        return n - 1;
    }
}
