package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumAbsoluteSumOfAnySubarray.MaximumAbsoluteSumOfAnySubarrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MaximumAbsoluteSumOfAnySubarrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, -3, 2, 3, -4),
                5
            ),
            Arguments.of(
                intArrayOf(2, -5, 1, -4, 3, -2),
                8
            )
        )
    }

    @Nested
    inner class MaximumAbsoluteSumOfAnySubarrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum absolute sum of any subarray of nums`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumAbsoluteSumOfAnySubarrayRev1().test(nums, expected)
        }
    }
}

private fun MaximumAbsoluteSumOfAnySubarray.test(nums: IntArray, expected: Int) {
    val actual = maxAbsoluteSum(nums)
    assertEquals(expected, actual)
}
