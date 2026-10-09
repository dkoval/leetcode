package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumInsertionsToBalanceParenthesesString.MinimumInsertionsToBalanceParenthesesStringRev1
import com.github.dkoval.leetcode.challenge.MinimumInsertionsToBalanceParenthesesString.MinimumInsertionsToBalanceParenthesesStringRev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumInsertionsToBalanceParenthesesStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
            Stream.of(
                arguments("(()))", 1),
                Arguments.of("())", 0),
                Arguments.of("))())(", 3)
            )
    }

    @Nested
    inner class MinimumInsertionsToBalanceParenthesesStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of insertions needed to make s balanced`(s: String, expected: Int) {
            MinimumInsertionsToBalanceParenthesesStringRev1().test(s, expected)
        }
    }

    @Nested
    inner class MinimumInsertionsToBalanceParenthesesStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of insertions needed to make s balanced`(s: String, expected: Int) {
            MinimumInsertionsToBalanceParenthesesStringRev2().test(s, expected)
        }
    }
}

private fun MinimumInsertionsToBalanceParenthesesString.test(s: String, expected: Int) {
    val actual = minInsertions(s)
    assertThat(actual).isEqualTo(expected)
}
