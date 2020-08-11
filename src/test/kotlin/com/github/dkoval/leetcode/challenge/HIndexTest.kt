package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HIndexTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 0, 6, 1, 5),
                3
            )
        )
    }

    @Nested
    inner class HIndexNLongNTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the researcher's h-index`(citations: IntArray, expected: Int) {
            HIndexNLongN.test(citations, expected)
        }
    }

    @Nested
    inner class HIndexLinearTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compute the researcher's h-index`(citations: IntArray, expected: Int) {
            HIndexLinear.test(citations, expected)
        }
    }

    private fun HIndex.test(citations: IntArray, expected: Int) {
        val actual = hIndex(citations)
        assertEquals(expected, actual)
    }
}