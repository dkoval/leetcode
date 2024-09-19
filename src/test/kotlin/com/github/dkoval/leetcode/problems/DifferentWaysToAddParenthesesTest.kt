package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.DifferentWaysToAddParentheses.DifferentWaysToAddParenthesesDivideAndConquer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DifferentWaysToAddParenthesesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "2-1-1",
                listOf(0, 2)
            ),
            Arguments.of(
                "2*3-4*5",
                listOf(-34, -14, -10, -10, 10)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `should return all possible results from computing all the different possible ways to group numbers and operators`(
        expression: String,
        expected: List<Int>
    ) {
        DifferentWaysToAddParenthesesDivideAndConquer().test(expression, expected)
    }
}

private fun DifferentWaysToAddParentheses.test(expression: String, expected: List<Int>) {
    val actual = diffWaysToCompute(expression)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
