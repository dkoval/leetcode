package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ExpressionAddOperatorsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                "123",
                6,
                listOf(
                    "1*2*3",
                    "1+2+3"
                )
            ),
            Arguments.of(
                "232",
                8,
                listOf(
                    "2*3+2",
                    "2+3*2"
                )
            ),
            Arguments.of(
                "105",
                5,
                listOf(
                    "1*0+5",
                    "10-5"
                )
            ),
            Arguments.of(
                "00",
                0,
                listOf(
                    "0*0",
                    "0+0",
                    "0-0"
                )
            ),
            Arguments.of(
                "3456237490",
                9191,
                listOf<Int>()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return all possibilities to add the binary operators 'plus', 'minus', or 'multiply' between the digits of num so that the expression evaluates to the target value`(
        num: String,
        target: Int,
        expected: List<String>
    ) {
        val actual = ExpressionAddOperators().addOperators(num, target)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}