package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.KRadiusSubarrayAverages.KRadiusSubarrayAveragesRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class KRadiusSubarrayAveragesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6),
                3,
                intArrayOf(-1, -1, -1, 5, 4, 4, -1, -1, -1)
            ),
            Arguments.of(
                intArrayOf(100000),
                0,
                intArrayOf(100000)
            ),
            Arguments.of(
                intArrayOf(8),
                100000,
                intArrayOf(-1)
            )
        )
    }

    @Nested
    inner class KRadiusSubarrayAveragesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return k-radius average for the subarray centered at index i`(
            nums: IntArray,
            k: Int,
            expected: IntArray
        ) {
            KRadiusSubarrayAveragesRev1().test(nums, k, expected)
        }
    }
}

private fun KRadiusSubarrayAverages.test(nums: IntArray, k: Int, expected: IntArray) {
    val actual = getAverages(nums, k)
    assertArrayEquals(expected, actual)
}
