package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.GenerateParentheses.GenerateParenthesesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GenerateParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                listOf("()")
            ),
            Arguments.of(
                2,
                listOf("(())", "()()")
            ),
            Arguments.of(
                3,
                listOf("((()))", "(()())", "(())()", "()(())", "()()()")
            )
        )
    }

    @Nested
    inner class GenerateParenthesesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should generate all combinations of well-formed parentheses`(n: Int, expected: List<String>) {
            GenerateParenthesesRev1().test(n, expected)
        }
    }
}

private fun GenerateParentheses.test(n: Int, expected: List<String>) {
    val actual = generateParenthesis(n)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
