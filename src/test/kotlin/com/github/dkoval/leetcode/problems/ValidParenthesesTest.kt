package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ValidParentheses.ValidParenthesesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([)]", false),
                Arguments.of("{[]}", true)
            )
    }

    @Nested
    inner class ValidParenthesesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine if the input string is valid`(s: String, expected: Boolean) {
            ValidParenthesesRev1().test(s, expected)
        }
    }
}

private fun ValidParentheses.test(s: String, expected: Boolean) {
    val actual = isValid(s)
    assertEquals(expected, actual)
}
