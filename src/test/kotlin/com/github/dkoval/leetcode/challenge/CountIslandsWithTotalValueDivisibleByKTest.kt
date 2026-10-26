package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountIslandsWithTotalValueDivisibleByK.CountIslandsWithTotalValueDivisibleByKRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CountIslandsWithTotalValueDivisibleByKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                arrayOf(
                    intArrayOf(0, 2, 1, 0, 0),
                    intArrayOf(0, 5, 0, 0, 5),
                    intArrayOf(0, 0, 1, 0, 0),
                    intArrayOf(0, 1, 4, 7, 0),
                    intArrayOf(0, 2, 0, 0, 8)
                ),
                5,
                2
            ),
            arguments(
                arrayOf(
                    intArrayOf(3, 0, 3, 0),
                    intArrayOf(0, 3, 0, 3),
                    intArrayOf(3, 0, 3, 0)
                ),
                3,
                6
            )
        )
    }

    @Nested
    inner class CountIslandsWithTotalValueDivisibleByKRevTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of islands whose total value is divisible by k`(
            grid: Array<IntArray>,
            k: Int,
            expected: Int
        ) {
            CountIslandsWithTotalValueDivisibleByKRev1().test(grid, k, expected)
        }
    }
}

private fun CountIslandsWithTotalValueDivisibleByK.test(grid: Array<IntArray>, k: Int, expected: Int) {
    val actual = countIslands(grid, k)
    assertThat(actual).isEqualTo(expected)
}
