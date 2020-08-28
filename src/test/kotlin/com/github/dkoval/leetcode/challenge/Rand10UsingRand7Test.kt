package com.github.dkoval.leetcode.challenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class Rand10UsingRand7Test {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 10])
    fun `should generates a uniform random integer in the range 1 to 10`(numRepeats: Int) {
        repeat(numRepeats) {
            val actual = Rand10UsingRand7.rand10()
            assertThat(actual).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(10)
        }
    }
}