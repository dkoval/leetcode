package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindIfArrayCanBeSorted.FindIfArrayCanBeSortedRev1
import com.github.dkoval.leetcode.challenge.FindIfArrayCanBeSorted.FindIfArrayCanBeSortedRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindIfArrayCanBeSortedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(8, 4, 2, 30, 15),
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                true
            ),
            Arguments.of(
                intArrayOf(3, 16, 8, 4, 2),
                false
            )
        )
    }

    @Nested
    inner class FindIfArrayCanBeSortedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can sort the array, else return false`(nums: IntArray, expected: Boolean) {
            FindIfArrayCanBeSortedRev1().test(nums, expected)
        }
    }

    @Nested
    inner class FindIfArrayCanBeSortedRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if you can sort the array, else return false`(nums: IntArray, expected: Boolean) {
            FindIfArrayCanBeSortedRev2().test(nums, expected)
        }
    }
}

private fun FindIfArrayCanBeSorted.test(nums: IntArray, expected: Boolean) {
    val actual = canSortArray(nums)
    assertEquals(expected, actual)
}
