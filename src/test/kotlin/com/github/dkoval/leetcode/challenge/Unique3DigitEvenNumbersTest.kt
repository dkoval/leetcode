package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.Unique3DigitEvenNumbers.Unique3DigitEvenNumbersRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class Unique3DigitEvenNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                12
            ),
            Arguments.of(
                intArrayOf(0, 2, 2),
                2
            ),
            Arguments.of(
                intArrayOf(6, 6, 6),
                1
            ),
            Arguments.of(
                intArrayOf(1, 3, 5),
                0
            )
        )
    }

    @Nested
    inner class Unique3DigitEvenNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of unique 3-digit even numbers that can be formed using the given digits`(
            digits: IntArray,
            expected: Int
        ) {
            Unique3DigitEvenNumbersRev1().test(digits, expected)
        }
    }
}

private fun Unique3DigitEvenNumbersRev1.test(digits: IntArray, expected: Int) {
    val actual = totalNumbers(digits)
    assertEquals(expected, actual)
}
