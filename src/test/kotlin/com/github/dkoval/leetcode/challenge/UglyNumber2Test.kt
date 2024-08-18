package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UglyNumber2.UglyNumber2UsingMinHeap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UglyNumber2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 4),
            Arguments.of(5, 5),
            Arguments.of(10, 12)
        )
    }

    @Nested
    inner class UglyNumber2UsingMinHeapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find nth ugly number`(n: Int, expected: Int) {
            UglyNumber2UsingMinHeap().test(n, expected)
        }
    }

    @Nested
    inner class UglyNumber2SmartTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find nth ugly number`(n: Int, expected: Int) {
            UglyNumber2Smart.test(n, expected)
        }
    }
}

private fun UglyNumber2.test(n: Int, expected: Int) {
    val actual = nthUglyNumber(n)
    assertEquals(expected, actual)
}
