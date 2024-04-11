package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemoveKDigits.RemoveKDigitsRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveKDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("1432219", 3, "1219"),
            Arguments.of("10200", 1, "200"),
            Arguments.of("10", 2, "0"),
            Arguments.of("9", 1, "0"),
            Arguments.of("112", 1, "11"),
            Arguments.of("12345", 1, "1234"),
            Arguments.of("12145", 1, "1145"),
            Arguments.of("10354", 2, "34"),
            Arguments.of("123456", 3, "123")
        )
    }

    @Nested
    inner class RemoveKDigitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove k digits from the number so that the new number is the smallest possible`(
            num: String,
            k: Int,
            expected: String
        ) {
            RemoveKDigitsRev1.test(num, k, expected)
        }
    }

    @Nested
    inner class RemoveKDigitsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove k digits from the number so that the new number is the smallest possible`(
            num: String,
            k: Int,
            expected: String
        ) {
            RemoveKDigitsRev2().test(num, k, expected)
        }
    }
}

private fun RemoveKDigits.test(num: String, k: Int, expected: String) {
    val actual = removeKdigits(num, k)
    assertEquals(expected, actual)
}
