package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ComplementOfBase10IntegerJava.ComplementOfBase10IntegerFlipBitByBitJava
import com.github.dkoval.leetcode.challenge.ComplementOfBase10IntegerJava.ComplementOfBase10IntegerHighestOneBitJava
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ComplementOfBase10IntegerJavaTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(5, 2),
            Arguments.of(7, 0),
            Arguments.of(10, 5)
        )
    }

    @Nested
    inner class ComplementOfBase10IntegerFlipBitByBitJavaTest {


        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return complement of base 1o integer`(N: Int, expected: Int) {
            ComplementOfBase10IntegerFlipBitByBitJava().test(N, expected)
        }
    }

    @Nested
    inner class ComplementOfBase10IntegerHighestOneBitJavaTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return complement of base 1o integer`(N: Int, expected: Int) {
            ComplementOfBase10IntegerHighestOneBitJava().test(N, expected)
        }
    }

    private fun ComplementOfBase10IntegerJava.test(N: Int, expected: Int) {
        val actual = bitwiseComplement(N)
        assertEquals(expected, actual)
    }
}