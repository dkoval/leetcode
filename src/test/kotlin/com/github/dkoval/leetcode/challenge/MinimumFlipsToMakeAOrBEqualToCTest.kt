package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumFlipsToMakeAOrBEqualToC.MinimumFlipsToMakeAOrBEqualToCRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumFlipsToMakeAOrBEqualToCTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 6, 5, 3),
            Arguments.of(4, 2, 7, 1),
            Arguments.of(1, 2, 3, 0),
            Arguments.of(8, 5, 3, 3)
        )
    }

    @Nested
    inner class MinimumFlipsToMakeAOrBEqualToCRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum flips required`(a: Int, b: Int, c: Int, expected: Int) {
            MinimumFlipsToMakeAOrBEqualToCRev1().test(a, b, c, expected)
        }
    }
}

private fun MinimumFlipsToMakeAOrBEqualToC.test(a: Int, b: Int, c: Int, expected: Int) {
    val actual = minFlips(a, b, c)
    assertEquals(expected, actual)
}
