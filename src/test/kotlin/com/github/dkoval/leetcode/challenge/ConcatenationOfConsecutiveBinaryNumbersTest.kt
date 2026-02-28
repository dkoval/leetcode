package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ConcatenationOfConsecutiveBinaryNumbers.ConcatenationOfConsecutiveBinaryNumbersRev1
import com.github.dkoval.leetcode.challenge.ConcatenationOfConsecutiveBinaryNumbers.ConcatenationOfConsecutiveBinaryNumbersRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConcatenationOfConsecutiveBinaryNumbersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(1, 1),
            Arguments.of(3, 27),
            Arguments.of(12, 505379714),
            Arguments.of(52, 244468468)
        )
    }

    @Nested
    inner class ConcatenationOfConsecutiveBinaryNumbersRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order`(
            n: Int,
            expected: Int
        ) {
            ConcatenationOfConsecutiveBinaryNumbersRev1().test(n, expected)
        }
    }

    @Nested
    inner class ConcatenationOfConsecutiveBinaryNumbersRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order`(
            n: Int,
            expected: Int
        ) {
            ConcatenationOfConsecutiveBinaryNumbersRev2().test(n, expected)
        }
    }
}

private fun ConcatenationOfConsecutiveBinaryNumbers.test(n: Int, expected: Int) {
    val actual = concatenatedBinary(n)
    assertEquals(expected, actual)
}
