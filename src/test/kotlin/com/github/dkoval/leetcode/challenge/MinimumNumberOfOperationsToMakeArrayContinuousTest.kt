package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumNumberOfOperationsToMakeArrayContinuous.MinimumNumberOfOperationsToMakeArrayContinuousRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumNumberOfOperationsToMakeArrayContinuousTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 5, 3),
                0
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 5, 6),
                1
            ),
            Arguments.of(
                intArrayOf(1, 10, 100, 1000),
                3
            ),
            Arguments.of(
                intArrayOf(41, 33, 29, 33, 35, 26, 47, 24, 18, 28),
                5
            )
        )
    }

    @Nested
    inner class MinimumNumberOfOperationsToMakeArrayContinuousRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations to make nums continuous`(nums: IntArray, expected: Int) {
            MinimumNumberOfOperationsToMakeArrayContinuousRev1().test(nums, expected)
        }
    }
}

private fun MinimumNumberOfOperationsToMakeArrayContinuous.test(nums: IntArray, expected: Int) {
    val actual = minOperations(nums)
    assertEquals(expected, actual)
}
