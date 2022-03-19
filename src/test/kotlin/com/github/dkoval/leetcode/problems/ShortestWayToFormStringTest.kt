package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestWayToFormStringTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                "abcbc",
                // The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
                2
            ),
            Arguments.of(
                "abc",
                "acdbc",
                // The target string cannot be constructed from the subsequences of source string
                // due to the character "d" in target string.
                -1
            ),
            Arguments.of(
                "xyz",
                "xzyxz",
                // The target string can be constructed as follows "xz" + "y" + "xz".
                3
            )
        )
    }


    @Nested
    inner class ShortestWayToFormStringInMNTimeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of subsequences of source such that their concatenation equals target`(
            source: String,
            target: String,
            expected: Int
        ) {
            ShortestWayToFormStringInMNTime.test(source, target, expected)
        }
    }

    private fun ShortestWayToFormString.test(
        source: String,
        target: String,
        expected: Int
    ) {
        val actual = shortestWay(source, target)
        assertEquals(expected, actual)
    }
}