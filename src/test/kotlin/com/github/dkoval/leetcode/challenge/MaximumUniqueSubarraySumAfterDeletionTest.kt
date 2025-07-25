package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumUniqueSubarraySumAfterDeletion.MaximumUniqueSubarraySumAfterDeletionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumUniqueSubarraySumAfterDeletionTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                15
            ),
            Arguments.of(
                intArrayOf(1, 1, 0, 1, 1),
                1
            ),
            Arguments.of(
                intArrayOf(1, 2, -1, -2, 1, 0, -1),
                3
            ),
            Arguments.of(
                intArrayOf(-100),
                -100
            )
        )
    }

    @Nested
    inner class MaximumUniqueSubarraySumAfterDeletionTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum sum of a unique subarray after deleting one element`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumUniqueSubarraySumAfterDeletionRev1().test(nums, expected)
        }
    }
}

private fun MaximumUniqueSubarraySumAfterDeletion.test(nums: IntArray, expected: Int) {
    val actual = maxSum(nums)
    assertEquals(expected, actual)
}
