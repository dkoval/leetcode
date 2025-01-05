package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShiftingLetters2.ShiftingLetters2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShiftingLetters2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 2, 1),
                    intArrayOf(0, 2, 1)
                ),
                "ace"
            ),
            Arguments.of(
                "dztz",
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 1, 1)
                ),
                "catz"
            )
        )
    }

    @Nested
    inner class ShiftingLetters2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the final string after all such shifts to s are applied`(
            s: String,
            shifts: Array<IntArray>,
            expected: String
        ) {
            ShiftingLetters2Rev1().test(s, shifts, expected)
        }
    }
}

private fun ShiftingLetters2.test(s: String, shifts: Array<IntArray>, expected: String) {
    val actual = shiftingLetters(s, shifts)
    assertEquals(expected, actual)
}
