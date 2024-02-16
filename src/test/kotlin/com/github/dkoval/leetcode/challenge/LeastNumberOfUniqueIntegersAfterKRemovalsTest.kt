package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LeastNumberOfUniqueIntegersAfterKRemovals.LeastNumberOfUniqueIntegersAfterKRemovalsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LeastNumberOfUniqueIntegersAfterKRemovalsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 5, 4),
                1,
                1
            ),
            Arguments.of(
                intArrayOf(4, 3, 1, 1, 3, 3, 2),
                3,
                2
            )
        )
    }

    @Nested
    inner class LeastNumberOfUniqueIntegersAfterKRemovalsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the least number of unique integers after removing exactly k elements`(
            arr: IntArray,
            k: Int,
            expected: Int
        ) {
            LeastNumberOfUniqueIntegersAfterKRemovalsRev1().test(arr, k, expected)
        }
    }
}

private fun LeastNumberOfUniqueIntegersAfterKRemovals.test(arr: IntArray, k: Int, expected: Int) {
    val actual = findLeastNumOfUniqueInts(arr, k)
    assertEquals(expected, actual)
}
