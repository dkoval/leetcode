package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimizeMaximumPairSumInArray.MinimizeMaximumPairSumInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimizeMaximumPairSumInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 5, 2, 3),
                7
            ),
            Arguments.of(
                intArrayOf(3, 5, 4, 2, 4, 6),
                8
            ),
            Arguments.of(
                intArrayOf(4, 1, 5, 1, 2, 5, 1, 5, 5, 4),
                8
            ),
        )
    }

    @Nested
    inner class MinimizeMaximumPairSumInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimized maximum pair sum after optimally pairing up the elements`(
            nums: IntArray,
            expected: Int
        ) {
            MinimizeMaximumPairSumInArrayRev1().test(nums, expected)
        }
    }
}

private fun MinimizeMaximumPairSumInArray.test(nums: IntArray, expected: Int) {
    val actual = minPairSum(nums)
    assertEquals(expected, actual)
}
