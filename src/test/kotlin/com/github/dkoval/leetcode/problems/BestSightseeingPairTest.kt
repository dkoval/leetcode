package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.BestSightseeingPair.BestSightseeingPairDPBottomUp
import com.github.dkoval.leetcode.problems.BestSightseeingPair.BestSightseeingPairDPBottomUpInConstantSpace
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BestSightseeingPairTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 1, 5, 2, 6),
                // i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
                11
            ),
            Arguments.of(
                intArrayOf(1, 2),
                2
            )
        )
    }

    @Nested
    inner class BestSightseeingPairDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score of a pair of sightseeing spots`(values: IntArray, expected: Int) {
            BestSightseeingPairDPBottomUp().test(values, expected)
        }
    }

    @Nested
    inner class BestSightseeingPairDPBottomUpInConstantSpaceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score of a pair of sightseeing spots`(values: IntArray, expected: Int) {
            BestSightseeingPairDPBottomUpInConstantSpace().test(values, expected)
        }
    }

    private fun BestSightseeingPair.test(values: IntArray, expected: Int) {
        val actual = maxScoreSightseeingPair(values)
        assertEquals(expected, actual)
    }
}
