package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ParsingBooleanExpression.ParsingBooleanExpressionRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ParsingBooleanExpressionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "&(|(f))",
                false
            ),
            Arguments.of(
                "|(f,f,f,t)",
                true
            ),
            Arguments.of(
                "!(&(f,t))",
                true
            )
        )
    }

    @Nested
    inner class ParsingBooleanExpressionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the evaluation of the expression`(expression: String, expected: Boolean) {
            ParsingBooleanExpressionRev1().test(expression, expected)
        }
    }
}

private fun ParsingBooleanExpression.test(expression: String, expected: Boolean) {
    val actual = parseBoolExpr(expression)
    assertEquals(expected, actual)
}
