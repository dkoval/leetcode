package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.math.abs

class BeautifulArrangement2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(3, 1),
            Arguments.of(3, 2),
            Arguments.of(9, 3)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should construct beautiful arrangement according to rules`(n: Int, k: Int) {
        val actual = BeautifulArrangement2().constructArray(n, k)
        assertThat(actual).containsExactlyInAnyOrder(*IntArray(n) { idx -> idx + 1 })

        val distinct = mutableSetOf<Int>()
        for (i in 1 until n) {
            distinct += abs(actual[i] - actual[i - 1])
        }
        assertThat(distinct).hasSize(k)
    }
}