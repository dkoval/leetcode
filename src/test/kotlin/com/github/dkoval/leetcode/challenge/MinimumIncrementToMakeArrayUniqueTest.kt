package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumIncrementToMakeArrayUnique.MinimumIncrementToMakeArrayUniqueRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumIncrementToMakeArrayUniqueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 2),
                1
            ),
            Arguments.of(
                intArrayOf(3, 2, 1, 2, 1, 7),
                6
            )
        )
    }

    @Nested
    inner class MinimumIncrementToMakeArrayUniqueRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of moves to make every value in nums unique`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumIncrementToMakeArrayUniqueRev1().test(nums, expected)
        }
    }
}

private fun MinimumIncrementToMakeArrayUnique.test(nums: IntArray, expected: Int) {
    val actual = minIncrementForUnique(nums)
    assertEquals(expected, actual)
}
