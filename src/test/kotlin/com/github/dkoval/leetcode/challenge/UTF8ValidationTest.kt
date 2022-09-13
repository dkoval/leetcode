package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UTF8Validation.UTF8ValidationRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UTF8ValidationTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(197, 130, 1),
                true
            ),
            Arguments.of(
                intArrayOf(235, 140, 4),
                false
            ),
            Arguments.of(
                intArrayOf(115, 100, 102, 231, 154, 132, 13, 10),
                true
            ),
            Arguments.of(
                intArrayOf(240, 162, 138, 147),
                true
            )
        )
    }

    @Nested
    inner class UTF8ValidationRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate UTF-8 encoding`(data: IntArray, expected: Boolean) {
            UTF8ValidationRev1().test(data, expected)
        }
    }

    private fun UTF8Validation.test(data: IntArray, expected: Boolean) {
        val actual = validUtf8(data)
        assertEquals(expected, actual)
    }
}