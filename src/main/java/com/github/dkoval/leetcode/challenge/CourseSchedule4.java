package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule-iv/">Course Schedule IV</a>
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first
 * if you want to take course bi.
 * <p>
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * <p>
 * Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c,
 * then course a is a prerequisite of course c.
 * <p>
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj
 * is a prerequisite of course vj or not.
 * <p>
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 */
public interface CourseSchedule4 {

    List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries);

    class CourseSchedule4Rev1 implements CourseSchedule4 {

        @Override
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            final var adj = new HashMap<Integer, List<Integer>>();
            final var indegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                adj.computeIfAbsent(prerequisite[0], __ -> new ArrayList<>()).add(prerequisite[1]);
                indegree[prerequisite[1]]++;
            }

            final var q = new ArrayDeque<Integer>();
            for (var i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // topological sort
            final var lookup = new HashMap<Integer, Set<Integer>>();
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int next : adj.getOrDefault(curr, List.of())) {
                    var prereqs = lookup.computeIfAbsent(next, __ -> new HashSet<>());
                    prereqs.add(curr);
                    prereqs.addAll(lookup.getOrDefault(curr, Set.of()));
                    if (--indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                var verdict = lookup.getOrDefault(query[1], Set.of()).contains(query[0]);
                ans.add(verdict);
            }
            return ans;
        }
    }
}
