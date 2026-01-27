package com.github.dkoval.leetcode.challenge;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-path-with-edge-reversals">Minimum Cost Path with Edge Reversals</a>
 * <p>
 * You are given a directed, weighted graph with n nodes labeled from 0 to n - 1, and an array edges where edges[i] = [ui, vi, wi]
 * represents a directed edge from node ui to node vi with cost wi.
 * <p>
 * Each node ui has a switch that can be used at most once: when you arrive at ui and have not yet used its switch,
 * you may activate it on one of its incoming edges vi → ui reverse that edge to ui → vi and immediately traverse it.
 * <p>
 * The reversal is only valid for that single move, and using a reversed edge costs 2 * wi.
 * <p>
 * Return the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 5 * 10^4</li>
 *  <li>1 <= edges.length <= 10^5</li>
 *  <li>edges[i] = [ui, vi, wi]</li>
 *  <li>0 <= ui, vi <= n - 1</li>
 *  <li>1 <= wi <= 1000</li>
 * </ul>
 */
public interface MinimumCostPathWithEdgeReversals {

    int minCost(int n, int[][] edges);

    class MinimumCostPathWithEdgeReversalsRev1 implements MinimumCostPathWithEdgeReversals {

        @Override
        public int minCost(int n, int[][] edges) {
            final var adj = new HashMap<Integer, List<Node>>();
            for (var edge : edges) {
                final var u = edge[0];
                final var v = edge[1];
                final var cost = edge[2];
                adj.computeIfAbsent(u, __ -> new ArrayList<>()).add(new Node(v, cost));
                adj.computeIfAbsent(v, __ -> new ArrayList<>()).add(new Node(u, 2 * cost));
            }

            // Dijkstra
            final var q = new PriorityQueue<>(Comparator.comparingInt(Node::cost));

            // costs[i] - the total cost of getting to the i-th node from the souce node 0
            final var costs = new int[n];
            Arrays.fill(costs, Integer.MAX_VALUE);

            q.offer(new Node(0, 0));
            costs[0] = 0;
            while (!q.isEmpty()) {
                final var node = q.poll();
                for (var neighbor : adj.getOrDefault(node.id, emptyList())) {
                    final var totalCost = node.cost + neighbor.cost;
                    if (totalCost < costs[neighbor.id]) {
                        costs[neighbor.id] = totalCost;
                        q.offer(new Node(neighbor.id, totalCost));
                    }
                }
            }
            return (costs[n - 1] != Integer.MAX_VALUE) ? costs[n - 1] : -1;
        }

        record Node(int id, int cost) {
        }
    }
}
