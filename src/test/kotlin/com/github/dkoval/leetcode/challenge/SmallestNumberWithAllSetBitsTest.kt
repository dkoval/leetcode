package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestNumberWithAllSetBits.SmallestNumberWithAllSetBitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SmallestNumberWithAllSetBitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(5, 7),
            Arguments.of(10, 15),
            Arguments.of(3, 3),
            Arguments.of(1, 1),
            Arguments.of(4, 7),
        )
    }

    @Nested
    inner class SmallestNumberWithAllSetBitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits`(
            n: Int,
            expected: Int
        ) {
            SmallestNumberWithAllSetBitsRev1().test(n, expected)
        }
    }

    @Nested
    inner class SmallestNumberWithAllSetBitsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits`(
            n: Int,
            expected: Int
        ) {
            SmallestNumberWithAllSetBits.SmallestNumberWithAllSetBitsRev2().test(n, expected)
        }
    }
}

private fun SmallestNumberWithAllSetBits.test(n: Int, expected: Int) {
    val actual = smallestNumber(n)
    assertEquals(expected, actual)
}
