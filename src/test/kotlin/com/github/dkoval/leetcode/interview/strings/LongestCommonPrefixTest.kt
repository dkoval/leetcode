package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LongestCommonPrefixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf("flower", "flow", "flight"),
                "fl"
            ),
            Arguments.of(
                arrayOf("dog", "racecar", "car"),
                ""
            )
        )
    }

    @Nested
    inner class LongestCommonPrefixHorizontalScanningTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest common prefix`(strs: Array<String>, expected: String) {
            LongestCommonPrefixHorizontalScanning.test(strs, expected)
        }
    }

    @Nested
    inner class LongestCommonPrefixVerticalScanningTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the longest common prefix`(strs: Array<String>, expected: String) {
            LongestCommonPrefixVerticalScanning.test(strs, expected)
        }
    }

    private fun LongestCommonPrefix.test(strs: Array<String>, expected: String) {
        val actual = longestCommonPrefix(strs)
        assertEquals(expected, actual)
    }
}