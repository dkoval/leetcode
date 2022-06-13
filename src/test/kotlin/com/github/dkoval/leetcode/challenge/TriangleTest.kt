package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Triangle.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TriangleTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    mutableListOf(2),
                    listOf(3, 4),
                    listOf(6, 5, 7),
                    listOf(4, 1, 8, 3)
                ),
                11
            ),
            Arguments.of(
                listOf(
                    mutableListOf(-10)
                ),
                -10
            ),
            Arguments.of(
                listOf(
                    mutableListOf(-1),
                    listOf(-2, -3)
                ),
                -4
            ),
            Arguments.of(
                listOf(
                    mutableListOf(-1),
                    listOf(2, 3),
                    listOf(1, -1, -3)
                ),
                -1
            ),
            Arguments.of(
                listOf(
                    mutableListOf(1),
                    listOf(-5, -2),
                    listOf(3, 6, 1),
                    listOf(-1, 2, 4, -3)
                ),
                -3
            )
        )
    }

    @Nested
    inner class TriangleTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum path sum from top to bottom in a triangle`(
            triangle: List<List<Int>>,
            expected: Int
        ) {
            TriangleTopDown().test(triangle, expected)
        }
    }

    @Nested
    inner class TriangleBottomUpRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum path sum from top to bottom in a triangle`(
            triangle: List<List<Int>>,
            expected: Int
        ) {
            TriangleBottomUpRev1().test(triangle, expected)
        }
    }

    @Nested
    inner class TriangleBottomUpRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum path sum from top to bottom in a triangle`(
            triangle: List<List<Int>>,
            expected: Int
        ) {
            TriangleBottomUpRev2().test(triangle, expected)
        }
    }

    private fun Triangle.test(triangle: List<List<Int>>, expected: Int) {
        val actual = minimumTotal(triangle)
        assertEquals(expected, actual)
    }
}