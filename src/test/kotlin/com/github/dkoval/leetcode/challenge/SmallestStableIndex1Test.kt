package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.SmallestStableIndex1.SmallestStableIndex1Rev1
import com.github.dkoval.leetcode.challenge.SmallestStableIndex1.SmallestStableIndex1Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

internal class SmallestStableIndex1Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(5, 0, 1, 4),
                3,
                3
            ),
            Arguments.of(
                intArrayOf(3, 2, 1),
                1,
                -1
            ),
            Arguments.of(
                intArrayOf(0),
                0,
                0
            )
        )
    }

    @Nested
    inner class SmallestStableIndex1Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest stable index of the given array nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SmallestStableIndex1Rev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class SmallestStableIndex1Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the smallest stable index of the given array nums`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            SmallestStableIndex1Rev2().test(nums, k, expected)
        }
    }
}

private fun SmallestStableIndex1.test(nums: IntArray, k: Int, expected: Int) {
    val actual = firstStableIndex(nums, k)
    assertEquals(expected, actual)
}
