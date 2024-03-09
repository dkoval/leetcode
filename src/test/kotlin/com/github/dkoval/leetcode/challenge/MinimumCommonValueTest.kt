package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumCommonValue.MinimumCommonValueRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumCommonValueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                intArrayOf(2, 4),
                2
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 6),
                intArrayOf(2, 3, 4, 5),
                2
            )
        )
    }

    @Nested
    inner class MinimumCommonValueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum integer common to both arrays`(nums1: IntArray, nums2: IntArray, expected: Int) {
            MinimumCommonValueRev1().test(nums1, nums2, expected)
        }
    }
}

private fun MinimumCommonValue.test(nums1: IntArray, nums2: IntArray, expected: Int) {
    val actual = getCommon(nums1, nums2)
    assertEquals(expected, actual)
}
