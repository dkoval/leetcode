package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MinimumJumpsToReachHome.MinimumJumpsToReachHomeBFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumJumpsToReachHomeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(14, 4, 18, 1, 15),
                3,
                15,
                9,
                3
            ),
            Arguments.of(
                intArrayOf(8, 3, 16, 6, 12, 20),
                15,
                13,
                11,
                -1
            ),
            Arguments.of(
                intArrayOf(1, 6, 2, 14, 5, 17, 4),
                16,
                9,
                7,
                2
            ),
            Arguments.of(
                intArrayOf(162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98),
                29,
                98,
                80,
                121
            ),
            Arguments.of(
                intArrayOf(1998),
                1999,
                2000,
                2000,
                3998
            )
        )
    }

    @Nested
    inner class MinimumJumpsToReachHomeBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of jumps needed for the bug to reach its home`(
            forbidden: IntArray,
            a: Int,
            b: Int,
            x: Int,
            expected: Int
        ) {
            MinimumJumpsToReachHomeBFS().test(forbidden, a, b, x, expected)
        }
    }

    private fun MinimumJumpsToReachHome.test(forbidden: IntArray, a: Int, b: Int, x: Int, expected: Int) {
        val actual = minimumJumps(forbidden, a, b, x)
        assertEquals(expected, actual)
    }
}