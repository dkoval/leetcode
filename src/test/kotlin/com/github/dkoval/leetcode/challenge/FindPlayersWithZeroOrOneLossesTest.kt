package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindPlayersWithZeroOrOneLosses.FindPlayersWithZeroOrOneLossesRev1
import com.github.dkoval.leetcode.challenge.FindPlayersWithZeroOrOneLosses.FindPlayersWithZeroOrOneLossesRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindPlayersWithZeroOrOneLossesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(3, 6),
                    intArrayOf(5, 6),
                    intArrayOf(5, 7),
                    intArrayOf(4, 5),
                    intArrayOf(4, 8),
                    intArrayOf(4, 9),
                    intArrayOf(10, 4),
                    intArrayOf(10, 9)
                ),
                listOf(
                    listOf(1, 2, 10),
                    listOf(4, 5, 7, 8)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(2, 3),
                    intArrayOf(1, 3),
                    intArrayOf(5, 4),
                    intArrayOf(6, 4)
                ),
                listOf(
                    listOf(1, 2, 5, 6),
                    listOf()
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 100000)
                ),
                listOf(
                    listOf(1),
                    listOf(100000)
                )
            )
        )
    }

    @Nested
    inner class FindPlayersWithZeroOrOneLossesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find players with zero or one losses`(matches: Array<IntArray>, expected: List<List<Int>>) {
            FindPlayersWithZeroOrOneLossesRev1().test(matches, expected)
        }
    }

    @Nested
    inner class FindPlayersWithZeroOrOneLossesRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find players with zero or one losses`(matches: Array<IntArray>, expected: List<List<Int>>) {
            FindPlayersWithZeroOrOneLossesRev2().test(matches, expected)
        }
    }
}
private fun FindPlayersWithZeroOrOneLosses.test(matches: Array<IntArray>, expected: List<List<Int>>) {
    val actual = findWinners(matches)
    assertEquals(expected, actual)
}
