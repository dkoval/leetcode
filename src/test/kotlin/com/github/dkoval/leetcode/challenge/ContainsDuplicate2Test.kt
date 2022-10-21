package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ContainsDuplicate2.ContainsDuplicate2Rev1
import com.github.dkoval.leetcode.challenge.ContainsDuplicate2.ContainsDuplicate2Rev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ContainsDuplicate2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 1),
                3,
                true
            ),
            Arguments.of(
                intArrayOf(1, 0, 1, 1),
                1,
                true
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 1, 2, 3),
                2,
                false
            )
        )
    }

    @Nested
    inner class ContainsDuplicate2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if there is a nearby duplicate`(nums: IntArray, k: Int, expected: Boolean) {
            ContainsDuplicate2Rev1().test(nums, k, expected)
        }
    }

    @Nested
    inner class ContainsDuplicate2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if there is a nearby duplicate`(nums: IntArray, k: Int, expected: Boolean) {
            ContainsDuplicate2Rev2().test(nums, k, expected)
        }
    }

    private fun ContainsDuplicate2.test(nums: IntArray, k: Int, expected: Boolean) {
        val actual = containsNearbyDuplicate(nums, k)
        assertEquals(expected, actual)
    }
}