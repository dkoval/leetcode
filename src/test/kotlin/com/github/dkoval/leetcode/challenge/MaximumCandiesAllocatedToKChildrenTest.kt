package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumCandiesAllocatedToKChildren.MaximumCandiesAllocatedToKChildrenRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumCandiesAllocatedToKChildrenTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 8, 6),
                3L,
                5
            ),
            Arguments.of(
                intArrayOf(2, 5),
                11L,
                0
            ),
            Arguments.of(
                intArrayOf(4, 7, 5),
                4L,
                3
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 10),
                5L,
                3
            )
        )
    }

    @Nested
    inner class MaximumCandiesAllocatedToKChildrenRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of candies each child can get`(
            candies: IntArray,
            k: Long,
            expected: Int
        ) {
            MaximumCandiesAllocatedToKChildrenRev1().test(candies, k, expected)
        }
    }
}

private fun MaximumCandiesAllocatedToKChildren.test(candies: IntArray, k: Long, expected: Int) {
    val actual = maximumCandies(candies, k)
    assertEquals(expected, actual)
}