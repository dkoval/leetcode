package com.github.dkoval.leetcode.challenge;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

/**
 * <a href="https://leetcode.com/problems/remove-methods-from-project/">Remove Methods From Project</a>
 * <p>
 * You are maintaining a project that has n methods numbered from 0 to n - 1.
 * <p>
 * You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates
 * that method ai invokes method bi.
 * <p>
 * There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly,
 * are considered suspicious and we aim to remove them.
 * <p>
 * A group of methods can only be removed if no method outside the group invokes any methods within it.
 * <p>
 * Return an array containing all the remaining methods after removing all the suspicious methods.
 * You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 <= k <= n - 1</li>
 *  <li>0 <= invocations.length <= 2 * 10^5</li>
 *  <li>invocations[i] == [ai, bi]</li>
 *  <li>0 <= ai, bi <= n - 1</li><
 *  <li>ai != bi</li>
 *  <li>invocations[i] != invocations[j]</li>
 * </ul>
 */
public interface RemoveMethodsFromProject {

    List<Integer> remainingMethods(int n, int k, int[][] invocations);

    class RemoveMethodsFromProjectRev1 implements RemoveMethodsFromProject {

        @Override
        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            final var adj = new HashMap<Integer, List<Integer>>();
            // aims at deciding whether a suspicious node can be removed or not:
            // that is, a suspicious node can be removed IFF indegree[node] == 0
            final var indegree = new int[n];

            for (var edge : invocations) {
                adj.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(edge[1]);
                indegree[edge[1]]++;
            }

            final var suspicious = findSuspicious(adj, indegree, k);
            for (var node : suspicious) {
                if (indegree[node] != 0) {
                    // can't remove any of the nodes
                    return range(0, n - 1, emptySet());
                }
            }
            return range(0, n - 1, suspicious);
        }

        private Set<Integer> findSuspicious(Map<Integer, List<Integer>> adj, int[] indegree, int k) {
            // BFS
            final var q = new ArrayDeque<Integer>();
            final var suspicious = new HashSet<Integer>();

            q.offer(k);
            suspicious.add(k);
            while (!q.isEmpty()) {
                var curr = q.poll();
                for (var neighbor : adj.getOrDefault(curr, emptyList())) {
                    indegree[neighbor]--; // remove edge: curr -> neighbor
                    if (!suspicious.contains(neighbor)) {
                        q.offer(neighbor);
                        suspicious.add(neighbor);
                    }
                }
            }
            return suspicious;
        }

        private List<Integer> range(int start, int end, Set<Integer> exclude) {
            final var res = new ArrayList<Integer>();
            for (var x = start; x <= end; x++) {
                if (!exclude.contains(x)) {
                    res.add(x);
                }
            }
            return res;
        }
    }
}
