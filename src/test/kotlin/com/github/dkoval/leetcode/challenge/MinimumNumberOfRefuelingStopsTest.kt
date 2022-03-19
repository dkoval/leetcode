package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfRefuelingStops.MinimumNumberOfRefuelingStopsBottomUpInQuadraticTime
import com.github.dkoval.leetcode.challenge.MinimumNumberOfRefuelingStops.MinimumNumberOfRefuelingStopsUsingMaxHeap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfRefuelingStopsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                1,
                arrayOf<IntArray>(),
                0
            ),
            Arguments.of(
                100,
                1,
                arrayOf(
                    intArrayOf(10, 100)
                ),
                -1
            ),
            Arguments.of(
                100,
                10,
                arrayOf(
                    intArrayOf(10, 60),
                    intArrayOf(20, 30),
                    intArrayOf(30, 30),
                    intArrayOf(60, 40)
                ),
                2
            )
        )
    }

    @Nested
    inner class MinimumNumberOfRefuelingStopsBottomUpInQuadraticTimeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return least number of refueling stops the car must make in order to reach target`(
            target: Int,
            startFuel: Int,
            stations: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfRefuelingStopsBottomUpInQuadraticTime().test(target, startFuel, stations, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfRefuelingStopsUsingMaxHeapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return least number of refueling stops the car must make in order to reach target`(
            target: Int,
            startFuel: Int,
            stations: Array<IntArray>,
            expected: Int
        ) {
            MinimumNumberOfRefuelingStopsUsingMaxHeap().test(target, startFuel, stations, expected)
        }
    }

    private fun MinimumNumberOfRefuelingStops.test(
        target: Int,
        startFuel: Int,
        stations: Array<IntArray>,
        expected: Int
    ) {
        val actual = minRefuelStops(target, startFuel, stations)
        assertEquals(expected, actual)
    }
}