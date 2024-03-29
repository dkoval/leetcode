package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSubarraysWhereMaxElementAppearsAtLeastKTimes.CountSubarraysWhereMaxElementAppearsAtLeastKTimesRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountSubarraysWhereMaxElementAppearsAtLeastKTimesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 2, 3, 3),
                2,
                6L
            ),
            Arguments.of(
                intArrayOf(1, 4, 2, 1),
                3,
                0L
            )
        )
    }

    @Nested
    inner class CountSubarraysWhereMaxElementAppearsAtLeastKTimesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of subarrays where the maximum element of nums appears at least k times in that subarray`(
            nums: IntArray,
            k: Int,
            expected: Long
        ) {
            CountSubarraysWhereMaxElementAppearsAtLeastKTimesRev1().test(nums, k, expected)
        }
    }
}

private fun CountSubarraysWhereMaxElementAppearsAtLeastKTimes.test(nums: IntArray, k: Int, expected: Long) {
    val actual = countSubarrays(nums, k)
    assertEquals(expected, actual)
}
