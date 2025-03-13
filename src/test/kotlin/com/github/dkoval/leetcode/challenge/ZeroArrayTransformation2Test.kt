package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ZeroArrayTransformation2.ZeroArrayTransformation2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ZeroArrayTransformation2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 0, 2),
                arrayOf(
                    intArrayOf(0, 2, 1),
                    intArrayOf(0, 2, 1),
                    intArrayOf(1, 1, 3)
                ),
                2
            ),
            Arguments.of(
                intArrayOf(4, 3, 2, 1),
                arrayOf(
                    intArrayOf(1, 3, 2),
                    intArrayOf(0, 2, 1)
                ),
                -1
            )
        )
    }

    @Nested
    inner class ZeroArrayTransformation2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible value of k, such that after processing the first k queries in sequence, nums becomes a zero array`(
            nums: IntArray,
            queries: Array<IntArray>,
            expected: Int
        ) {
            ZeroArrayTransformation2Rev1().test(nums, queries, expected)
        }
    }
}

fun ZeroArrayTransformation2.test(arr: IntArray, operations: Array<IntArray>, expected: Int) {
    val actual = minZeroArray(arr, operations)
    assertEquals(expected, actual)
}
