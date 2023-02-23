package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/ipo/">IPO (Hard)</a>
 * <p>
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * <p>
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * <p>
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * <p>
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public interface IPO {

    int findMaximizedCapital(int k, int w, int[] profits, int[] capital);

    class IPORev1 implements IPO {

        @Override
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            // idea: sorting + greedy
            int n = profits.length;

            Project[] projects = new Project[n];
            for (int i = 0; i < n; i++) {
                projects[i] = new Project(capital[i], profits[i]);
            }

            // sort projects by their capital in ASC order
            Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));
            // max heap is used to sort profits in DESC order
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            int i = 0;
            int total = w;
            k = Math.min(k, n);
            while (k-- > 0) {
                while (i < n && projects[i].capital <= total) {
                    pq.offer(projects[i].profit);
                    i++;
                }

                if (!pq.isEmpty()) {
                    total += pq.poll();
                }
            }
            return total;
        }

        private static class Project {
            final int capital;
            final int profit;

            Project(int capital, int profit) {
                this.capital = capital;
                this.profit = profit;
            }
        }
    }
}
