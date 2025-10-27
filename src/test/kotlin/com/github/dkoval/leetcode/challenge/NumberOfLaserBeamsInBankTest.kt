package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfLaserBeamsInBank.NumberOfLaserBeamsInBankRev1
import com.github.dkoval.leetcode.challenge.NumberOfLaserBeamsInBank.NumberOfLaserBeamsInBankRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfLaserBeamsInBankTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    "011001",
                    "000000",
                    "010100",
                    "001000"
                ),
                8
            ),
            Arguments.of(
                arrayOf(
                    "000",
                    "111",
                    "000"
                ),
                0
            )
        )
    }

    @Nested
    inner class NumberOfLaserBeamsInBankRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of laser beams in the bank`(bank: Array<String>, expected: Int) {
            NumberOfLaserBeamsInBankRev1().test(bank, expected)
        }
    }

    @Nested
    inner class NumberOfLaserBeamsInBankRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the total number of laser beams in the bank`(bank: Array<String>, expected: Int) {
            NumberOfLaserBeamsInBankRev2().test(bank, expected)
        }
    }
}

private fun NumberOfLaserBeamsInBank.test(bank: Array<String>, expected: Int) {
    val actual = numberOfBeams(bank)
    assertEquals(expected, actual)
}
