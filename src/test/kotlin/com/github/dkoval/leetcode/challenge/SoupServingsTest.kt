package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SoupServings.SoupServingsRev1
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.math.abs

internal class SoupServingsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(50, 0.62500),
            Arguments.of(100, 0.71875),
            Arguments.of(0, 0.50000),
            Arguments.of(1, 0.62500),
            Arguments.of(1000, 0.97657)
        )
    }

    @Nested
    inner class SoupServingsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time`(
            n: Int,
            expected: Double
        ) {
            SoupServingsRev1().test(n, expected)
        }
    }
}

private fun SoupServings.test(n: Int, expected: Double) {
    val actual = soupServings(n)
    assertTrue(abs(expected - actual) < 1e-5)
}
