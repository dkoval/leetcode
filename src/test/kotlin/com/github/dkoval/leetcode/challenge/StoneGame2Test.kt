package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StoneGame2.StoneGame2DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StoneGame2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 7, 9, 4, 4),
                10
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 100),
                104
            )
        )
    }

    @Nested
    inner class StoneGame2DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of stones Alice can get`(piles: IntArray, expected: Int) {
            StoneGame2DPTopDown().test(piles, expected)
        }
    }
}

private fun StoneGame2.test(piles: IntArray, expected: Int) {
    val actual = stoneGameII(piles)
    assertEquals(expected, actual)
}
