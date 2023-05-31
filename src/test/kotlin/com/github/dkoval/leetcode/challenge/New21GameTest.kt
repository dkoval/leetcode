package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.New21Game.New21GameDPBottomUp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class New21GameTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 1, 10, 1.0),
            Arguments.of(6, 1, 10, 0.6),
            Arguments.of(21, 17, 10, 0.73278),
            Arguments.of(1, 0, 1, 1.0),
            Arguments.of(12, 1, 10, 1.0)
        )
    }

    @Nested
    inner class New21GameDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the probability that Alice has n or fewer points`(
            n: Int,
            k: Int,
            maxPts: Int,
            expected: Double
        ) {
            New21GameDPBottomUp().test(n, k, maxPts, expected)
        }
    }
}

private fun New21GameDPBottomUp.test(n: Int, k: Int, maxPts: Int, expected: Double) {
    val actual = new21Game(n, k, maxPts)
    assertEquals(expected, actual, 1E-5)
}
