package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.StringCompression.StringCompressionRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StringCompressionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'),
                charArrayOf('a', '2', 'b', '2', 'c', '3')
            ),
            Arguments.of(
                charArrayOf('a'),
                charArrayOf('a')
            ),
            Arguments.of(
                charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'),
                charArrayOf('a', 'b', '1', '2')
            )
        )
    }

    @Nested
    inner class StringCompressionRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should compress the given string by modifying the input array and return the new length of the array`(
            chars: CharArray,
            expected: CharArray
        ) {
            StringCompressionRev1().test(chars, expected)
        }
    }
}

private fun StringCompression.test(chars: CharArray, expected: CharArray) {
    val newLength = compress(chars)
    val actual = chars.copyOfRange(0, newLength)
    assertArrayEquals(expected, actual)
}
