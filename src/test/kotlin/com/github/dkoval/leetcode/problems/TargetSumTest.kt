package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TargetSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                3,
                5
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                1
            )
        )
    }

    @Nested
    inner class TargetSumDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of different expressions that you can build, which evaluates to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {

        }
    }

    private fun TargetSum.test(nums: IntArray, target: Int, expected: Int) {
        val actual = findTargetSumWays(nums, target)
        assertEquals(expected, actual)
    }
}