package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveOutermostParentheses.RemoveOutermostParenthesesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RemoveOutermostParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> =
            Stream.of(
                arguments("(()())(())", "()()()"),
                arguments("(()())(())(()(()))", "()()()()(())"),
                arguments("()()", "")
            )
    }

    @Nested
    inner class RemoveOutermostParenthesesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s`(
            s: String,
            expected: String
        ) {
            RemoveOutermostParenthesesRev1().test(s, expected)
        }
    }
}

private fun RemoveOutermostParentheses.test(s: String, expected: String) {
    val actual = removeOuterParentheses(s)
    assertThat(actual).isEqualTo(expected)
}
