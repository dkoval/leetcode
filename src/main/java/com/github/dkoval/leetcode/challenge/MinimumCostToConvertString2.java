package com.github.dkoval.leetcode.challenge;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-convert-string-ii/">Minimum Cost to Convert String II (Hard)</a>
 */
public interface MinimumCostToConvertString2 {

    long minimumCost(String source, String target, String[] original, String[] changed, int[] cost);

    class MinimumCostToConvertString2Rev1 implements MinimumCostToConvertString2 {

        @Override
        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            final var adj = new HashMap<String, List<Node>>();
            final var lengths = new TreeSet<Integer>();
            for (var i = 0; i < original.length; i++) {
                adj.computeIfAbsent(original[i], __ -> new ArrayList<>()).add(new Node(changed[i], cost[i]));
                lengths.add(original[i].length());
            }

            final var result = dp(source, target, adj, lengths, 0, new Long[source.length()]);
            return (result != Long.MAX_VALUE) ? result : -1;
        }

        // calculate the minimum cost to get from source to target
        private long dijkstra(Map<String, List<Node>> adj, String source, String target) {
            final var q = new PriorityQueue<>(Comparator.comparingLong(Node::cost));
            final var dist = new HashMap<String, Long>();

            q.offer(new Node(source, 0L));
            dist.put(source, 0L);
            while (!q.isEmpty()) {
                final var node = q.poll();
                for (var neighbor : adj.getOrDefault(node.id, emptyList())) {
                    final var totalCost = node.cost + neighbor.cost;
                    if (totalCost < dist.getOrDefault(neighbor.id, Long.MAX_VALUE)) {
                        dist.put(neighbor.id, totalCost);
                        q.offer(new Node(neighbor.id, totalCost));
                    }
                }
            }
            return dist.getOrDefault(target, Long.MAX_VALUE);
        }

        private long dp(String source, String target, Map<String, List<Node>> adj, SortedSet<Integer> lengths, int i, Long[] cache) {
            // base case
            if (i >= source.length()) {
                return 0;
            }

            // already solved?
            if (cache[i] != null) {
                return cache[i];
            }

            var best = Long.MAX_VALUE;
            if (source.charAt(i) == target.charAt(i)) {
                best = dp(source, target, adj, lengths, i + 1, cache);
            }

            // try every possible length
            for (var length : lengths) {
                if (i + length > source.length()) {
                    break;
                }

                final var start = source.substring(i, i + length);
                final var end = target.substring(i, i + length);

                if (!adj.containsKey(start)) {
                    continue;
                }

                final var res1 = dijkstra(adj, start, end);
                if (res1 == Long.MAX_VALUE) {
                    continue;
                }

                final var res2 = dp(source, target, adj, lengths, i + length, cache);
                if (res2 == Long.MAX_VALUE) {
                    continue;
                }

                best = Math.min(best, res1 + res2);
            }

            // cache and return the result
            return cache[i] = best;
        }

        private record Node(String id, long cost) {
        }
    }
}
