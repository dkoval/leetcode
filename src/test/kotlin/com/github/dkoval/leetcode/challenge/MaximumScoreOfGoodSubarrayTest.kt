package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumScoreOfGoodSubarray.MaximumScoreOfGoodSubarrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumScoreOfGoodSubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4, 3, 7, 4, 5),
                3,
                15
            ),
            Arguments.of(
                intArrayOf(5, 5, 4, 5, 4, 1, 1, 1),
                0,
                20
            )
        )
    }

    @Nested
    inner class MaximumScoreOfGoodSubarrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible score of a good subarray`(nums: IntArray, k: Int, expected: Int) {
            MaximumScoreOfGoodSubarrayRev1().test(nums, k, expected)
        }
    }
}

private fun MaximumScoreOfGoodSubarray.test(nums: IntArray, k: Int, expected: Int) {
    val actual = maximumScore(nums, k)
    assertEquals(expected, actual)
}
