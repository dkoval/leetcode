package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StoneGame.StoneGameRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class StoneGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 3, 4, 5),
                true
            ),
            Arguments.of(
                intArrayOf(3, 7, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(
                    7,
                    7,
                    12,
                    16,
                    41,
                    48,
                    41,
                    48,
                    11,
                    9,
                    34,
                    2,
                    44,
                    30,
                    27,
                    12,
                    11,
                    39,
                    31,
                    8,
                    23,
                    11,
                    47,
                    25,
                    15,
                    23,
                    4,
                    17,
                    11,
                    50,
                    16,
                    50,
                    38,
                    34,
                    48,
                    27,
                    16,
                    24,
                    22,
                    48,
                    50,
                    10,
                    26,
                    27,
                    9,
                    43,
                    13,
                    42,
                    46,
                    24
                ),
                true
            )
        )
    }

    @Nested
    inner class StoneGameRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should True if and only if the 1st player wins the game`(piles: IntArray, expected: Boolean) {
            StoneGameRev1().test(piles, expected)
        }
    }
}

private fun StoneGame.test(piles: IntArray, expected: Boolean) {
    val actual = stoneGame(piles)
    assertEquals(expected, actual)
}
