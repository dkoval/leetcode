package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.LargestOddNumberInString.LargestOddNumberInStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LargestOddNumberInStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("52", "5"),
            Arguments.of("4206", ""),
            Arguments.of("35427", "35427"),
            Arguments.of("7542351161", "7542351161")
        )
    }

    @Nested
    inner class LargestOddNumberInStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest-valued odd integer`(num: String, expected: String) {
            LargestOddNumberInStringRev1().test(num, expected)
        }
    }
}

private fun LargestOddNumberInString.test(num: String, expected: String) {
    val actual = largestOddNumber(num)
    assertEquals(expected, actual)
}
