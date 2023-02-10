package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.AsFarFromLandAsPossible.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AsFarFromLandAsPossibleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1)
                ),
                2
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0)
                ),
                4
            )
        )
    }

    @Nested
    inner class AsFarFromLandAsPossibleBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find a water cell such that its distance to the nearest land cell is maximized`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            AsFarFromLandAsPossibleBruteForce().test(grid, expected)
        }
    }

    @Nested
    inner class AsFarFromLandAsPossibleBFSRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find a water cell such that its distance to the nearest land cell is maximized`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            AsFarFromLandAsPossibleBFSRev1().test(grid, expected)
        }
    }

    @Nested
    inner class AsFarFromLandAsPossibleBFSRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find a water cell such that its distance to the nearest land cell is maximized`(
            grid: Array<IntArray>,
            expected: Int
        ) {
            AsFarFromLandAsPossibleBFSRev2().test(grid, expected)
        }
    }

    private fun AsFarFromLandAsPossible.test(grid: Array<IntArray>, expected: Int) {
        val actual = maxDistance(grid)
        assertEquals(expected, actual)
    }
}