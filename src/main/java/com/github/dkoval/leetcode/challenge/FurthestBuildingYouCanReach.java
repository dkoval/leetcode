package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
public interface FurthestBuildingYouCanReach {

    int furthestBuilding(int[] heights, int bricks, int ladders);

    // O(N * logL) time | O(L) space
    class FurthestBuildingYouCanReachRev1 implements FurthestBuildingYouCanReach {

        @Override
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int n = heights.length;

            // It's always optimal to use ladders in the largest jumps.
            // Min heap stores L largest jumps.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int bricksRemaining = bricks;
            for (int i = 0; i < n - 1; i++) {
                if (heights[i] >= heights[i + 1]) {
                    continue;
                }

                int jump = heights[i + 1] - heights[i];
                if (minHeap.size() < ladders) {
                    // At first, try to use ladders until there are none available
                    minHeap.offer(jump);
                } else {
                    // Optimize: save a ladder for a larger jump and use bricks, if possible
                    int bricksNeeded = jump;
                    if (!minHeap.isEmpty() && minHeap.peek() < jump) {
                        bricksNeeded = minHeap.poll();
                        minHeap.offer(jump);
                    }

                    if (bricksNeeded > bricksRemaining) {
                        return i;
                    }

                    bricksRemaining -= bricksNeeded;
                }
            }
            return n - 1;
        }
    }

    class FurthestBuildingYouCanReachRev2 implements FurthestBuildingYouCanReach {

        @Override
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int n = heights.length;

            // max heap records largest jumps made with bricks
            Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n - 1; i++) {
                if (heights[i] >= heights[i + 1]) {
                    continue;
                }

                int jump = heights[i + 1] - heights[i];

                // at first, try to use as many bricks as possible
                bricks -= jump;
                maxHeap.offer(jump);

                // not enough bricks?
                if (bricks < 0) {
                    // use a ladder, if available, to replace the largest jump made with bricks
                    if (ladders == 0) {
                        return i;
                    }
                    ladders--;
                    bricks += maxHeap.poll();
                }
            }
            return n - 1;
        }
    }
}
