package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumDistanceBetweenThreeEqualElements1.MinimumDistanceBetweenThreeEqualElements1Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class MinimumDistanceBetweenThreeEqualElements1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 1, 1, 3),
                6
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3, 2, 1, 2),
                8
            ),
            Arguments.of(
                intArrayOf(1),
                -1
            )
        )
    }

    @Nested
    inner class MinimumDistanceBetweenThreeEqualElements1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum distance between three equal elements`(
            nums: IntArray,
            expected: Int
        ) {
            MinimumDistanceBetweenThreeEqualElements1Rev1().test(nums, expected)
        }
    }
}

private fun MinimumDistanceBetweenThreeEqualElements1Rev1.test(nums: IntArray, expected: Int) {
    val actual = minimumDistance(nums)
    assertEquals(expected, actual)
}
