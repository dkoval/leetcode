package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumNumberOfJumpsToReachLastIndex.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MaximumNumberOfJumpsToReachLastIndexTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 6, 4, 1, 2),
                0,
                -1
            ),
            Arguments.of(
                intArrayOf(1, 3, 6, 4, 1, 2),
                3,
                5
            ),
            Arguments.of(
                intArrayOf(1, 3, 6, 4, 1, 2),
                0,
                -1
            )
        )
    }

    @Nested
    inner class MaximumNumberOfJumpsToReachLastIndexRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of jumps to reach the last index`(
            nums: IntArray,
            start: Int,
            expected: Int
        ) {
            MaximumNumberOfJumpsToReachLastIndexRev1().test(nums, start, expected)
        }
    }

    @Nested
    inner class MaximumNumberOfJumpsToReachLastIndexRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of jumps to reach the last index`(
            nums: IntArray,
            start: Int,
            expected: Int
        ) {
            MaximumNumberOfJumpsToReachLastIndexRev2().test(nums, start, expected)
        }
    }

    @Nested
    inner class MaximumNumberOfJumpsToReachLastIndexRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum number of jumps to reach the last index`(
            nums: IntArray,
            start: Int,
            expected: Int
        ) {
            MaximumNumberOfJumpsToReachLastIndexRev3().test(nums, start, expected)
        }
    }
}

private fun MaximumNumberOfJumpsToReachLastIndex.test(
    nums: IntArray,
    start: Int,
    expected: Int
) {
    val actual = maximumJumps(nums, start)
    assertEquals(expected, actual)
}
