package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfStringContainsAllBinaryCodesOfSizeK.CheckIfStringContainsAllBinaryCodesOfSizeKAccepted
import com.github.dkoval.leetcode.challenge.CheckIfStringContainsAllBinaryCodesOfSizeK.CheckIfStringContainsAllBinaryCodesOfSizeKTLE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfStringContainsAllBinaryCodesOfSizeKTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "00110110",
                2,
                true
            ),
            Arguments.of(
                "00110",
                2,
                true
            ),
            Arguments.of(
                "0110",
                1,
                true
            ),
            Arguments.of(
                "0110",
                2,
                false
            ),
            Arguments.of(
                "0000000001011100",
                4,
                false
            ),
            Arguments.of(
                "00000000010011101",
                4,
                false
            )

        )
    }

    @Nested
    inner class CheckIfStringContainsAllBinaryCodesOfSizeKTLETest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return True if every binary code of length k is a substring of s`(
            s: String,
            k: Int,
            expected: Boolean
        ) {
            CheckIfStringContainsAllBinaryCodesOfSizeKTLE().test(s, k, expected)
        }
    }

    @Nested
    inner class CheckIfStringContainsAllBinaryCodesOfSizeKAcceptedTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return True if every binary code of length k is a substring of s`(
            s: String,
            k: Int,
            expected: Boolean
        ) {
            CheckIfStringContainsAllBinaryCodesOfSizeKAccepted().test(s, k, expected)
        }
    }

    private fun CheckIfStringContainsAllBinaryCodesOfSizeK.test(s: String, k: Int, expected: Boolean) {
        val actual = hasAllCodes(s, k)
        assertEquals(expected, actual)
    }
}