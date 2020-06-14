package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Cheapest Flights Within K Stops](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/)
 *
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 */
object CheapestFlightsWithinKStops {

    // Resources:
    // https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
    // https://www.youtube.com/watch?v=IQOG3w4abAg
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val prices = mutableMapOf<Int, MutableMap<Int, Int>>()
        for ((u, v, price) in flights) {
            val adj = prices.getOrPut(u) { mutableMapOf() }
            adj[v] = price
        }
        val pq = PriorityQueue<FlightToDst>(compareBy { it.price })
        pq.add(FlightToDst(src, 0, K + 1))
        while (!pq.isEmpty()) {
            val flight = pq.remove()
            if (flight.dst == dst) {
                return flight.price
            }
            if (flight.numStops > 0) {
                val adj = prices.getOrDefault(flight.dst, mutableMapOf())
                for ((v, price) in adj.entries) {
                    pq.add(FlightToDst(v, flight.price + price, flight.numStops - 1))
                }
            }
        }
        return -1
    }

    private data class FlightToDst(val dst: Int, val price: Int, val numStops: Int)
}