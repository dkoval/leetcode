package com.github.dkoval.leetcode.challenge

import java.util.*

object ReconstructItineraryRev1 : ReconstructItinerary {

    override fun findItinerary(tickets: List<List<String>>): List<String> {
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