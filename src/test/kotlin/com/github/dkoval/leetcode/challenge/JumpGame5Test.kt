package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.JumpGame5.JumpGame5Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class JumpGame5Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12),
                2,
                4
            ),
            Arguments.of(
                intArrayOf(3, 3, 3, 3, 3),
                3,
                1
            ),
            Arguments.of(
                intArrayOf(7, 6, 5, 4, 3, 2, 1),
                3,
                7
            )
        )
    }

    @Nested
    inner class JumpGame5Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of indices you can visit`(
            arr: IntArray,
            d: Int,
            expected: Int
        ) {
            JumpGame5Rev1().test(arr, d, expected)
        }
    }
}

private fun JumpGame5.test(arr: IntArray, d: Int, expected: Int) {
    val actual = maxJumps(arr, d)
    assertEquals(expected, actual)
}
