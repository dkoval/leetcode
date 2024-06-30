package com.github.dkoval.leetcode.challenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/">All Ancestors of a Node in a Directed Acyclic Graph</a>
 * <p>
 * You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG).
 * The nodes are numbered from 0 to n - 1 (inclusive).
 * <p>
 * You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge
 * from fromi to toi in the graph.
 * <p>
 * Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.
 * <p>
 * A node u is an ancestor of another node v if u can reach v via a set of edges.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 1000</li>
 *  <li>0 <= edges.length <= min(2000, n * (n - 1) / 2)</li>
 *  <li>edges[i].length == 2</li>
 *  <li>0 <= fromi, toi <= n - 1</li>
 *  <li>fromi != toi</li>
 *  <li>There are no duplicate edges.</li>
 *  <li>The graph is directed and acyclic.</li>
 * </ul>
 */
public interface AllAncestorsOfNodeInDirectedAcyclicGraph {

    List<List<Integer>> getAncestors(int n, int[][] edges);

    class AllAncestorsOfNodeInDirectedAcyclicGraphRev1 implements AllAncestorsOfNodeInDirectedAcyclicGraph {

        @Override
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            Map<Integer, List<Integer>> adj = new HashMap<>();
            int[] indegrees = new int[n];
            for (int[] edge : edges) {
                adj.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                indegrees[edge[1]]++;
            }

            // topological sort
            Queue<Integer> q = new ArrayDeque<>();
            // start with nodes without ancestors
            for (int i = 0; i < n; i++) {
                if (indegrees[i] == 0) {
                    q.offer(i);
                }
            }

            List<Set<Integer>> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                ans.add(new HashSet<>());
            }

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int child : adj.getOrDefault(curr, List.of())) {
                    ans.get(child).add(curr);
                    ans.get(child).addAll(ans.get(curr));
                    indegrees[child]--;
                    if (indegrees[child] == 0) {
                        // prepare for the next iteration of topological sort
                        q.offer(child);
                    }
                }
            }

            // get the result ready
            return ans.stream()
                    .map(set -> {
                        List<Integer> xs = new ArrayList<>(set);
                        Collections.sort(xs);
                        return xs;
                    })
                    .collect(Collectors.toList());
        }
    }
}
