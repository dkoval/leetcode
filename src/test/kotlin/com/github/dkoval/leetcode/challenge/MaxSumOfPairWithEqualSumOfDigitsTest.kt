package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaxSumOfPairWithEqualSumOfDigits.MaxSumOfPairWithEqualSumOfDigitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaxSumOfPairWithEqualSumOfDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(18, 43, 36, 13, 7),
                54
            ),
            Arguments.of(
                intArrayOf(10, 12, 19, 14),
                -1
            )
        )
    }

    @Nested
    inner class MaxSumOfPairWithEqualSumOfDigitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum value of nums(i) + nums(j) that you can obtain over all possible indices i and j that satisfy the conditions`(
            nums: IntArray,
            expected: Int
        ) {
            MaxSumOfPairWithEqualSumOfDigitsRev1().test(nums, expected)
        }
    }
}

fun MaxSumOfPairWithEqualSumOfDigits.test(nums: IntArray, expected: Int) {
    val actual = maximumSum(nums)
    assertEquals(expected, actual)
}
