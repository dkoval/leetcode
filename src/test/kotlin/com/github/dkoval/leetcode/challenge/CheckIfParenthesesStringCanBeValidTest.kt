package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfParenthesesStringCanBeValid.CheckIfParenthesesStringCanBeValidRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfParenthesesStringCanBeValidTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "))()))",
                "010100",
                true
            ),
            Arguments.of(
                "()()",
                "0000",
                true
            ),
            Arguments.of(
                ")",
                "0",
                false
            ),
            Arguments.of(
                "((((((((((((",
                "111111111111",
                false
            )
        )
    }

    @Nested
    inner class CheckIfParenthesesStringCanBeValidRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if you can make s a valid parentheses string`(s: String, locked: String, expected: Boolean) {
            CheckIfParenthesesStringCanBeValidRev1().test(s, locked, expected)
        }
    }
}

private fun CheckIfParenthesesStringCanBeValid.test(s: String, locked: String, expected: Boolean) {
    val actual = canBeValid(s, locked)
    assertEquals(expected, actual)
}
