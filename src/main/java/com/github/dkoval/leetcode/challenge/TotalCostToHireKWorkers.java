package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a ref="https://leetcode.com/problems/total-cost-to-hire-k-workers/">Total Cost to Hire K Workers</a>
 * <p>
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 * <p>
 * You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
 * <ul>
 *   <li>You will run k sessions and hire exactly one worker in each session.</li>
 *   <li>In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.</li>
 *   <ul>
 *     <li>For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].</li>
 *     <li>In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.</li>
 *   </ul>
 *   <li>If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.</li>
 *   <li>A worker can only be chosen once.</li>
 * </ul>
 * Return the total cost to hire exactly k workers.
 */
public interface TotalCostToHireKWorkers {

    long totalCost(int[] costs, int k, int candidates);

    class TotalCostToHireKWorkersRev1 implements TotalCostToHireKWorkers {

        @Override
        public long totalCost(int[] costs, int k, int candidates) {
            int n = costs.length;

            Comparator<Item> cmp = (x, y) -> (x.value == y.value)
                    ? Integer.compare(x.index, y.index)
                    : Integer.compare(x.value, y.value);

            Queue<Item> minHeap = new PriorityQueue<>(cmp);
            int left = 0;
            int right = n - 1;
            while (candidates-- > 0) {
                minHeap.offer(new Item(costs[left], left, true));
                left++;

                if (left >= right) {
                    break;
                }

                minHeap.offer(new Item(costs[right], right, false));
                right--;
            }

            long total = 0L;
            while (k-- > 0) {
                Item top = minHeap.poll();
                total += top.value;
                if (left <= right) {
                    if (top.takenFromLeft) {
                        minHeap.offer(new Item(costs[left], left, true));
                        left++;
                    } else {
                        minHeap.offer(new Item(costs[right], right, false));
                        right--;
                    }
                }
            }
            return total;
        }

        private static class Item {
            final int value;
            final int index;
            final boolean takenFromLeft;

            Item(int value, int index, boolean takenFromLeft) {
                this.value = value;
                this.index = index;
                this.takenFromLeft = takenFromLeft;
            }
        }
    }
}
