package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GasStationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 4, 5, 1, 2),
                // Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
                // Travel to station 4. Your tank = 4 - 1 + 5 = 8
                // Travel to station 0. Your tank = 8 - 2 + 1 = 7
                // Travel to station 1. Your tank = 7 - 3 + 2 = 6
                // Travel to station 2. Your tank = 6 - 4 + 3 = 5
                // Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
                // Therefore, return 3 as the starting index.
                3
            ),
            Arguments.of(
                intArrayOf(2, 3, 4),
                intArrayOf(3, 4, 3),
                // You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
                // Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
                // Travel to station 0. Your tank = 4 - 3 + 2 = 3
                // Travel to station 1. Your tank = 3 - 3 + 3 = 3
                // You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
                // Therefore, you can't travel around the circuit once no matter where you start.
                -1
            )
        )
    }

    @Nested
    inner class GasStationBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the starting gas station's index if you can travel around the circuit once `(
            gas: IntArray,
            cost: IntArray,
            expected: Int
        ) {
            GasStationBruteForce.test(gas, cost, expected)
        }
    }

    @Nested
    inner class GasStationGreedyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the starting gas station's index if you can travel around the circuit once `(
            gas: IntArray,
            cost: IntArray,
            expected: Int
        ) {
            GasStationGreedy.test(gas, cost, expected)
        }
    }

    private fun GasStation.test(gas: IntArray, cost: IntArray, expected: Int) {
        val actual = canCompleteCircuit(gas, cost)
        assertEquals(expected, actual)
    }
}