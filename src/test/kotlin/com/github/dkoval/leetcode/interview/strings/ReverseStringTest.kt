package com.github.dkoval.leetcode.interview.strings

import com.github.dkoval.leetcode.challenge.ReverseString
import com.github.dkoval.leetcode.challenge.ReverseString.ReverseStringRev2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReverseStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf('h', 'e', 'l', 'l', 'o'),
                charArrayOf('o', 'l', 'l', 'e', 'h')
            ),
            Arguments.of(
                charArrayOf('H', 'a', 'n', 'n', 'a', 'h'),
                charArrayOf('h', 'a', 'n', 'n', 'a', 'H')
            )
        )
    }

    @Nested
    inner class ReverseStringRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse string in-place`(s: CharArray, expected: CharArray) {
            ReverseStringRev1.test(s, expected)
        }
    }

    @Nested
    inner class ReverseStringRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse string in-place`(s: CharArray, expected: CharArray) {
            ReverseStringRev2().test(s, expected)
        }
    }
}

private fun ReverseString.test(s: CharArray, expected: CharArray) {
    reverseString(s)
    assertArrayEquals(expected, s)
}
