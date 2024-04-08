package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ValidParenthesisString.ValidParenthesisStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidParenthesisStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("()", true),
            Arguments.of("(*)", true),
            Arguments.of("(*))", true)
        )
    }

    @Nested
    inner class ValidParenthesisStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if s is a valid parenthesis string`(s: String, expected: Boolean) {
            ValidParenthesisStringRev1().test(s, expected)
        }
    }
}

private fun ValidParenthesisString.test(s: String, expected: Boolean) {
    val actual = checkValidString(s)
    assertEquals(expected, actual)
}
