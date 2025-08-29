package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AliceAndBobPlayingFlowerGame.AliceAndBobPlayingFlowerGameRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AliceAndBobPlayingFlowerGameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 2, 3L),
            Arguments.of(1, 1, 0L)
        )
    }

    @Nested
    inner class AliceAndBobPlayingFlowerGameRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible pairs (x, y) that satisfy the conditions mentioned in the statement`(
            n: Int,
            m: Int,
            expected: Long
        ) {
            AliceAndBobPlayingFlowerGameRev1().test(n, m, expected)
        }
    }
}

private fun AliceAndBobPlayingFlowerGame.test(n: Int, m: Int, expected: Long) {
    val actual = flowerGame(n, m)
    assertEquals(expected, actual)
}
