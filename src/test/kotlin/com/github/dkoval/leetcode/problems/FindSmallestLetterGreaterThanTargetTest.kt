package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FindSmallestLetterGreaterThanTarget.FindSmallestLetterGreaterThanTargetBinarySearch
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindSmallestLetterGreaterThanTargetTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf('c','f','j'),
                'a',
                'c'
            ),
            Arguments.of(
                charArrayOf('c','f','j'),
                'c',
                'f'
            ),
            Arguments.of(
                charArrayOf('c','f','j'),
                'd',
                'f'
            ),
            Arguments.of(
                charArrayOf('c','f','j'),
                'j',
                'c'
            )
        )
    }

    @Nested
    inner class FindSmallestLetterGreaterThanTargetBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest character in the array that is larger than target`(
            letters: CharArray,
            target: Char,
            expected: Char
        ) {
            FindSmallestLetterGreaterThanTargetBinarySearch().test(letters, target, expected)
        }
    }

    private fun FindSmallestLetterGreaterThanTarget.test(letters: CharArray, target: Char, expected: Char) {
        val actual = nextGreatestLetter(letters, target)
        assertEquals(expected, actual)
    }
}