package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IntersectionOfTwoArrays.IntersectionOfTwoArraysRev1
import com.github.dkoval.leetcode.challenge.IntersectionOfTwoArrays.IntersectionOfTwoArraysRev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IntersectionOfTwoArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 1),
                intArrayOf(2, 2),
                intArrayOf(2)
            ),
            Arguments.of(
                intArrayOf(4, 9, 5),
                intArrayOf(9, 4, 9, 8, 4),
                intArrayOf(9, 4)
            )
        )
    }

    @Nested
    inner class IntersectionOfTwoArraysRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of intersection of nums1 and nums2`(
            nums1: IntArray,
            nums2: IntArray,
            expected: IntArray
        ) {
            IntersectionOfTwoArraysRev1().test(nums1, nums2, expected)
        }
    }

    @Nested
    inner class IntersectionOfTwoArraysRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of intersection of nums1 and nums2`(
            nums1: IntArray,
            nums2: IntArray,
            expected: IntArray
        ) {
            IntersectionOfTwoArraysRev2().test(nums1, nums2, expected)
        }
    }
}

private fun IntersectionOfTwoArrays.test(
    nums1: IntArray,
    nums2: IntArray,
    expected: IntArray
) {
    val actual = intersection(nums1, nums2)
    assertThat(actual).containsExactlyInAnyOrder(*expected)
}
