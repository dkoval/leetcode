package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfSubstringsWithOnly1s.NumberOfSubstringsWithOnly1sRev1
import com.github.dkoval.leetcode.challenge.NumberOfSubstringsWithOnly1s.NumberOfSubstringsWithOnly1sRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfSubstringsWithOnly1sTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("0110111", 9),
            Arguments.of("101", 2),
            Arguments.of("111111", 21)
        )
    }

    @Nested
    inner class NumberOfSubstringsWithOnly1sRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings with only 1s`(
            s: String,
            expected: Int
        ) {
            NumberOfSubstringsWithOnly1sRev1().test(s, expected)
        }
    }

    @Nested
    inner class NumberOfSubstringsWithOnly1sRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of substrings with only 1s`(
            s: String,
            expected: Int
        ) {
            NumberOfSubstringsWithOnly1sRev2().test(s, expected)
        }
    }
}

private fun NumberOfSubstringsWithOnly1s.test(s: String, expected: Int) {
    val actual = numSub(s)
    assertEquals(expected, actual)
}
