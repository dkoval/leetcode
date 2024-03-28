package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LengthOfLongestSubarrayWithAtMostKFrequency.LengthOfLongestSubarrayWithAtMostKFrequencyRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LengthOfLongestSubarrayWithAtMostKFrequencyTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 1, 2, 3, 1, 2),
                2,
                6
            ),
            Arguments.of(
                intArrayOf(1, 2, 1, 2, 1, 2, 1, 2),
                1,
                2
            ),
            Arguments.of(
                intArrayOf(5, 5, 5, 5, 5, 5, 5),
                4,
                4
            )
        )
    }

    @Nested
    inner class LengthOfLongestSubarrayWithAtMostKFrequencyRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest good subarray of nums`(nums: IntArray, k: Int, expected: Int) {
            LengthOfLongestSubarrayWithAtMostKFrequencyRev1().test(nums, k, expected)
        }
    }
}

private fun LengthOfLongestSubarrayWithAtMostKFrequency.test(nums: IntArray, k: Int, expected: Int) {
    val actual = maxSubarrayLength(nums, k)
    assertEquals(expected, actual)
}
