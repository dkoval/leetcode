package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">Minimum Rounds to Complete All Tasks</a>
 * <p>
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
 * In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 * <p>
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= tasks.length <= 10^5</li>
 *  <li>1 <= tasks[i] <= 10^9</li>
 * </ul>
 */
public interface MinimumRoundsToCompleteAllTasks {

    int minimumRounds(int[] tasks);

    class MinimumRoundsToCompleteAllTasksRev1 implements MinimumRoundsToCompleteAllTasks {

        @Override
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int x : tasks) {
                counts.put(x, counts.getOrDefault(x, 0) + 1);
            }

            //System.out.printf("levels: %s\n", counts);
            int rounds = 0;
            for (int count : counts.values()) {
                // in each round, you can only complete either 2 or 3 tasks of the same difficulty level
                if (count == 1) {
                    return -1;
                }

                int delta = Integer.MAX_VALUE;

                // option #1: count = 3 * p
                // 6 = 3 * 2
                //         ^ 2 rounds needed
                if (count % 3 == 0) {
                    delta = Math.min(delta, count / 3);
                }

                // option #2: count = 2 * q
                // 6 = 2 * 3
                //         ^ 3 rounds needed
                if (count % 2 == 0) {
                    delta = Math.min(delta, count / 2);
                }

                // option #3: count = 3 * p + 2 * q
                // no need to perform this check if count is divisible by both 2 and 3
                if (count % 2 != 0 || count % 3 != 0) {
                    int x = count;
                    // greedy approach - take as less q's as possible to maximize 3 * p contribution
                    int q = 0;
                    while (x >= 2 && x % 3 != 0) {
                        q++;
                        x -= 2;
                    }
                    int p = (count - q * 2) / 3;
                    delta = Math.min(delta, p + q);
                }

                rounds += delta;
            }
            return rounds;
        }
    }
}
