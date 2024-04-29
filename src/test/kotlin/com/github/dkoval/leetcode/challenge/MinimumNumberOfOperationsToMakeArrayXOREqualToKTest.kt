package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeArrayXOREqualToK.MinimumNumberOfOperationsToMakeArrayXOREqualToKRev1
import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeArrayXOREqualToK.MinimumNumberOfOperationsToMakeArrayXOREqualToKRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfOperationsToMakeArrayXOREqualToKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3, 4),
                1,
                2
            ),
            Arguments.of(
                intArrayOf(2, 0, 2, 0),
                0,
                0
            )
        )
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeArrayXOREqualToKRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations required to make the bitwise XOR of all elements of the final array equal to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MinimumNumberOfOperationsToMakeArrayXOREqualToKRev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeArrayXOREqualToKRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations required to make the bitwise XOR of all elements of the final array equal to k`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            MinimumNumberOfOperationsToMakeArrayXOREqualToKRev2().test(nums, k, expected)
        }
    }
}

private fun MinimumNumberOfOperationsToMakeArrayXOREqualToK.test(nums: IntArray, k: Int, expected: Int) {
    val actual = minOperations(nums, k)
    assertEquals(expected, actual)
}
