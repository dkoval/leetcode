package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FindPowerOfKSizeSubarrays1.FindPowerOfKSizeSubarrays1Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindPowerOfKSizeSubarrays1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 3, 2, 5),
                3,
                intArrayOf(3, 4, -1, -1, -1)
            ),
            Arguments.of(
                intArrayOf(2, 2, 2, 2, 2),
                4,
                intArrayOf(-1, -1)
            ),
            Arguments.of(
                intArrayOf(3, 2, 3, 2, 3, 2),
                2,
                intArrayOf(-1, 3, -1, 3, -1)
            ),
        )
    }

    @Nested
    inner class FindPowerOfKSizeSubarrays1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the power of all subarrays of nums of size k`(nums: IntArray, k: Int, expected: IntArray) {
            FindPowerOfKSizeSubarrays1Rev1().test(nums, k, expected)
        }
    }
}

private fun FindPowerOfKSizeSubarrays1.test(nums: IntArray, k: Int, expected: IntArray) {
    val actual = resultsArray(nums, k)
    assertArrayEquals(expected, actual)
}
