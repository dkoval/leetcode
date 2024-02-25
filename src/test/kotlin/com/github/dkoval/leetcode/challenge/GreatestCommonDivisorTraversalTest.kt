package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.GreatestCommonDivisorTraversal.GreatestCommonDivisorTraversalRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class GreatestCommonDivisorTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 6),
                true
            ),
            Arguments.of(
                intArrayOf(3, 9, 5),
                false
            ),
            Arguments.of(
                intArrayOf(4, 3, 12, 8),
                true
            )
        )
    }

    @Nested
    inner class GreatestCommonDivisorTraversalRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if it is possible to traverse between all such pairs of indices, or false otherwise`(
            nums: IntArray,
            expected: Boolean
        ) {
            GreatestCommonDivisorTraversalRev1().test(nums, expected)
        }
    }
}

private fun GreatestCommonDivisorTraversal.test(nums: IntArray, expected: Boolean) {
    val actual = canTraverseAllPairs(nums)
    assertEquals(expected, actual)
}
