package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IntegerToRoman.IntegerToRomanRev1
import com.github.dkoval.leetcode.challenge.IntegerToRoman.IntegerToRomanRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IntegerToRomanTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(3, "III"),
            Arguments.of(4, "IV"),
            Arguments.of(9, "IX"),
            Arguments.of(58, "LVIII"),
            Arguments.of(1994, "MCMXCIV")
        )
    }

    @Nested
    inner class IntegerToRomanRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert an integer to to a roman numeral`(num: Int, expected: String) {
            IntegerToRomanRev1().test(num, expected)
        }
    }

    @Nested
    inner class IntegerToRomanRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should convert an integer to to a roman numeral`(num: Int, expected: String) {
            IntegerToRomanRev2().test(num, expected)
        }
    }

    private fun IntegerToRoman.test(num: Int, expected: String) {
        val actual = intToRoman(num)
        assertEquals(expected, actual)
    }
}