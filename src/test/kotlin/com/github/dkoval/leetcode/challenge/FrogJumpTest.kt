package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FrogJump.FrogJumpDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FrogJumpTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 3, 5, 6, 8, 12, 17),
                true
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 3, 4, 8, 9, 11),
                false
            ),
            Arguments.of(
                intArrayOf(0, 2),
                false
            )
        )
    }

    @Nested
    inner class FrogJumpDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if the frog can cross the river by landing on the last stone`(
            stones: IntArray,
            expected: Boolean
        ) {
            FrogJumpDPTopDown().test(stones, expected)
        }
    }
}

private fun FrogJump.test(stones: IntArray, expected: Boolean) {
    val actual = canCross(stones)
    assertEquals(expected, actual)
}
