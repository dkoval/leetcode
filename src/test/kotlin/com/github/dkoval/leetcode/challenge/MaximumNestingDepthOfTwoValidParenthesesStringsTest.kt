package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNestingDepthOfTwoValidParenthesesStrings.MaximumNestingDepthOfTwoValidParenthesesStringsRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNestingDepthOfTwoValidParenthesesStringsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "(()())",
                intArrayOf(0, 1, 1, 1, 1, 0)
            ),
            Arguments.of(
                "()(())()",
                intArrayOf(0, 0, 0, 1, 1, 0, 0, 0)
            )
        )
    }

    @Nested
    inner class MaximumNestingDepthOfTwoValidParenthesesStringsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array answer`(seq: String, expected: IntArray) {
            MaximumNestingDepthOfTwoValidParenthesesStringsRev1().test(seq, expected)
        }
    }
}

private fun MaximumNestingDepthOfTwoValidParenthesesStrings.test(seq: String, expected: IntArray) {
    val actual = maxDepthAfterSplit(seq)
    assertArrayEquals(expected, actual)
}
