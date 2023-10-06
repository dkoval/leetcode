package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.IntegerBreak.IntegerBreakRev1
import com.github.dkoval.leetcode.problems.IntegerBreak.IntegerBreakRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IntegerBreakTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(4, 4),
            Arguments.of(5, 6),
            Arguments.of(6, 9),
            Arguments.of(7, 12),
            Arguments.of(8, 18),
            Arguments.of(9, 27),
            Arguments.of(10, 36),
            Arguments.of(11, 54),
            Arguments.of(12, 81)
        )
    }

    @Nested
    inner class IntegerBreakRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum product you can get`(n: Int, expected: Int) {
            IntegerBreakRev1().test(n, expected)
        }
    }

    @Nested
    inner class IntegerBreakRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum product you can get`(n: Int, expected: Int) {
            IntegerBreakRev2().test(n, expected)
        }
    }
}

private fun IntegerBreak.test(n: Int, expected: Int) {
    val actual = integerBreak(n)
    assertEquals(expected, actual)
}
