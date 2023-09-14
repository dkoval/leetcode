package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReconstructItinerary.ReconstructItineraryRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReconstructItineraryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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

    @Nested
    inner class ReconstructItineraryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reconstruct itinerary`(tickets: List<List<String>>, expected: List<String>) {
            ReconstructItineraryRev1.test(tickets, expected)
        }
    }

    @Nested
    inner class ReconstructItineraryRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reconstruct itinerary`(tickets: List<List<String>>, expected: List<String>) {
            ReconstructItineraryRev2().test(tickets, expected)
        }
    }
}

private fun ReconstructItinerary.test(tickets: List<List<String>>, expected: List<String>) {
    val actual = findItinerary(tickets)
    assertEquals(expected, actual)
}
