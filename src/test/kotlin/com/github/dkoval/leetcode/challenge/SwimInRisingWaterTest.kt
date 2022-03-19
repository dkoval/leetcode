package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SwimInRisingWater.SwimInRisingWaterDFSWithBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class SwimInRisingWaterTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(1, 3)
                ),
                3
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 2, 3, 4),
                    intArrayOf(24, 23, 22, 21, 5),
                    intArrayOf(12, 13, 14, 15, 16),
                    intArrayOf(11, 17, 18, 19, 20),
                    intArrayOf(10, 9, 8, 7, 6)
                ),
                16
            )
        )
    }

    @Nested
    inner class SwimInRisingWaterDFSWithBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the least time until you can reach the bottom right square`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            SwimInRisingWaterDFSWithBinarySearch().test(grid, expected)
        }
    }

    private fun SwimInRisingWater.test(grid: Array<IntArray>, expected: Int) {
        val actual = swimInWater(grid)
        assertEquals(expected, actual)
    }
}