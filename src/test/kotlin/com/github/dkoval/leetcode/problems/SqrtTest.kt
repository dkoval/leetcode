package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.Sqrt.SqrtUsingBinarySearchRev1
import com.github.dkoval.leetcode.problems.Sqrt.SqrtUsingBinarySearchRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SqrtTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(4, 2),
            Arguments.of(8, 2),
            Arguments.of(42, 6)
        )
    }

    @Nested
    inner class SqrtUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the square root of x`(x: Int, expected: Int) {
            SqrtUsingBinarySearchRev1().test(x, expected)
        }
    }


    @Nested
    inner class SqrtUsingBinarySearchRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the square root of x`(x: Int, expected: Int) {
            SqrtUsingBinarySearchRev2().test(x, expected)
        }
    }

    private fun Sqrt.test(x: Int, expected: Int) {
        val actual = mySqrt(x)
        assertEquals(expected, actual)
    }
}