package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestSubarrayWithMaximumBitwiseAND.LongestSubarrayWithMaximumBitwiseANDRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestSubarrayWithMaximumBitwiseANDTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 3, 2, 2),
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                1
            ),
            Arguments.of(
                intArrayOf(100, 5, 5),
                1
            ),
            Arguments.of(
                intArrayOf(96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 96317, 279979),
                1
            )
        )
    }

    @Nested
    inner class LongestSubarrayWithMaximumBitwiseANDRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest such subarray`(nums: IntArray, expected: Int) {
            LongestSubarrayWithMaximumBitwiseANDRev1().test(nums, expected)
        }
    }
}

private fun LongestSubarrayWithMaximumBitwiseAND.test(nums: IntArray, expected: Int) {
    val actual = longestSubarray(nums)
    assertEquals(expected, actual)
}
