package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LongestBalancedSubstring1.LongestBalancedSubstring1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class LongestBalancedSubstring1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                "abbac",
                4
            ),
            arguments(
                "zzabccy",
                4
            ),
            arguments(
                "aba",
                2
            )
        )
    }

    @Nested
    inner class LongestBalancedSubstring1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the longest balanced substring`(
            s: String,
            expected: Int
        ) {
            LongestBalancedSubstring1Rev1().test(s, expected)
        }
    }
}

private fun LongestBalancedSubstring1.test(s: String, expected: Int) {
    val actual = longestBalanced(s)
    assertEquals(expected, actual)
}
