package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumEqualSumOfTwoArraysAfterReplacingZeros.MinimumEqualSumOfTwoArraysAfterReplacingZerosRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumEqualSumOfTwoArraysAfterReplacingZerosTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 2, 0, 1, 0),
                intArrayOf(6, 5, 0),
                12L
            ),
            Arguments.of(
                intArrayOf(2, 0, 2, 0),
                intArrayOf(1, 4),
                -1L
            )
        )
    }

    @Nested
    inner class MinimumEqualSumOfTwoArraysAfterReplacingZerosRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the minimum equal sum of two arrays after replacing zeros`(
            nums1: IntArray,
            nums2: IntArray,
            expected: Long
        ) {
            MinimumEqualSumOfTwoArraysAfterReplacingZerosRev1().test(nums1, nums2, expected)
        }
    }
}

private fun MinimumEqualSumOfTwoArraysAfterReplacingZeros.test(nums1: IntArray, nums2: IntArray, expected: Long) {
    val actual = minSum(nums1, nums2)
    assertEquals(expected, actual)
}
