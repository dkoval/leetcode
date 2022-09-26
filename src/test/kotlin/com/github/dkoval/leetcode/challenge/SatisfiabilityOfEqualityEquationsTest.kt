package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SatisfiabilityOfEqualityEquations.SatisfiabilityOfEqualityEquationsUsingUnionFind
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SatisfiabilityOfEqualityEquationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("a==b", "b!=a"),
                false
            ),
            Arguments.of(
                arrayOf("b==a", "a==b"),
                true
            )
        )
    }

    @Nested
    inner class SatisfiabilityOfEqualityEquationsUsingUnionFindTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if it is possible to assign integers to variable names so as to satisfy all the given equations`(
            equations: Array<String>,
            expected: Boolean
        ) {
            SatisfiabilityOfEqualityEquationsUsingUnionFind().test(equations, expected)
        }
    }

    private fun SatisfiabilityOfEqualityEquations.test(equations: Array<String>, expected: Boolean) {
        val actual = equationsPossible(equations)
        assertEquals(expected, actual)
    }
}