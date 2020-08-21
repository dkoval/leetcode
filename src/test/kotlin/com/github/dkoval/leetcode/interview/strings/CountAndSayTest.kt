package com.github.dkoval.leetcode.interview.strings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountAndSayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                1,
                "1"
            ),
            Arguments.of(
                2,
                "11"
            ),
            Arguments.of(
                3,
                "21"
            ),
            Arguments.of(
                4,
                "1211"
            ),
            Arguments.of(
                10,
                "13211311123113112211"
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should generate the n-th term of the count-and-say sequence`(n: Int, expected: String) {
        val actual = CountAndSay.countAndSay(n)
        assertEquals(expected, actual)
    }
}