package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class FirstUniqueCharacterInStringTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of("leetcode", 0),
            Arguments.of("loveleetcode", 2),
            Arguments.of("aabb", -1)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should  find the first non-repeating character in it and return its index`(s: String, expected: Int) {
        val actual = FirstUniqueCharacterInString().firstUniqChar(s)
        assertEquals(expected, actual)
    }
}