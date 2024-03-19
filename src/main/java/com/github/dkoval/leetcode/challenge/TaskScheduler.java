package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/">Task Scheduler</a>
 * <p>
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
 * Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint:
 * identical tasks must be separated by at least n intervals due to cooling time.
 * <p>
 * Return the minimum number of intervals required to complete all tasks.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= tasks.length <= 10^4</li>
 *  <li>tasks[i] is an uppercase English letter</li>
 *  <li>0 <= n <= 100</li>
 * </ul>
 */
public interface TaskScheduler {

    int leastInterval(char[] tasks, int n);

    // Explanation of the algorithm: https://youtu.be/tzCPvIJpe3U?si=OHHPTnXSKX4sx-1F
    class TaskSchedulerRev2 implements TaskScheduler {

        @Override
        public int leastInterval(char[] tasks, int n) {
            // char -> count
            Map<Character, Integer> counts = new HashMap<>();
            for (char c : tasks) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            // sort tasks by frequency in desc order
            List<Integer> xs = new ArrayList<>(counts.values());
            xs.sort(Comparator.reverseOrder());

            // number of groups is the frequency of the most frequent task - 1
            // X _ _ X _ _ X _ _ X
            int groups = xs.get(0) - 1;
            int gaps = groups * n;
            for (int i = 1; i < xs.size(); i++) {
                // try to fill in the gaps with the existing tasks
                gaps -= Math.min(xs.get(i), groups);
            }
            return tasks.length + Math.max(gaps, 0);
        }
    }
}
