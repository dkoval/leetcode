package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PowerfulIntegersTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                2,
                3,
                10,
                listOf(2, 3, 4, 5, 7, 9, 10)
            ),
            Arguments.of(
                3,
                5,
                15,
                listOf(2, 4, 6, 8, 10, 14)
            ),
            Arguments.of(
                2,
                1,
                10,
                // 2^0 + 1, 2^1 + 1, 2^2 + 1, 2^3 + 1
                listOf(2, 3, 5, 9)
            ),
            Arguments.of(
                1,
                1,
                10,
                listOf(2)
            ),
            Arguments.of(
                1,
                1,
                1,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return a list of all the powerful integers that have a value less than or equal to bound`(
        x: Int,
        y: Int,
        bound: Int,
        expected: List<Int>
    ) {
        val actual = PowerfulIntegers().powerfulIntegers(x, y, bound)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}