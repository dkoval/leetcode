package com.github.dkoval.leetcode.challenge

import java.util.*

object CheapestFlightsWithinKStopsModifiedDijkstra : CheapestFlightsWithinKStops {
    data class City(val id: Int, val stops: Int)
    data class Node(val city: City, val totalPrice: Int)

    // Resources:
    //
    // UPD Jan, 2023. Gives TLE on larger inputs:
    // https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
    // https://www.youtube.com/watch?v=IQOG3w4abAg
    //
    // UPD Jan, 2023. Accepted:
    // https://www.youtube.com/watch?v=vieoNLIMTLc
    override fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
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