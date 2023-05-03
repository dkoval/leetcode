package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindDifferenceOfTwoArrays.FindDifferenceOfTwoArraysRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindDifferenceOfTwoArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                intArrayOf(2, 4, 6),
                listOf(listOf(1, 3), listOf(4, 6))
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 3),
                intArrayOf(1, 1, 2, 2),
                listOf(listOf(3), emptyList())
            )
        )
    }

    @Nested
    inner class FindDifferenceOfTwoArraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the difference of two arrays`(nums1: IntArray, nums2: IntArray, expected: List<List<Int>>) {
            FindDifferenceOfTwoArraysRev1().test(nums1, nums2, expected)
        }
    }
}

private fun FindDifferenceOfTwoArrays.test(nums1: IntArray, nums2: IntArray, expected: List<List<Int>>) {
    val actual = findDifference(nums1, nums2)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
