package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BeautifulArrayTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(1),
            Arguments.of(2),
            Arguments.of(3),
            Arguments.of(4),
            Arguments.of(5)
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return any beautiful array`(n: Int) {
        val actual = BeautifulArray().beautifulArray(n)
        assertArrayIsBeautiful(actual, n)
    }

    private fun assertArrayIsBeautiful(nums: IntArray, n: Int) {
        if (nums.size != n) {
            fail { "nums[] is expected to be of size: $n, but got: ${nums.size}" }
        }

        val expected = (1..n).toMutableSet()

        // O(N^3) time
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in i..j) {
                    if (nums[k] * 2 == nums[i] + nums[j]) {
                        fail { "${nums.contentToString()} is not beautiful: nums[$k] * 2 == nums[$i] + nums[$j]" }
                    }
                }
            }
            expected -= nums[i]
        }

        if (expected.isNotEmpty()) {
            fail { "${nums.contentToString()} is missing $expected numbers" }
        }
    }
}