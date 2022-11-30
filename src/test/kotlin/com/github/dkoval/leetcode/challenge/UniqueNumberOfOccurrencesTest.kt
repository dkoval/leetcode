package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.UniqueNumberOfOccurrences.UniqueNumberOfOccurrencesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniqueNumberOfOccurrencesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 1, 1, 3),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2),
                false
            ),
            Arguments.of(
                intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0),
                true
            )
        )
    }

    @Nested
    inner class UniqueNumberOfOccurrencesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the number of occurrences of each value in the array is unique`(arr: IntArray, expected: Boolean) {
            UniqueNumberOfOccurrencesRev1().test(arr, expected)
        }
    }

    private fun UniqueNumberOfOccurrences.test(arr: IntArray, expected: Boolean) {
        val actual = uniqueOccurrences(arr)
        assertEquals(expected, actual)
    }
}