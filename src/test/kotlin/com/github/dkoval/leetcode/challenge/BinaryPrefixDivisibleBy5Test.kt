package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BinaryPrefixDivisibleBy5.BinaryPrefixDivisibleBy5Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryPrefixDivisibleBy5Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 1),
                listOf(true, false, false)
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                listOf(false, false, false)
            ),
            Arguments.of(
                intArrayOf(
                    1,
                    0,
                    0,
                    1,
                    0,
                    1,
                    0,
                    0,
                    1,
                    0,
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    1,
                    0,
                    0,
                    0,
                    0,
                    1,
                    0,
                    1,
                    0,
                    0,
                    0,
                    0,
                    1,
                    1,
                    0,
                    1,
                    0,
                    0,
                    0,
                    1
                ),
                listOf(
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    true,
                    false,
                    false,
                    true,
                    true,
                    true,
                    true,
                    false
                ),
            )
        )
    }

    @Nested
    inner class BinaryPrefixDivisibleBy5Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list of booleans where the i-th boolean indicates whether the i-th prefix of the binary array is divisible by 5`(
            bits: IntArray,
            expected: List<Boolean>
        ) {
            BinaryPrefixDivisibleBy5Rev1().test(bits, expected)
        }
    }
}

private fun BinaryPrefixDivisibleBy5.test(bits: IntArray, expected: List<Boolean>) {
    val actual = prefixesDivBy5(bits)
    assertEquals(expected, actual)
}
