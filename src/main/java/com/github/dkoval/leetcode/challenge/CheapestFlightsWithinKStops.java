package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">Cheapest Flights Within K Stops</a>
 * <p>
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei]
 * indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= flights.length <= (n * (n - 1) / 2)</li>
 *  <li>flights[i].length == 3</li>
 *  <li>0 <= fromi, toi < n</li>
 *  <li>fromi != toi</li>
 *  <li>1 <= pricei <= 10^4</li>
 *  <li>There will not be any multiple flights between two cities.</li>
 *  <li>0 <= src, dst, k < n</li>
 *  <li>src != dst</li>
 * </ul>
 */
public interface CheapestFlightsWithinKStops {

    int findCheapestPrice(int n, int[][] flights, int src, int dst, int k);

    class CheapestFlightsWithinKStopsModifiedBFS implements CheapestFlightsWithinKStops {

        // O(N + E * K)  | O(N + E * K) space
        @Override
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // adj list
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] flight : flights) {
                graph.computeIfAbsent(flight[0], __ -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
            }

            // prices[i] - minimum price to reach i from src
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);

            // BFS
            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(src, 0));
            int stops = 0;
            while (stops <= k && !q.isEmpty()) {
                // process current level
                int size = q.size();
                while (size-- > 0) {
                    Node curr = q.poll();
                    for (int[] neighbor : graph.getOrDefault(curr.id, Collections.emptyList())) {
                        // optimization to avoid TLE
                        int totalPrice = curr.price + neighbor[1];
                        if (totalPrice >= prices[neighbor[0]]) {
                            continue;
                        }
                        prices[neighbor[0]] = totalPrice;
                        q.offer(new Node(neighbor[0], totalPrice));
                    }
                }
                stops++;
            }
            return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
        }

        private static class Node {
            final int id;
            final int price;

            Node(int id, int price) {
                this.id = id;
                this.price = price;
            }
        }
    }

    // Resource: https://www.youtube.com/watch?v=5eIK3zUdYmE
    class CheapestFlightsWithinKStopsBellmanFord implements CheapestFlightsWithinKStops {

        // O((N + E) * K) time | O(N) space
        @Override
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Bellman - Ford
            // Algorithm is used to find the shortest paths from the source node to all other nodes in a weighted graph.
            // It depends on the idea that the shortest path contains at most N - 1 edges.

            // There are k + 1 layers to iterate through.
            // The algorithm loops through each edge k + 1 times.
            // If it finds an edge through which the total cost is smaller than the previously stored value,
            // it uses this edge and stores the new value. This is called relaxing an edge.

            // prices[i] - minimum price to reach i from src
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src] = 0;

            for (int layer = 0; layer < k + 1; layer++) {
                // we need to use another temp array here to make sure the prices from the previous iteration don't change
                int[] tmpPrices = Arrays.copyOf(prices, prices.length);
                for (int[] flight : flights) {
                    int from = flight[0];
                    int to = flight[1];
                    int price = flight[2];
                    if (prices[from] == Integer.MAX_VALUE) {
                        continue;
                    }
                    tmpPrices[to] = Math.min(tmpPrices[to], prices[from] + price);
                }
                prices = tmpPrices;
            }
            return (prices[dst] == Integer.MAX_VALUE) ? -1 : prices[dst];
        }
    }

    class CheapestFlightsWithinKStopsDijkstra implements CheapestFlightsWithinKStops {

        @Override
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Dijkstra's algorithm is used to find the shortest paths from a source node to all the other nodes
            // in a weighted graph where the edge weights are POSITIVE numbers.
            // It makes use of a priority queue to decide which edges to use.

            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] flight : flights) {
                graph.computeIfAbsent(flight[0], __ -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
            }

            // stops[i] - minimum number of stops needed to reach i from src
            int[] stops = new int[n];
            Arrays.fill(stops, Integer.MAX_VALUE);

            Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.price));
            q.offer(new Node(src, 0, 0));
            while (!q.isEmpty()) {
                Node curr = q.poll();

                // only traverse an edge to a node x if x has not already been visited with fewer stops
                if (curr.stops > k + 1 || curr.stops > stops[curr.id]) {
                    continue;
                }

                if (curr.id == dst) {
                    return curr.price;
                }

                stops[curr.id] = curr.stops;
                for (int[] neighbor : graph.getOrDefault(curr.id, Collections.emptyList())) {
                    q.offer(new Node(neighbor[0], curr.price + neighbor[1], curr.stops + 1));
                }
            }
            return -1;
        }

        private static class Node {
            final int id;
            final int price;
            final int stops;

            Node(int id, int price, int stops) {
                this.id = id;
                this.price = price;
                this.stops = stops;
            }
        }
    }
}
