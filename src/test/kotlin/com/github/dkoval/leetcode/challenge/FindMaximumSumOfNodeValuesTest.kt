package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindMaximumSumOfNodeValues.FindMaximumSumOfNodeValuesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMaximumSumOfNodeValuesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 1),
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2)
                ),
                6L
            ),
            Arguments.of(
                intArrayOf(2, 3),
                7,
                arrayOf(
                    intArrayOf(0, 1)
                ),
                9L
            ),
            Arguments.of(
                intArrayOf(7, 7, 7, 7, 7, 7),
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(0, 4),
                    intArrayOf(0, 5)
                ),
                42L
            )
        )
    }

    @Nested
    inner class FindMaximumSumOfNodeValuesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum possible sum of the values Alice can achieve by performing the operation any number of times`(
            nums: IntArray,
            k: Int,
            edges: Array<IntArray>,
            expected: Long
        ) {
            FindMaximumSumOfNodeValuesRev1().test(nums, k, edges, expected)
        }
    }
}

private fun FindMaximumSumOfNodeValues.test(nums: IntArray, k: Int, edges: Array<IntArray>, expected: Long) {
    val actual = maximumValueSum(nums, k, edges)
    assertEquals(expected, actual)
}
