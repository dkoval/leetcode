package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CountSubarraysWithMajorityElement1.CountSubarraysWithMajorityElement1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class CountSubarraysWithMajorityElement1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 2, 2, 3),
                2,
                5
            ),
            arguments(
                intArrayOf(1, 1, 1, 1),
                1,
                10
            ),
            arguments(
                intArrayOf(1, 2, 3),
                4,
                0
            )
        )
    }

    @Nested
    inner class CountSubarraysWithMajorityElement1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of subarrays where target is the majority`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            CountSubarraysWithMajorityElement1Rev1().test(nums, target, expected)
        }
    }
}

private fun CountSubarraysWithMajorityElement1.test(nums: IntArray, target: Int, expected: Int) {
    val actual = countMajoritySubarrays(nums, target)
    assertEquals(expected, actual)
}
