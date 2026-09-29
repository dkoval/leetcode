package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfThereIsValidParenthesesStringPath.CheckIfThereIsValidParenthesesStringPathRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfThereIsValidParenthesesStringPathTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    charArrayOf('(', '(', '('),
                    charArrayOf(')', '(', ')'),
                    charArrayOf('(', '(', ')'),
                    charArrayOf('(', '(', ')')
                ),
                true
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf(')', ')'),
                    charArrayOf('(', '('),
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    charArrayOf(')', '(')
                ),
                false
            )
        )
    }

    @Nested
    inner class CheckIfThereIsValidParenthesesStringPathRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if there is a valid parentheses string path in the grid, otherwise false`(
            grid: Array<CharArray>,
            expected: Boolean
        ) {
            CheckIfThereIsValidParenthesesStringPathRev1().test(grid, expected)
        }
    }
}

private fun CheckIfThereIsValidParenthesesStringPath.test(grid: Array<CharArray>, expected: Boolean) {
    val actual = hasValidPath(grid)
    assertEquals(expected, actual)
}
