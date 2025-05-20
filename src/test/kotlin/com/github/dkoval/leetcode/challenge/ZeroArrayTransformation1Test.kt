package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ZeroArrayTransformation1.ZeroArrayTransformation1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ZeroArrayTransformation1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 0, 1),
                arrayOf(
                    intArrayOf(0, 2)
                ),
                true
            ),
            Arguments.of(
                intArrayOf(4, 3, 2, 1),
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, 2)
                ),
                false
            )
        )
    }

    @Nested
    inner class ZeroArrayTransformation1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if it is possible to transform nums into a Zero Array after processing all the queries sequentially`(
            nums: IntArray,
            queries: Array<IntArray>,
            expected: Boolean
        ) {
            ZeroArrayTransformation1Rev1().test(nums, queries, expected)
        }
    }
}

private fun ZeroArrayTransformation1.test(nums: IntArray, queries: Array<IntArray>, expected: Boolean) {
    val actual = isZeroArray(nums, queries)
    assertEquals(expected, actual)
}
