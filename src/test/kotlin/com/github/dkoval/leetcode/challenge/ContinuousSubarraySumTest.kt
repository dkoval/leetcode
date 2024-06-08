package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ContinuousSubarraySum.ContinuousSubarraySumRev1
import com.github.dkoval.leetcode.challenge.ContinuousSubarraySum.ContinuousSubarraySumRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ContinuousSubarraySumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(23, 2, 4, 6, 7),
                6,
                true
            ),
            Arguments.of(
                intArrayOf(23, 2, 6, 4, 7),
                6,
                true
            ),
            Arguments.of(
                intArrayOf(23, 2, 6, 4, 7),
                13,
                false
            ),
            Arguments.of(
                intArrayOf(5, 0, 0, 0),
                3,
                true
            )
        )
    }

    @Nested
    inner class ContinuousSubarraySumRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k`(
            nums: IntArray,
            k: Int,
            expected: Boolean
        ) {
            ContinuousSubarraySumRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class ContinuousSubarraySumRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k`(
            nums: IntArray,
            k: Int,
            expected: Boolean
        ) {
            ContinuousSubarraySumRev2().test(nums, k, expected)
        }
    }
}

private fun ContinuousSubarraySum.test(nums: IntArray, k: Int, expected: Boolean) {
    val actual = checkSubarraySum(nums, k)
    assertEquals(expected, actual)
}
