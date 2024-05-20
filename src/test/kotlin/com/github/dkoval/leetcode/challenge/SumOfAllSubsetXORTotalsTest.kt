package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SumOfAllSubsetXORTotals.SumOfAllSubsetXORTotalsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SumOfAllSubsetXORTotalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3),
                6
            ),
            Arguments.of(
                intArrayOf(5, 1, 6),
                28
            ),
            Arguments.of(
                intArrayOf(3, 4, 5, 6, 7, 8),
                480
            )
        )
    }

    @Nested
    inner class SumOfAllSubsetXORTotalsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the sum of all XOR totals for every subset of nums`(nums: IntArray, expected: Int) {
            SumOfAllSubsetXORTotalsRev1().test(nums, expected)
        }
    }
}

private fun SumOfAllSubsetXORTotals.test(nums: IntArray, expected: Int) {
    val actual = subsetXORSum(nums)
    assertEquals(expected, actual)
}
