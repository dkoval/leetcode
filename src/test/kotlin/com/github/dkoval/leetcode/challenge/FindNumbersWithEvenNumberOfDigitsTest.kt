package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindNumbersWithEvenNumberOfDigits.FindNumbersWithEvenNumberOfDigitsRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindNumbersWithEvenNumberOfDigitsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(12, 345, 2, 6, 7896),
                2
            ),
            Arguments.of(
                intArrayOf(555, 901, 482, 1771),
                1
            )
        )
    }

    @Nested
    inner class FindNumbersWithEvenNumberOfDigitsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of even digit numbers`(
            nums: IntArray,
            expected: Int
        ) {
            FindNumbersWithEvenNumberOfDigitsRev1().test(nums, expected)
        }
    }
}

private fun FindNumbersWithEvenNumberOfDigits.test(nums: IntArray, expected: Int) {
    val actual = findNumbers(nums)
    assertEquals(expected, actual)
}
