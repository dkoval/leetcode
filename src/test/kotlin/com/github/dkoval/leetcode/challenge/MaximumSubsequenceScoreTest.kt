package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumSubsequenceScore.MaximumSubsequenceScoreRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumSubsequenceScoreTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 3, 2),
                intArrayOf(2, 1, 3, 4),
                3,
                12L
            ),
            Arguments.of(
                intArrayOf(4, 2, 3, 1, 1),
                intArrayOf(7, 5, 10, 9, 6),
                1,
                30L
            )
        )
    }

    @Nested
    inner class MaximumSubsequenceScoreRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible score`(nums1: IntArray, nums2: IntArray, k: Int, expected: Long) {
            MaximumSubsequenceScoreRev1().test(nums1, nums2, k, expected)
        }
    }
}

private fun MaximumSubsequenceScore.test(nums1: IntArray, nums2: IntArray, k: Int, expected: Long) {
    val actual = maxScore(nums1, nums2, k)
    assertEquals(expected, actual)
}
