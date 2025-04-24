package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountCompleteSubarraysInArray.CountCompleteSubarraysInArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CountCompleteSubarraysInArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 1, 2, 2),
                4
            ),
            Arguments.of(
                intArrayOf(5, 5, 5, 5),
                10
            )
        )
    }

    @Nested
    inner class CountCompleteSubarraysInArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of complete subarrays`(
            nums: IntArray,
            expected: Int
        ) {
            CountCompleteSubarraysInArrayRev1().test(nums, expected)
        }
    }
}

private fun CountCompleteSubarraysInArray.test(nums: IntArray, expected: Int) {
    val actual = countCompleteSubarrays(nums)
    assertEquals(expected, actual)
}
