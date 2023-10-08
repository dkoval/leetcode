package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxDotProductOfTwoSubsequences.MaxDotProductOfTwoSubsequencesDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaxDotProductOfTwoSubsequencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, -2, 5),
                intArrayOf(3, 0, -6),
                18
            ),
            Arguments.of(
                intArrayOf(3, -2),
                intArrayOf(2, -6, 7),
                21
            ),
            Arguments.of(
                intArrayOf(-1, -1),
                intArrayOf(1, 1),
                -1
            )
        )
    }

    @Nested
    inner class MaxDotProductOfTwoSubsequencesDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length`(
            nums1: IntArray,
            nums2: IntArray,
            expected: Int
        ) {
            MaxDotProductOfTwoSubsequencesDPTopDown().test(nums1, nums2, expected)
        }
    }
}

private fun MaxDotProductOfTwoSubsequences.test(nums1: IntArray, nums2: IntArray, expected: Int) {
    val actual = maxDotProduct(nums1, nums2)
    assertEquals(expected, actual)
}
