package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/">Shortest Path With At Most K Consecutive Identical Characters</a>
 * <p>
 * You are given an integer n representing the number of nodes in a directed weighted graph, numbered from 0 to n - 1.
 * This is represented by a 2D integer array edges, where edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with weight wi.
 * <p>
 * You are also given a string labels of length n, where labels[i] is the character assigned to node i, and an integer k.
 * <p>
 * Return the minimum total edge weight of a path from node 0 to node n - 1 such that the concatenation of the labels of the nodes
 * along the path contains at most k consecutive identical characters. If no valid path exists, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == labels.length <= 5 * 10^4</li>
 *  <li>0 <= edges.length <= 5 * 10^4</li>
 *  <li>edges[i] == [ui, vi, wi]</li>
 *  <li>0 <= ui, vi <= n - 1</li>
 *  <li>ui != vi</li>
 *  <li>1 <= wi <= 10^4</li>
 *  <li>labels consists of lowercase English letters</li>
 *  <li>1 <= k <= 50</li>
 * </ul>
 */
public interface ShortestPathWithAtMostKConsecutiveIdenticalCharacters {

    int shortestPath(int n, int[][] edges, String labels, int k);

    class ShortestPathWithAtMostKConsecutiveIdenticalCharactersRev1 implements ShortestPathWithAtMostKConsecutiveIdenticalCharacters {

        @Override
        public int shortestPath(int n, int[][] edges, String labels, int k) {
            final var adj = new HashMap<Integer, List<NodeAndWeight>>();
            for (var edge : edges) {
                adj.computeIfAbsent(edge[0], _ -> new ArrayList<>()).add(new NodeAndWeight(edge[1], edge[2]));
            }

            // Dijkstra's algorithm
            final var dist = new HashMap<Key, Integer>();
            final var pq = new PriorityQueue<>(Comparator.comparingInt(State::weight));
            pq.offer(new State(0, 0, 1));
            dist.put(new Key(0, 1), 0);
            while (!pq.isEmpty()) {
                final var curr = pq.poll();

                if (curr.weight > dist.getOrDefault(new Key(curr.node, curr.streak), Integer.MAX_VALUE)) {
                    continue;
                }

                if (curr.node == n - 1) {
                    return curr.weight;
                }

                for (var neighbor : adj.getOrDefault(curr.node, List.of())) {
                    var nextStreak = 1;
                    if (labels.charAt(curr.node) == labels.charAt(neighbor.node)) {
                        nextStreak += curr.streak;
                    }

                    if (nextStreak > k) {
                        continue;
                    }

                    final var nextWeight = curr.weight + neighbor.weight;
                    if (nextWeight < dist.getOrDefault(new Key(neighbor.node, nextStreak), Integer.MAX_VALUE)) {
                        dist.put(new Key(neighbor.node, nextStreak), nextWeight);
                        pq.offer(new State(neighbor.node, nextWeight, nextStreak));
                    }
                }
            }
            return -1;
        }

        private record NodeAndWeight(
                int node,
                int weight
        ) {
        }

        private record Key(
                int node,
                int streak
        ) {
        }

        private record State(
                int node,
                int weight,
                int streak
        ) {
        }
    }
}
