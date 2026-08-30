package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RemovingMinimumAndMaximumFromArray.RemovingMinimumAndMaximumFromArrayRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class RemovingMinimumAndMaximumFromArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(2, 10, 7, 5, 4, 1, 8, 6), 5),
            Arguments.of(intArrayOf(0, -4, 19, 1, 8, -2, -3, 5), 3),
            Arguments.of(intArrayOf(101), 1),
            Arguments.of(intArrayOf(48, -49, -67, 18, -59, -56, 47, -26, -24, -73, -96, 27, -2, -45), 5)
        )
    }

    @Nested
    inner class RemovingMinimumAndMaximumFromArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of deletions it would take to remove both the minimum and maximum element from the array`(
            nums: IntArray,
            expected: Int
        ) {
            RemovingMinimumAndMaximumFromArrayRev1().test(nums, expected)
        }
    }
}

private fun RemovingMinimumAndMaximumFromArray.test(nums: IntArray, expected: Int) {
    val actual = minimumDeletions(nums)
    assertEquals(expected, actual)
}
