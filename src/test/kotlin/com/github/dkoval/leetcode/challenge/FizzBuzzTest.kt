package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FizzBuzzTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                15,
                listOf(
                    "1",
                    "2",
                    "Fizz",
                    "4",
                    "Buzz",
                    "Fizz",
                    "7",
                    "8",
                    "Fizz",
                    "Buzz",
                    "11",
                    "Fizz",
                    "13",
                    "14",
                    "FizzBuzz"
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should Fizz Buzz`(n: Int, expected: List<String>) {
        val actual = FizzBuzz.fizzBuzz(n)
        assertEquals(expected, actual)
    }
}