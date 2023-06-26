package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.TotalCostToHireKWorkers.TotalCostToHireKWorkersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TotalCostToHireKWorkersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8),
                3,
                4,
                11L
            ),
            Arguments.of(
                intArrayOf(1, 2, 4, 1),
                3,
                3,
                4L
            ),
            Arguments.of(
                intArrayOf(
                    28,
                    35,
                    21,
                    13,
                    21,
                    72,
                    35,
                    52,
                    74,
                    92,
                    25,
                    65,
                    77,
                    1,
                    73,
                    32,
                    43,
                    68,
                    8,
                    100,
                    84,
                    80,
                    14,
                    88,
                    42,
                    53,
                    98,
                    69,
                    64,
                    40,
                    60,
                    23,
                    99,
                    83,
                    5,
                    21,
                    76,
                    34
                ),
                32,
                12,
                1407L
            )
        )
    }

    @Nested
    inner class TotalCostToHireKWorkersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total cost to hire exactly k workers`(
            costs: IntArray,
            k: Int,
            candidates: Int,
            expected: Long
        ) {
            TotalCostToHireKWorkersRev1().test(costs, k, candidates, expected)
        }
    }
}

private fun TotalCostToHireKWorkers.test(costs: IntArray, k: Int, candidates: Int, expected: Long) {
    val actual = totalCost(costs, k, candidates)
    assertEquals(expected, actual)
}
