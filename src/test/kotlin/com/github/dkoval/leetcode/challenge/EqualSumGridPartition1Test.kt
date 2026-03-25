package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.EqualSumGridPartition1.EqualSumGridPartition1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class EqualSumGridPartition1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3)
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 4)
                ),
                false
            )
        )
    }

    @Nested
    inner class EqualSumGridPartition1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if the grid can be partitioned`(grid: Array<IntArray>, expected: Boolean) {
            EqualSumGridPartition1Rev1().test(grid, expected)
        }
    }
}

private fun EqualSumGridPartition1.test(grid: Array<IntArray>, expected: Boolean) {
    val actual = canPartitionGrid(grid)
    assertEquals(expected, actual)
}
