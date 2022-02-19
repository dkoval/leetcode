package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FactorialTrailingZeroes.FactorialTrailingZeroesUsingFactorization
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FactorialTrailingZeroesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 0),
            Arguments.of(3, 0),
            Arguments.of(5, 1),
            Arguments.of(99, 22),
            Arguments.of(1000, 249)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `should return the number of trailing zeroes in n!`(n: Int, expected: Int) {
        FactorialTrailingZeroesUsingFactorization().test(n, expected)
    }

    private fun FactorialTrailingZeroes.test(n: Int, expected: Int) {
        val actual = trailingZeroes(n)
        assertEquals(expected, actual)
    }
}