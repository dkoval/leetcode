package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ReverseBits.ReverseBitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class ReverseBitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                0b00000010100101000001111010011100,
                0b00111001011110000010100101000000
            ),
            arguments(
                0b01111111111111111111111111111100,
                0b00111111111111111111111111111110
            )
        )
    }

    @Nested
    inner class ReverseBitsBitByBitTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse bits`(n: Int, expected: Int) {
            ReverseBitsBitByBit.test(n, expected)
        }
    }

    @Nested
    inner class ReverseBitsMaskAndShiftTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse bits`(n: Int, expected: Int) {
            ReverseBitsMaskAndShift.test(n, expected)
        }
    }

    @Nested
    inner class ReverseBitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse bits`(n: Int, expected: Int) {
            ReverseBitsRev1().test(n, expected)
        }
    }
}

private fun ReverseBits.test(n: Int, expected: Int) {
    val actual = reverseBits(n)
    assertEquals(expected, actual)
}
