package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumChangesToMakeAlternatingBinaryString.MinimumChangesToMakeAlternatingBinaryStringRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumChangesToMakeAlternatingBinaryStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of("0100", 1),
            Arguments.of("10", 0),
            Arguments.of("1111", 2),
            Arguments.of("10010100", 3)
        )
    }

    @Nested
    inner class MinimumChangesToMakeAlternatingBinaryStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations needed to make s alternating`(s: String, expected: Int) {
            MinimumChangesToMakeAlternatingBinaryStringRev1().test(s, expected)
        }
    }
}

private fun MinimumChangesToMakeAlternatingBinaryString.test(s: String, expected: Int) {
    val actual = minOperations(s)
    assertEquals(expected, actual)
}
