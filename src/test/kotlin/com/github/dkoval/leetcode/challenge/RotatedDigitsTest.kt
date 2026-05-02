package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RotatedDigits.RotatedDigitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RotatedDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(10, 4),
            Arguments.of(1, 0),
            Arguments.of(2, 1)
        )
    }

    @Nested
    inner class RotatedDigitsIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of good integers`(n: Int, expected: Int) {
            RotatedDigitsRev1().test(n, expected)
        }
    }
}

private fun RotatedDigits.test(n: Int, expected: Int) {
    val actual = rotatedDigits(n)
    assertEquals(expected, actual)
}
