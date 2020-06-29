package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Reconstruct Itinerary](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/)
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports `[from, to]`,
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from `JFK`.
 * Thus, the itinerary must begin with `JFK`.
 *
 * Note:
 * - If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary `["JFK", "LGA"]` has a smaller lexical order
 * than `["JFK", "LGB"]`.
 * - All airports are represented by three capital letters (IATA code).
 * - You may assume all tickets form at least one valid itinerary.
 * - One must use all the tickets once and only once.
 */
object ReconstructItinerary {

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val flights = createFlights(tickets)
        val itinerary = LinkedList<String>()
        dfs("JFK", flights, itinerary)
        return itinerary
    }

    private fun createFlights(tickets: List<List<String>>): Map<String, Queue<String>> {
        val flights = mutableMapOf<String, PriorityQueue<String>>()
        for ((from, to) in tickets) {
            flights.getOrPut(from) { PriorityQueue() }.add(to)
        }
        return flights
    }

    private fun dfs(from: String, flights: Map<String, Queue<String>>, itinerary: LinkedList<String>) {
        val tos = flights[from]
        while (!tos.isNullOrEmpty()) {
            val to = tos.poll()
            dfs(to, flights, itinerary)
        }
        itinerary.addFirst(from)
    }
}