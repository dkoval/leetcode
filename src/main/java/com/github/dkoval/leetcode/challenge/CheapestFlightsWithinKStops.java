package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

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

    // Resource: https://www.youtube.com/watch?v=5eIK3zUdYmE
    class CheapestFlightsWithinKStopsBellmanFord implements CheapestFlightsWithinKStops {

        // O(E * k) time | O(N) space
        @Override
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Bellman - Ford
            // There are k + 1 layers to iterate through.
            // At each layer, iterate through all the edges and update prices[].

            // prices[i] - the cheapest price to get to i from src
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src] = 0;

            for (int layer = 0; layer < k + 1; layer++) {
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
}
