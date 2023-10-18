package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/parallel-courses-iii/">Parallel Courses III (Hard)</a>
 * <p>
 * You are given an integer n, which indicates that there are n courses labeled from 1 to n.
 * You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej]
 * denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship).
 * Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.
 * <p>
 * You must find the minimum number of months needed to complete all the courses following these rules:
 * <ul>
 *  <li>You may start taking a course at any time if the prerequisites are met.</li>
 *  <li>Any number of courses can be taken at the same time.</li>
 * </ul>
 * Return the minimum number of months needed to complete all the courses.
 * <p>
 * Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).
 */
public interface ParallelCourses3 {

    int minimumTime(int n, int[][] relations, int[] time);

    class ParallelCourses3Rev1 implements ParallelCourses3 {

        @Override
        public int minimumTime(int n, int[][] relations, int[] time) {
            // idea: topological sort
            Map<Integer, List<Integer>> adj = new HashMap<>();
            int[] indegree = new int[n];
            for (int[] edge : relations) {
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                adj.computeIfAbsent(u, __ -> new ArrayList<>()).add(v);
                indegree[v]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // start[i] - the time at which the i-th course can be started
            int[] start = new int[n];
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : adj.getOrDefault(curr, Collections.emptyList())) {
                    indegree[next]--;
                    start[next] = Math.max(start[next], start[curr] + time[curr]);
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, start[i] + time[i]);
            }
            return ans;
        }
    }
}
