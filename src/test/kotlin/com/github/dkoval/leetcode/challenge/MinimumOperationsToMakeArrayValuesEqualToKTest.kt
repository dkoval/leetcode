package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumOperationsToMakeArrayValuesEqualToK.MinimumOperationsToMakeArrayValuesEqualToKRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumOperationsToMakeArrayValuesEqualToKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 2, 5, 4, 5),
                2,
                2
            ),
            Arguments.of(
                intArrayOf(2, 1, 2),
                2,
                -1
            ),
            Arguments.of(
                intArrayOf(9, 7, 5, 3),
                1,
                4
            )
        )
    }

    @Nested
    inner class MinimumOperationsToMakeArrayValuesEqualToKTestRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations to make all elements in the array equal to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MinimumOperationsToMakeArrayValuesEqualToKRev1().test(nums, k, expected)
        }
    }
}

private fun MinimumOperationsToMakeArrayValuesEqualToK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = minOperations(nums, k)
    assertEquals(expected, actual)
}
