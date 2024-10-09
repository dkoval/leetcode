package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumAddToMakeParenthesesValid.MinimumAddToMakeParenthesesValidRev1
import com.github.dkoval.leetcode.challenge.MinimumAddToMakeParenthesesValid.MinimumAddToMakeParenthesesValidRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumAddToMakeParenthesesValidTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("())", 1),
            Arguments.of("(((", 3),
            Arguments.of("()))((", 4)
        )
    }

    @Nested
    inner class MinimumAddToMakeParenthesesValidRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of moves required to make s valid`(s: String, expected: Int) {
            MinimumAddToMakeParenthesesValidRev1().test(s, expected)
        }
    }

    @Nested
    inner class MinimumAddToMakeParenthesesValidRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of moves required to make s valid`(s: String, expected: Int) {
            MinimumAddToMakeParenthesesValidRev2().test(s, expected)
        }
    }
}

private fun MinimumAddToMakeParenthesesValid.test(s: String, expected: Int) {
    val actual = minAddToMakeValid(s)
    assertEquals(expected, actual)
}
