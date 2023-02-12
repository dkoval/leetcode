package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital">Minimum Fuel Cost to Report to the Capital</a>
 * <p>
 * There is a tree (i.e., a connected, undirected graph with no cycles) structure country network consisting of n cities
 * numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0.
 * You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
 * <p>
 * There is a meeting for the representatives of each city. The meeting is in the capital city.
 * <p>
 * There is a car in each city. You are given an integer seats that indicates the number of seats in each car.
 * <p>
 * A representative can use the car in their city to travel or change the car and ride with another representative.
 * The cost of traveling between two cities is one liter of fuel.
 * <p>
 * Return the minimum number of liters of fuel to reach the capital city.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>roads.length == n - 1</li>
 *  <li>roads[i].length == 2</li>
 *  <li>0 <= ai, bi < n</li>
 *  <li>ai != bi
 *  <li>roads represents a valid tree.</li>
 *  <li>1 <= seats <= 10^5</li>
 * </ul>
 */
public interface MinimumFuelCostToReportToCapital {

    long minimumFuelCost(int[][] roads, int seats);

    // O(N) time | O(N) space
    class MinimumFuelCostToReportToCapitalDFS implements MinimumFuelCostToReportToCapital {

        @Override
        public long minimumFuelCost(int[][] roads, int seats) {
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for (int[] edge : roads) {
                adjList.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
                adjList.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
            }

            Node ans = dfs(adjList, seats, 0, -1);
            return ans.fuel;
        }

        private Node dfs(Map<Integer, List<Integer>> adjList, int seats, int u, int parent) {
            int people = 1;
            long fuel = 0;
            for (int v : adjList.getOrDefault(u, Collections.emptyList())) {
                if (v != parent) {
                    Node ans = dfs(adjList, seats, v, u);
                    people += ans.people;
                    // the number of cars needed to transfer p people from v to u:
                    // c = round_up(p / seats) = (p + seats - 1) / seats
                    // to drive from v to u (1 level up), c cars consume c amount of fuel
                    fuel += ans.fuel + (ans.people + seats - 1) / seats;
                }
            }
            return new Node(people, fuel);
        }

        private static class Node {
            // the number of people arriving at this node
            final int people;
            // the minimum fuel cost to get all children to this node
            final long fuel;

            private Node(int people, long fuel) {
                this.people = people;
                this.fuel = fuel;
            }
        }
    }
}
