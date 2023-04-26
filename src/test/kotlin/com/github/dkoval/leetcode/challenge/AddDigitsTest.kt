package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.AddDigits.AddDigitsNaive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AddDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(38, 2), // 3 + 8 = 11, 1 + 1 = 2
            Arguments.of(283, 4) // 2 + 8 + 3 = 13, 1 + 3 = 4
        )
    }

    @Nested
    inner class AddDigitsNaiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute digital root`(num: Int, expected: Int) {
            AddDigitsNaive().test(num, expected)
        }
    }

    @Nested
    inner class AddDigitsConstantTimeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute digital root`(num: Int, expected: Int) {
            AddDigitsConstantTime.test(num, expected)
        }
    }
}

private fun AddDigits.test(num: Int, expected: Int) {
    val actual = addDigits(num)
    assertEquals(expected, actual)
}
