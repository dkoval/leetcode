package com.github.dkoval.leetcode.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveElementTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 2, 2, 3),
                3,
                intArrayOf(2, 2)
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 2, 3, 0, 4, 2),
                2,
                intArrayOf(0, 1, 4, 0, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should remove all instances of the given value in-place and return the new length`(
        nums: IntArray,
        valToRemove: Int,
        expected: IntArray
    ) {
        val actualSize = RemoveElement().removeElement(nums, valToRemove)
        Assertions.assertEquals(expected.size, actualSize)
        val actual = nums.copyOf(actualSize)
        // It doesn't matter what values are set beyond the returned length
        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}