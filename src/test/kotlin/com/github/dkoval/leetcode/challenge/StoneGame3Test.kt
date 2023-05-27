package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StoneGame3.StoneGame3DPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StoneGame3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 7),
                "Bob"
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, -9),
                "Alice"
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 6),
                "Tie"
            )
        )
    }

    @Nested
    inner class StoneGame3DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine the winner`(values: IntArray, expected: String) {
            StoneGame3DPTopDown().test(values, expected)
        }
    }
}

private fun StoneGame3.test(values: IntArray, expected: String) {
    val actual = stoneGameIII(values)
    assertEquals(expected, actual)
}
