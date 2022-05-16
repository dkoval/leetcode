package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">Network Delay Time</a>
 * <p>
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges
 * times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= n <= 100</li>
 *  <li>1 <= times.length <= 6000</li>
 *  <li>times[i].length == 3</li>
 *  <li>1 <= ui, vi <= n</li>
 *  <li>ui != vi</li>
 *  <li>0 <= wi <= 100</li>
 *  <li>All the pairs (ui, vi) are unique (i.e., no multiple edges)</li>
 * </ul>
 */
public interface NetworkDelayTime {

    int networkDelayTime(int[][] times, int n, int k);

    class NetworkDelayTimeUsingBFS implements NetworkDelayTime {

        private static class Node {
            final int id;
            final int time;

            Node(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        @Override
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<Node>> graph = new HashMap<>();
            for (int[] edge : times) {
                graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
            }

            // slightly modified BFS
            Queue<Node> q = new ArrayDeque<>();
            // visited[v] is the shortest time it takes to reach v from k
            int[] visited = new int[n + 1];
            Arrays.fill(visited, Integer.MAX_VALUE);

            q.offer(new Node(k, 0));
            visited[k] = 0;
            while (!q.isEmpty()) {
                Node u = q.poll();
                for (Node v : graph.getOrDefault(u.id, Collections.emptyList())) {
                    if (u.time + v.time < visited[v.id]) {
                        q.offer(new Node(v.id, u.time + v.time));
                        visited[v.id] = u.time + v.time;
                    }
                }
            }

            // skip 0-th index
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == Integer.MAX_VALUE) {
                    // i-th node was not visited, therefore it is impossible for all the n nodes to receive the signal
                    return -1;
                }
                ans = Math.max(ans, visited[i]);
            }
            return ans;
        }
    }

    class NetworkDelayTimeUsingDijkstra implements NetworkDelayTime {

        private static class Node {
            final int id;
            final int time;

            Node(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        @Override
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<Node>> graph = new HashMap<>();
            for (int[] edge : times) {
                graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new Node(edge[1], edge[2]));
            }

            // Dijkstra's algorithm ~ BFS with min heap
            PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));
            // dist[v] is the shortest time it takes to reach v from k
            Map<Integer, Integer> dist = new HashMap<>();

            enqueue(q, new Node(k, 0), dist);
            while (!q.isEmpty()) {
                Node u = q.poll();

                if (dist.get(u.id) < u.time) {
                    continue;
                }

                for (Node v : graph.getOrDefault(u.id, Collections.emptyList())) {
                    if (!dist.containsKey(v.id) || dist.get(u.id) + v.time < dist.get(v.id)) {
                        enqueue(q, new Node(v.id, dist.get(u.id) + v.time), dist);
                    }
                }
            }

            if (dist.size() != n) {
                return -1;
            }

            // take the max time
            int ans = 0;
            for (int t : dist.values()) {
                ans = Math.max(ans, t);
            }
            return ans;
        }

        private void enqueue(PriorityQueue<Node> q, Node node, Map<Integer, Integer> dist) {
            q.offer(node);
            dist.put(node.id, node.time);
        }
    }
}
