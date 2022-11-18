package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UglyNumber.UglyNumberRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UglyNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(0, false),
            Arguments.of(6, true),
            Arguments.of(1, true),
            Arguments.of(14, false),
            Arguments.of(8, true),
            Arguments.of(-8, false),
            Arguments.of(42, false)
        )
    }

    @Nested
    inner class UglyNumberRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if n is an ugly number`(n: Int, expected: Boolean) {
            UglyNumberRev1().test(n, expected)
        }
    }

    private fun UglyNumber.test(n: Int, expected: Boolean) {
        val actual = isUgly(n)
        assertEquals(expected, actual)
    }
}