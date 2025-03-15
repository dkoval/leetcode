package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumCountOfPositiveIntegerAndNegativeInteger.MaximumCountOfPositiveIntegerAndNegativeIntegerRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumCountOfPositiveIntegerAndNegativeIntegerTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-2, -1, -1, 1, 2, 3),
                3
            ),
            Arguments.of(
                intArrayOf(-3, -2, -1, 0, 0, 1, 2),
                3
            ),
            Arguments.of(
                intArrayOf(5, 20, 66, 1314),
                4
            )
        )
    }

    @Nested
    inner class MaximumCountOfPositiveIntegerAndNegativeIntegerRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum between the number of positive integers and the number of negative integers`(
            nums: IntArray,
            expected: Int
        ) {
            MaximumCountOfPositiveIntegerAndNegativeIntegerRev1().test(nums, expected)
        }
    }
}

private fun MaximumCountOfPositiveIntegerAndNegativeInteger.test(nums: IntArray, expected: Int) {
    val actual = maximumCount(nums)
    assertEquals(expected, actual)
}
