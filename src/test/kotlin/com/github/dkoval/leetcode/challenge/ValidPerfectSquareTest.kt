package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.problems.ValidPerfectSquare
import com.github.dkoval.leetcode.problems.ValidPerfectSquare.ValidPerfectSquareBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ValidPerfectSquareTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(16, true),
            Arguments.of(14, false),
            Arguments.of(4539, false),
            Arguments.of(5776, true),
            Arguments.of(808201, true),
            Arguments.of(2147483647, false),
            Arguments.of(2147395600, true)
        )
    }

    @Nested
    inner class ValidPerfectSquareBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a number is a perfect square`(num: Int, expected: Boolean) {
            ValidPerfectSquareBinarySearch().test(num, expected)
        }
    }

    @Nested
    inner class ValidPerfectSquareNewtonTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if a number is a perfect square`(num: Int, expected: Boolean) {
            ValidPerfectSquareNewton.test(num, expected)
        }
    }

    private fun ValidPerfectSquare.test(num: Int, expected: Boolean) {
        val actual = isPerfectSquare(num)
        assertEquals(expected, actual)
    }
}