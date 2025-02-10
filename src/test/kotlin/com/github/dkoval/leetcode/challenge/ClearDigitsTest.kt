package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ClearDigits.ClearDigitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ClearDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                "abc"
            ),
            Arguments.of(
                "cb34",
                ""
            )
        )
    }

    @Nested
    inner class ClearDigitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the resulting string after removing all digits`(s: String, expected: String) {
            ClearDigitsRev1().test(s, expected)
        }
    }
}

private fun ClearDigits.test(s: String, expected: String) {
    val actual = clearDigits(s)
    assertEquals(expected, actual)
}
