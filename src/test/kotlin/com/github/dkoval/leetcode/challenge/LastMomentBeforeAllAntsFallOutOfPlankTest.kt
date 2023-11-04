package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LastMomentBeforeAllAntsFallOutOfPlank.LastMomentBeforeAllAntsFallOutOfPlankRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LastMomentBeforeAllAntsFallOutOfPlankTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4,
                intArrayOf(4, 3),
                intArrayOf(0, 1),
                4
            ),
            Arguments.of(
                7,
                intArrayOf(),
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7),
                7
            ),
            Arguments.of(
                7,
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7),
                intArrayOf(),
                7
            )
        )
    }

    @Nested
    inner class LastMomentBeforeAllAntsFallOutOfPlankRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the moment when the last ant(s) fall out of the plank`(
            n: Int,
            left: IntArray,
            right: IntArray,
            expected: Int
        ) {
            LastMomentBeforeAllAntsFallOutOfPlankRev1().test(n, left, right, expected)
        }
    }
}

private fun LastMomentBeforeAllAntsFallOutOfPlank.test(n: Int, left: IntArray, right: IntArray, expected: Int) {
    val actual = getLastMoment(n, left, right)
    assertEquals(expected, actual)
}
