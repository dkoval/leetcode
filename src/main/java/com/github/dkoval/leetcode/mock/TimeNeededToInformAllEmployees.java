package com.github.dkoval.leetcode.mock;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Time Needed to Inform All Employees</a>
 * <p>
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,
 * manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the employees of the company of an urgent piece of news.
 * He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes,
 * all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= headID < n</li>
 *  <li>manager.length == n</li>
 *  <li>0 <= manager[i] < n</li>
 *  <li>manager[headID] == -1</li>
 *  <li>informTime.length == n</li>
 *  <li>0 <= informTime[i] <= 1000</li>
 *  <li>informTime[i] == 0 if employee i has no subordinates</li>
 *  <li>It is guaranteed that all the employees can be informed</li>
 * </ul>
 */
public interface TimeNeededToInformAllEmployees {

    int numOfMinutes(int n, int headID, int[] manager, int[] informTime);

    class TimeNeededToInformAllEmployeesDFS implements TimeNeededToInformAllEmployees {

        @Override
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                if (manager[i] != -1) {
                    graph.computeIfAbsent(manager[i], key -> new ArrayList<>()).add(i);
                }
            }
            return dfs(graph, informTime, headID);
        }

        private int dfs(Map<Integer, List<Integer>> graph, int[] informTime, int managerId) {
            List<Integer> subordinates = graph.get(managerId);
            if (subordinates == null) {
                return 0;
            }

            int propagateTime = 0;
            for (int subordinateId : subordinates) {
                propagateTime = Math.max(propagateTime, dfs(graph, informTime, subordinateId));
            }
            return informTime[managerId] + propagateTime;
        }
    }

    class TimeNeededToInformAllEmployeesBFS implements TimeNeededToInformAllEmployees {

        private static class Employee {
            final int id;
            final int awarenessTime;

            Employee(int id, int awarenessTime) {
                this.id = id;
                this.awarenessTime = awarenessTime;
            }
        }

        @Override
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (manager[i] != -1) {
                    graph.computeIfAbsent(manager[i], key -> new ArrayList<>()).add(i);
                }
            }

            // BFS
            int maxTime = 0;
            Queue<Employee> q = new ArrayDeque<>();
            q.offer(new Employee(headID, 0));
            while (!q.isEmpty()) {
                Employee boss = q.poll();
                if (!graph.containsKey(boss.id)) {
                    // no direct subordinates (reached a leaf node)
                    maxTime = Math.max(maxTime, boss.awarenessTime);
                } else {
                    for (int subordinate : graph.get(boss.id)) {
                        q.offer(new Employee(subordinate, boss.awarenessTime + informTime[boss.id]));
                    }
                }
            }
            return maxTime;
        }
    }
}
