package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNestingDepthParentheses.MaximumNestingDepthParenthesesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNestingDepthParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "(1+(2*3)+((8)/4))+1",
                3
            ),
            Arguments.of(
                "(1)+((2))+(((3)))",
                3
            ),
            Arguments.of(
                "",
                0
            ),
            Arguments.of(
                "c",
                0
            ),
            Arguments.of(
                "()",
                1
            )
        )
    }

    @Nested
    inner class MaximumNestingDepthParenthesesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the nesting depth of s`(s: String, expected: Int) {
            MaximumNestingDepthParenthesesRev1().test(s, expected)
        }
    }
}

private fun MaximumNestingDepthParentheses.test(s: String, expected: Int) {
    val actual = maxDepth(s)
    assertEquals(expected, actual)
}
