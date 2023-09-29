package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MonotonicArray.MonotonicArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MonotonicArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2, 3),
                true
            ),
            Arguments.of(
                intArrayOf(6, 5, 4, 4),
                true
            ),
            Arguments.of(
                intArrayOf(1, 3, 2),
                false
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 1, 4, 5),
                false
            )
        )
    }

    @Nested
    inner class MonotonicArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if the given array is monotonic`(nums: IntArray, expected: Boolean) {
            MonotonicArrayRev1().test(nums, expected)
        }
    }
}

private fun MonotonicArray.test(nums: IntArray, expected: Boolean) {
    val actual = isMonotonic(nums)
    assertEquals(expected, actual)
}
