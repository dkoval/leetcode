package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindChampion2.FindChampion2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindChampion2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2)
                ),
                0
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 2)
                ),
                -1
            ),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(1, 0)
                ),
                1
            )
        )
    }

    @Nested
    inner class FindChampion2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return -1`(
            n: Int,
            edges: Array<IntArray>,
            expected: Int
        ) {
            FindChampion2Rev1().test(n, edges, expected)
        }
    }
}

private fun FindChampion2Rev1.test(n: Int, edges: Array<IntArray>, expected: Int) {
    val actual = findChampion(n, edges)
    assertEquals(expected, actual)
}
