package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ShortestSubarrayWithORAtLeastK2.ShortestSubarrayWithORAtLeastK2Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ShortestSubarrayWithORAtLeastK2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                2,
                1
            ),
            Arguments.of(
                intArrayOf(2, 1, 8),
                10,
                3
            ),
            Arguments.of(
                intArrayOf(1, 2),
                0,
                1
            )
        )
    }

    @Nested
    inner class ShortestSubarrayWithORAtLeastK2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the shortest special non-empty subarray of nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            ShortestSubarrayWithORAtLeastK2Rev1().test(nums, k, expected)
        }
    }
}

private fun ShortestSubarrayWithORAtLeastK2.test(nums: IntArray, k: Int, expected: Int) {
    val actual = minimumSubarrayLength(nums, k)
    assertEquals(expected, actual)
}
