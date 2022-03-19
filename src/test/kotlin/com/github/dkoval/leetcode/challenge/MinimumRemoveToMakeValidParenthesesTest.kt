package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumRemoveToMakeValidParentheses.MinimumRemoveToMakeValidParenthesesUsingCounter
import com.github.dkoval.leetcode.challenge.MinimumRemoveToMakeValidParentheses.MinimumRemoveToMakeValidParenthesesUsingStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumRemoveToMakeValidParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "lee(t(c)o)de)",
                "lee(t(c)o)de"
            ),
            Arguments.of(
                "a)b(c)d",
                "ab(c)d"
            ),
            Arguments.of(
                "))((",
                ""
            ),
            Arguments.of(
                "(a(b(c)d)",
                "a(b(c)d)"
            )
        )
    }

    @Nested
    inner class MinimumRemoveToMakeValidParenthesesUsingCounterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove the minimum number of parentheses so that the resulting parentheses string is valid`(
            s: String,
            expected: String
        ) {
            MinimumRemoveToMakeValidParenthesesUsingCounter().test(s, expected)
        }
    }

    @Nested
    inner class MinimumRemoveToMakeValidParenthesesUsingStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove the minimum number of parentheses so that the resulting parentheses string is valid`(
            s: String,
            expected: String
        ) {
            MinimumRemoveToMakeValidParenthesesUsingStack().test(s, expected)
        }
    }

    private fun MinimumRemoveToMakeValidParentheses.test(s: String, expected: String) {
        val actual = minRemoveToMakeValid(s)
        assertEquals(expected, actual)
    }
}