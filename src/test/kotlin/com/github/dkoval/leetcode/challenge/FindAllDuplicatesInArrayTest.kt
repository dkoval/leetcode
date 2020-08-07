package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindAllDuplicatesInArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(4, 3, 2, 7, 8, 2, 3, 1),
                listOf(2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should find all the elements that appear twice in an array`(nums: IntArray, expected: List<Int>) {
        val actual = FindAllDuplicatesInArray.findDuplicates(nums)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}