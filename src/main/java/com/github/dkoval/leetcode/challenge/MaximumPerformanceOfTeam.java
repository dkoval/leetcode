package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3768/">Maximum Performance of a Team</a>
 * <p>
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n.
 * There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith
 * engineer respectively.
 * <p>
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 * <p>
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 * <p>
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
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

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // sort engineers by their efficiency in decreasing order
        Engineer[] engineers = zip(speed, efficiency, n);
        Arrays.sort(engineers, (o1, o2) -> o2.efficiency - o1.efficiency);

        // keep top k speed[] values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumOfSpeeds = 0;
        long maxPerformance = 0;

        for (Engineer curr : engineers) {
            sumOfSpeeds += curr.speed;
            minHeap.offer(curr.speed);

            if (minHeap.size() > k) {
                sumOfSpeeds -= minHeap.poll();
            }

            maxPerformance = Math.max(maxPerformance, sumOfSpeeds * curr.efficiency);
        }

        return (int) (maxPerformance % MOD);
    }

    private Engineer[] zip(int[] speed, int[] efficiency, int n) {
        Engineer[] result = new Engineer[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Engineer(speed[i], efficiency[i]);
        }
        return result;
    }
}
