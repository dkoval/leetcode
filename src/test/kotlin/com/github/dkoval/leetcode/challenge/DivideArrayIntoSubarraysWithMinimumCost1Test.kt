package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DivideArrayIntoSubarraysWithMinimumCost1.DivideArrayIntoSubarraysWithMinimumCost1Rev1
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

internal class DivideArrayIntoSubarraysWithMinimumCost1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            arguments(
                intArrayOf(1, 2, 3, 12),
                6
            ),
            arguments(
                intArrayOf(5, 4, 3),
                12
            ),
            arguments(
                intArrayOf(10, 3, 1, 1),
                12
            )
        )
    }

    @Nested
    inner class DivideArrayIntoSubarraysWithMinimumCost1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum possible sum of the cost of these subarrays`(nums: IntArray, expected: Int) {
            DivideArrayIntoSubarraysWithMinimumCost1Rev1().test(nums, expected)
        }
    }
}

private fun DivideArrayIntoSubarraysWithMinimumCost1.test(nums: IntArray, expected: Int) {
    val actual = minimumCost(nums)
    assertEquals(expected, actual)
}
