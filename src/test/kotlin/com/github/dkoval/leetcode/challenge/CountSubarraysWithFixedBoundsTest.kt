package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSubarraysWithFixedBounds.CountSubarraysWithFixedBoundsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSubarraysWithFixedBoundsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 5, 2, 7, 5),
                1,
                5,
                2L
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1),
                1,
                1,
                10L
            )
        )
    }

    @Nested
    inner class CountSubarraysWithFixedBoundsTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should count the number of subarrays with fixed bounds`(
            nums: IntArray,
            minK: Int,
            maxK: Int,
            expected: Long
        ) {
            CountSubarraysWithFixedBoundsRev1().test(nums, minK, maxK, expected)
        }
    }
}

private fun CountSubarraysWithFixedBounds.test(nums: IntArray, minK: Int, maxK: Int, expected: Long) {
    val actual = countSubarrays(nums, minK, maxK)
    assertEquals(expected, actual)
}
