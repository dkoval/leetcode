package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CheckIfArrayIsSortedAndRotated.CheckIfArrayIsSortedAndRotatedRev1
import com.github.dkoval.leetcode.challenge.CheckIfArrayIsSortedAndRotated.CheckIfArrayIsSortedAndRotatedRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CheckIfArrayIsSortedAndRotatedTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 5, 1, 2),
                true
            ),
            Arguments.of(
                intArrayOf(2, 1, 3, 4),
                false
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                true
            )
        )
    }

    @Nested
    inner class CheckIfArrayIsSortedAndRotatedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if array is sorted and rotated`(
            nums: IntArray, expected: Boolean
        ) {
            CheckIfArrayIsSortedAndRotatedRev1().test(nums, expected)
        }
    }

    @Nested
    inner class CheckIfArrayIsSortedAndRotatedRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if array is sorted and rotated`(
            nums: IntArray, expected: Boolean
        ) {
            CheckIfArrayIsSortedAndRotatedRev2().test(nums, expected)
        }
    }
}

private fun CheckIfArrayIsSortedAndRotated.test(nums: IntArray, expected: Boolean) {
    val actual = check(nums)
    assertEquals(expected, actual)
}
