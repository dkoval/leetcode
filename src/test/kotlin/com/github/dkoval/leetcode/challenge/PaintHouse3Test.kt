package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PaintHouse3.PaintHouse3DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PaintHouse3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 0, 0, 0, 0),
                arrayOf(
                    intArrayOf(1, 10),
                    intArrayOf(10, 1),
                    intArrayOf(10, 1),
                    intArrayOf(1, 10),
                    intArrayOf(5, 1)
                ),
                5,
                2,
                3,
                9
            ),
            Arguments.of(
                intArrayOf(0, 2, 1, 2, 0),
                arrayOf(
                    intArrayOf(1, 10),
                    intArrayOf(10, 1),
                    intArrayOf(10, 1),
                    intArrayOf(1, 10),
                    intArrayOf(5, 1)
                ),
                5,
                2,
                3,
                11
            ),
            Arguments.of(
                intArrayOf(3, 1, 2, 3),
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1)
                ),
                4,
                3,
                3,
                -1
            )
        )
    }

    @Nested
    inner class PaintHouse3DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods`(
            houses: IntArray,
            cost: Array<IntArray>,
            m: Int,
            n: Int,
            target: Int,
            expected: Int
        ) {
            PaintHouse3DPTopDown().test(houses, cost, m, n, target, expected)
        }
    }

    private fun PaintHouse3.test(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int, expected: Int) {
        val actual = minCost(houses, cost, m, n, target)
        assertEquals(expected, actual)
    }
}