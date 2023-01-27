package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheapestFlightsWithinKStops.CheapestFlightsWithinKStopsBellmanFord
import com.github.dkoval.leetcode.challenge.CheapestFlightsWithinKStops.CheapestFlightsWithinKStopsModifiedBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheapestFlightsWithinKStopsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                0,
                2,
                1,
                200
            ),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                0,
                2,
                0,
                500
            ),
            Arguments.of(
                13,
                arrayOf(
                    intArrayOf(11, 12, 74),
                    intArrayOf(1, 8, 91),
                    intArrayOf(4, 6, 13),
                    intArrayOf(7, 6, 39),
                    intArrayOf(5, 12, 8),
                    intArrayOf(0, 12, 54),
                    intArrayOf(8, 4, 32),
                    intArrayOf(0, 11, 4),
                    intArrayOf(4, 0, 91),
                    intArrayOf(11, 7, 64),
                    intArrayOf(6, 3, 88),
                    intArrayOf(8, 5, 80),
                    intArrayOf(11, 10, 91),
                    intArrayOf(10, 0, 60),
                    intArrayOf(8, 7, 92),
                    intArrayOf(12, 6, 78),
                    intArrayOf(6, 2, 8),
                    intArrayOf(4, 3, 54),
                    intArrayOf(3, 11, 76),
                    intArrayOf(3, 12, 23),
                    intArrayOf(11, 6, 79),
                    intArrayOf(6, 12, 36),
                    intArrayOf(2, 11, 100),
                    intArrayOf(2, 5, 49),
                    intArrayOf(7, 0, 17),
                    intArrayOf(5, 8, 95),
                    intArrayOf(3, 9, 98),
                    intArrayOf(8, 10, 61),
                    intArrayOf(2, 12, 38),
                    intArrayOf(5, 7, 58),
                    intArrayOf(9, 4, 37),
                    intArrayOf(8, 6, 79),
                    intArrayOf(9, 0, 1),
                    intArrayOf(2, 3, 12),
                    intArrayOf(7, 10, 7),
                    intArrayOf(12, 10, 52),
                    intArrayOf(7, 2, 68),
                    intArrayOf(12, 2, 100),
                    intArrayOf(6, 9, 53),
                    intArrayOf(7, 4, 90),
                    intArrayOf(0, 5, 43),
                    intArrayOf(11, 2, 52),
                    intArrayOf(11, 8, 50),
                    intArrayOf(12, 4, 38),
                    intArrayOf(7, 9, 94),
                    intArrayOf(2, 7, 38),
                    intArrayOf(3, 7, 88),
                    intArrayOf(9, 12, 20),
                    intArrayOf(12, 0, 26),
                    intArrayOf(10, 5, 38),
                    intArrayOf(12, 8, 50),
                    intArrayOf(0, 2, 77),
                    intArrayOf(11, 0, 13),
                    intArrayOf(9, 10, 76),
                    intArrayOf(2, 6, 67),
                    intArrayOf(5, 6, 34),
                    intArrayOf(9, 7, 62),
                    intArrayOf(5, 3, 67)
                ),
                10,
                1,
                10,
                -1
            )
        )
    }

    @Nested
    inner class CheapestFlightsWithinKStopsModifiedBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the cheapest price from src to dst with up to k stops`(
            n: Int,
            flights: Array<IntArray>,
            src: Int,
            dst: Int,
            k: Int,
            expected: Int
        ) {
            CheapestFlightsWithinKStopsModifiedBFS().test(n, flights, src, dst, k, expected)
        }
    }

    @Nested
    inner class CheapestFlightsWithinKStopsBellmanFordTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the cheapest price from src to dst with up to k stops`(
            n: Int,
            flights: Array<IntArray>,
            src: Int,
            dst: Int,
            k: Int,
            expected: Int
        ) {
            CheapestFlightsWithinKStopsBellmanFord().test(n, flights, src, dst, k, expected)
        }
    }

    @Nested
    inner class CheapestFlightsWithinKStopsModifiedDijkstraTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the cheapest price from src to dst with up to k stops`(
            n: Int,
            flights: Array<IntArray>,
            src: Int,
            dst: Int,
            k: Int,
            expected: Int
        ) {
            CheapestFlightsWithinKStopsModifiedDijkstra.test(n, flights, src, dst, k, expected)
        }
    }
}

private fun CheapestFlightsWithinKStops.test(
    n: Int,
    flights: Array<IntArray>,
    src: Int,
    dst: Int,
    k: Int,
    expected: Int
) {
    val actual = findCheapestPrice(n, flights, src, dst, k)
    assertEquals(expected, actual)
}
