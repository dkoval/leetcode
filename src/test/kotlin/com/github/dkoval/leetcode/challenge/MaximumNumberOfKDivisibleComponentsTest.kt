package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfKDivisibleComponents.MaximumNumberOfKDivisibleComponentsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfKDivisibleComponentsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 4)
                ),
                intArrayOf(1, 8, 1, 4, 4),
                6,
                2
            ),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 5),
                    intArrayOf(2, 6)
                ),
                intArrayOf(3, 0, 6, 1, 5, 2, 1),
                3,
                3
            )
        )
    }

    @Nested
    inner class MaximumNumberOfKDivisibleComponentsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of components the tree can be split into such that the sum of the values in each component is divisible by k`(
            n: Int,
            edges: Array<IntArray>,
            values: IntArray,
            k: Int,
            expected: Int
        ) {
            MaximumNumberOfKDivisibleComponentsRev1().test(n, edges, values, k, expected)
        }
    }
}

private fun MaximumNumberOfKDivisibleComponents.test(
    n: Int,
    edges: Array<IntArray>,
    values: IntArray,
    k: Int,
    expected: Int
) {
    val actual = maxKDivisibleComponents(n, edges, values, k)
    assertEquals(expected, actual)
}
