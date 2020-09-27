package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class EvaluateDivisionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf("a", "b"),
                    listOf("b", "c")
                ),
                doubleArrayOf(2.0, 3.0),
                listOf(
                    listOf("a", "c"),
                    listOf("b", "a"),
                    listOf("a", "e"),
                    listOf("a", "a"),
                    listOf("x", "x")
                ),
                doubleArrayOf(6.00000, 0.50000, -1.00000, 1.00000, -1.00000)
            ),
            Arguments.of(
                listOf(
                    listOf("a", "b"),
                    listOf("b", "c"),
                    listOf("bc", "cd")
                ),
                doubleArrayOf(1.5, 2.5, 5.0),
                listOf(
                    listOf("a", "c"),
                    listOf("c", "b"),
                    listOf("bc", "cd"),
                    listOf("cd", "bc")
                ),
                doubleArrayOf(3.75000, 0.40000, 5.00000, 0.20000)
            ),
            Arguments.of(
                listOf(
                    listOf("a", "b")
                ),
                doubleArrayOf(0.5),
                listOf(
                    listOf("a", "b"),
                    listOf("b", "a"),
                    listOf("a", "c"),
                    listOf("x", "y")
                ),
                doubleArrayOf(0.50000, 2.00000, -1.00000, -1.00000)
            )
        )
    }

    @Nested
    inner class EvaluateDivisionTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should evaluate equation`(
            equations: List<List<String>>,
            values: DoubleArray,
            queries: List<List<String>>,
            expected: DoubleArray
        ) {
            EvaluateDivision.test(equations, values, queries, expected)
        }
    }

    @Nested
    inner class EvaluateDivisionJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should evaluate equation`(
            equations: List<List<String>>,
            values: DoubleArray,
            queries: List<List<String>>,
            expected: DoubleArray
        ) {
            EvaluateDivisionJava().test(equations, values, queries, expected)
        }
    }

    private fun EvaluateDivision.test(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>,
        expected: DoubleArray
    ) {
        val actual = calcEquation(equations, values, queries)
        assertArrayEquals(expected, actual, 1E-6)
    }

    private fun EvaluateDivisionJava.test(
        equations: List<List<String>>,
        values: DoubleArray,
        queries: List<List<String>>,
        expected: DoubleArray
    ) {
        val actual = calcEquation(equations, values, queries)
        assertArrayEquals(expected, actual, 1E-6)
    }
}