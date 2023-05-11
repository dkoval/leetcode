package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UncrossedLines.UncrossedLinesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UncrossedLinesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 4, 2),
                intArrayOf(1, 2, 4),
                2
            ),
            Arguments.of(
                intArrayOf(2, 5, 1, 2, 5),
                intArrayOf(10, 5, 2, 1, 5, 2),
                3
            ),
            Arguments.of(
                intArrayOf(1, 3, 7, 1, 7, 5),
                intArrayOf(1, 9, 2, 5, 1),
                2
            )
        )
    }

    @Nested
    inner class UncrossedLinesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of uncrossed connecting lines`(nums1: IntArray, nums2: IntArray, expected: Int) {
            UncrossedLinesDPTopDown().test(nums1, nums2, expected)
        }
    }

    @Nested
    inner class UncrossedLinesDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of uncrossed connecting lines`(nums1: IntArray, nums2: IntArray, expected: Int) {
            UncrossedLinesDPBottomUp.test(nums1, nums2, expected)
        }
    }
}

private fun UncrossedLines.test(nums1: IntArray, nums2: IntArray, expected: Int) {
    val actual = maxUncrossedLines(nums1, nums2)
    assertEquals(expected, actual)
}
