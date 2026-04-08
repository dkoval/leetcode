package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.XORAfterRangeMultiplicationQueries1.XORAfterRangeMultiplicationQueries1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class XORAfterRangeMultiplicationQueries1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 1),
                arrayOf(
                    intArrayOf(0, 2, 1, 4)
                ),
                4
            ),
            Arguments.of(
                intArrayOf(2, 3, 1, 5, 4),
                arrayOf(
                    intArrayOf(1, 4, 2, 3),
                    intArrayOf(0, 2, 1, 2)
                ),
                4
            )
        )
    }

    @Nested
    inner class XORAfterRangeMultiplicationQueries1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final XOR value after all operations have been performed`(
            nums: IntArray,
            queries: Array<IntArray>,
            expected: Int
        ) {
            XORAfterRangeMultiplicationQueries1Rev1().test(nums, queries, expected)
        }
    }
}

private fun XORAfterRangeMultiplicationQueries1Rev1.test(nums: IntArray, queries: Array<IntArray>, expected: Int) {
    val actual = xorAfterQueries(nums, queries)
    assertEquals(expected, actual)
}
