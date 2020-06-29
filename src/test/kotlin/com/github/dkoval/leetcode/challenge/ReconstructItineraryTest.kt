package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ReconstructItineraryTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    listOf("MUC", "LHR"),
                    listOf("JFK", "MUC"),
                    listOf("SFO", "SJC"),
                    listOf("LHR", "SFO")
                ),
                listOf("JFK", "MUC", "LHR", "SFO", "SJC")
            ),
            Arguments.of(
                listOf(
                    listOf("JFK","SFO"),
                    listOf("JFK","ATL"),
                    listOf("SFO","ATL"),
                    listOf("ATL","JFK"),
                    listOf("ATL","SFO")
                ),
                listOf("JFK","ATL","JFK","SFO","ATL","SFO")
            ),
            Arguments.of(
                listOf(
                    listOf("JFK","KUL"),
                    listOf("JFK","NRT"),
                    listOf("NRT","JFK")
                ),
                listOf("JFK","NRT","JFK","KUL")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reconstruct itinerary`(tickets: List<List<String>>, expected: List<String>) {
        val actual = ReconstructItinerary.findItinerary(tickets)
        assertEquals(expected, actual)
    }
}