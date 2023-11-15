package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumElementAfterDecreasingAndRearranging.MaximumElementAfterDecreasingAndRearrangingRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumElementAfterDecreasingAndRearrangingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 2, 1, 2, 1),
                2
            ),
            Arguments.of(
                intArrayOf(100, 1, 1000),
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                5
            ),
            Arguments.of(
                intArrayOf(73, 98, 9),
                3
            )
        )
    }

    @Nested
    inner class MaximumElementAfterDecreasingAndRearrangingRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible value of an element in arr after performing the operations to satisfy the conditions`(
            arr: IntArray,
            expected: Int
        ) {
            MaximumElementAfterDecreasingAndRearrangingRev1().test(arr, expected)
        }
    }
}

private fun MaximumElementAfterDecreasingAndRearranging.test(arr: IntArray, expected: Int) {
    val actual = maximumElementAfterDecrementingAndRearranging(arr)
    assertEquals(expected, actual)
}
