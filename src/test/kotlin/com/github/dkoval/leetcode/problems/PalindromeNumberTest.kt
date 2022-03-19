package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.PalindromeNumber.PalindromeNumberConvertToString
import com.github.dkoval.leetcode.problems.PalindromeNumber.PalindromeNumberReverseHalfOfNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PalindromeNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(121, true),
            Arguments.of(-121, false),
            Arguments.of(10, false),
            Arguments.of(-101, false),
            Arguments.of(0, true),
        )
    }

    @Nested
    inner class PalindromeNumberConvertToStringTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine whether an integer is a palindrome`(x: Int, expected: Boolean) {
            PalindromeNumberConvertToString().test(x, expected)
        }
    }

    @Nested
    inner class PalindromeNumberReverseHalfOfNumberTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should determine whether an integer is a palindrome`(x: Int, expected: Boolean) {
            PalindromeNumberReverseHalfOfNumber().test(x, expected)
        }
    }

    private fun PalindromeNumber.test(x: Int, expected: Boolean) {
        val actual = isPalindrome(x)
        assertEquals(expected, actual)
    }
}