package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.MaximumNumberOfRemovableCharacters.MaximumNumberOfRemovableCharactersUsingBinarySearchRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumNumberOfRemovableCharactersTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abcacb",
                "ab",
                intArrayOf(3, 1, 0),
                2
            ),
            Arguments.of(
                "abcbddddd",
                "abcd",
                intArrayOf(3, 2, 1, 4, 5, 6),
                1
            ),
            Arguments.of(
                "abcab",
                "abc",
                intArrayOf(0, 1, 2, 3, 4),
                0
            ),
            Arguments.of(
                "qlevcvgzfpryiqlwy",
                "qlecfqlw",
                intArrayOf(12, 5),
                2
            )
        )
    }

    @Nested
    inner class MaximumNumberOfRemovableCharactersUsingBinarySearchRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum k you can choose such that p is still a subsequence of s after the removals`(
            s: String,
            p: String,
            removable: IntArray,
            expected: Int
        ) {
            MaximumNumberOfRemovableCharactersUsingBinarySearchRev1()
                .test(s, p, removable, expected)
        }
    }

    private fun MaximumNumberOfRemovableCharacters.test(s: String, p: String, removable: IntArray, expected: Int) {
        val actual = maximumRemovals(s, p, removable)
        assertEquals(expected, actual)
    }
}