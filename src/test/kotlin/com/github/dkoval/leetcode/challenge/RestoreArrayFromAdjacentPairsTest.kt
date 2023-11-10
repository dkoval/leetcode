package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RestoreArrayFromAdjacentPairs.RestoreArrayFromAdjacentPairsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RestoreArrayFromAdjacentPairsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 1),
                    intArrayOf(3, 4),
                    intArrayOf(3, 2)
                ),
                intArrayOf(1, 2, 3, 4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(4, -2),
                    intArrayOf(1, 4),
                    intArrayOf(-3, 1)
                ),
                intArrayOf(-2, 4, 1, -3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(100000, -100000)
                ),
                intArrayOf(100000, -100000)
            )
        )
    }

    @Nested
    inner class RestoreArrayFromAdjacentPairsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the original array nums, if there are multiple solutions, return any of them`(
            adjacentPairs: Array<IntArray>,
            expected: IntArray
        ) {
            RestoreArrayFromAdjacentPairsRev1().test(adjacentPairs, expected)
        }
    }
}

private fun RestoreArrayFromAdjacentPairs.test(adjacentPairs: Array<IntArray>, expected: IntArray) {
    val actual = restoreArray(adjacentPairs)
    assertArrayEquals(expected, actual)
}
