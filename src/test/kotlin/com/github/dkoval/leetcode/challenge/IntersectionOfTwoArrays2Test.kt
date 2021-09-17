package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IntersectionOfTwoArrays2.IntersectionOfTwoArrays2UsingMaps
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IntersectionOfTwoArrays2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 1),
                intArrayOf(2, 2),
                intArrayOf(2, 2)
            ),
            Arguments.of(
                intArrayOf(4, 9, 5),
                intArrayOf(9, 4, 9, 8, 4),
                intArrayOf(4, 9)
            )
        )
    }

    @Nested
    inner class IntersectionOfTwoArrays2UsingMapsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of their intersection of nums1 and nums2 in ay order`(
            nums1: IntArray,
            nums2: IntArray,
            expected: IntArray
        ) {
            IntersectionOfTwoArrays2UsingMaps().test(nums1, nums2, expected)
        }
    }

    private fun IntersectionOfTwoArrays2.test(nums1: IntArray, nums2: IntArray, expected: IntArray) {
        val actual = intersect(nums1, nums2)
        assertArrayEquals(expected, actual)
    }
}