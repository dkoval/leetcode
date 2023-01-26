package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
 *
 * There are n cities connected by some number of flights. You are given an array flights where ```flights[i] = [fromi, toi, pricei]```
 * indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 *
 * Constraints:
 *
 * - 1 <= n <= 100
 * - 0 <= flights.length <= (n * (n - 1) / 2)
 * - flights[i].length == 3
 * - 0 <= fromi, toi < n
 * - fromi != toi
 * - 1 <= pricei <= 104
 * - There will not be any multiple flights between two cities.
 * - 0 <= src, dst, k < n
 *  - src != dst
 */
object CheapestFlightsWithinKStops {
    data class City(val id: Int, val stops: Int)
    data class Node(val city: City, val totalPrice: Int)

    // Resources:
    // https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
    // https://www.youtube.com/watch?v=IQOG3w4abAg
    // https://www.youtube.com/watch?v=5eIK3zUdYmE
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // adj list
        val graph = MutableList(n) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, price) in flights) {
            graph[u].add(v to price)
        }

        val maxStops = k + 1 // dst is not counted as a stop
        val prices = mutableMapOf<City, Int>()
        val q = PriorityQueue<Node>(compareBy { it.totalPrice })
        fun enqueue(node: Int, stops: Int, price: Int) {
            if (stops <= maxStops) {
                val city = City(node, stops)
                if (city !in prices || prices[city]!! > price) {
                    prices[city] = price
                    q.offer(Node(city, price))
                }
            }
        }

        enqueue(src, 0, 0)
        while (!q.isEmpty()) {
            val (city, totalPrice) = q.poll()
            if (city.id == dst) {
                return totalPrice
            }

            if (prices[city]!! < totalPrice) {
                continue
            }

            for ((v, price) in graph[city.id]) {
                enqueue(v, city.stops + 1, totalPrice + price)
            }
        }
        return -1
    }
}