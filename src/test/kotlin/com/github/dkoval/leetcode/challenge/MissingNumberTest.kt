package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MissingNumber.MissingNumberByCalculatingSums
import com.github.dkoval.leetcode.challenge.MissingNumber.MissingNumberUsingXOR
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MissingNumberTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(0, 1),
                2
            ),
            Arguments.of(
                intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1),
                8
            ),
            Arguments.of(
                intArrayOf(0),
                1
            )
        )
    }

    @Nested
    inner class MissingNumberByCalculatingSumsTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return number in the range that is missing`(nums: IntArray, expected: Int) {
            MissingNumberByCalculatingSums().test(nums, expected)
        }
    }

    @Nested
    inner class MissingNumberUsingXORTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return number in the range that is missing`(nums: IntArray, expected: Int) {
            MissingNumberUsingXOR().test(nums, expected)
        }
    }

    private fun MissingNumber.test(nums: IntArray, expected: Int) {
        val actual = missingNumber(nums)
        assertEquals(expected, actual)
    }
}