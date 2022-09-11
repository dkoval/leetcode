package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-performance-of-a-team/">Maximum Performance of a Team</a>
 * <p>
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n.
 * There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith
 * engineer respectively.
 * <p>
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 * <p>
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 * <p>
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= n <= 10^5</li>
 *  <li>speed.length == n</li>
 *  <li>efficiency.length == n</li>
 *  <li>1 <= speed[i] <= 10^5</li>
 *  <li>1 <= efficiency[i] <= 10^8</li>
 * </ul>
 */
public class MaximumPerformanceOfTeam {

    private static final int MOD = 1_000_000_007;

    private static class Engineer {
        final int speed;
        final int efficiency;

        Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    // Resource: https://www.youtube.com/watch?v=Y7UTvogADH0
    // O(N*logN + N*logK) = O(N*logN) time | O(K) space
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i < n; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }

        // Greedy approach. Try to maximize efficiency first.
        // To do so, sort engineers by their efficiency in DESC order.
        Arrays.sort(engineers, Comparator.comparingInt(engineer -> -engineer.efficiency));

        // min heap to record k top speed values
        Queue<Integer> pq = new PriorityQueue<>();
        long totalSpeed = 0;
        long maxPerformance = 0;

        for (Engineer curr : engineers) {
            totalSpeed += curr.speed;
            pq.offer(curr.speed);

            if (pq.size() > k) {
                totalSpeed -= pq.poll();
            }

            maxPerformance = Math.max(maxPerformance, totalSpeed * curr.efficiency);
        }
        return (int) (maxPerformance % MOD);
    }
}
