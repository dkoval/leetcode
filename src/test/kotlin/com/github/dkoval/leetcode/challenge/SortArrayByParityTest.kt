package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SortArrayByParityTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1),
                intArrayOf(1)
            ),
            Arguments.of(
                intArrayOf(2),
                intArrayOf(2)
            ),
            Arguments.of(
                intArrayOf(3, 1, 2, 4),
                intArrayOf(2, 4, 3, 1)
            )
        )
    }

    @Nested
    inner class SortArrayByParityNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array consisting of all the even elements of A, followed by all the odd elements of A`(
            A: IntArray,
            expected: IntArray
        ) {
            SortArrayByParityNaive.test(A, expected)
        }
    }

    @Nested
    inner class SortArrayByParityOptimalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array consisting of all the even elements of A, followed by all the odd elements of A`(
            A: IntArray,
            expected: IntArray
        ) {
            SortArrayByParityOptimal.test(A, expected)
        }
    }

    private fun SortArrayByParity.test(A: IntArray, expected: IntArray) {
        val actual = sortArrayByParity(A)
        assertArrayEquals(expected, actual)
    }
}