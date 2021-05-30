package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumGapTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                intArrayOf(3, 6, 9, 1),
                3
            ),
            Arguments.of(
                intArrayOf(10),
                0
            ),
            Arguments.of(
                intArrayOf(1, 3, 100),
                97
            ),
            Arguments.of(
                intArrayOf(
                    12115,
                    10639,
                    2351,
                    29639,
                    31300,
                    11245,
                    16323,
                    24899,
                    8043,
                    4076,
                    17583,
                    15872,
                    19443,
                    12887,
                    5286,
                    6836,
                    31052,
                    25648,
                    17584,
                    24599,
                    13787,
                    24727,
                    12414,
                    5098,
                    26096,
                    23020,
                    25338,
                    28472,
                    4345,
                    25144,
                    27939,
                    10716,
                    3830,
                    13001,
                    7960,
                    8003,
                    10797,
                    5917,
                    22386,
                    12403,
                    2335,
                    32514,
                    23767,
                    1868,
                    29882,
                    31738,
                    30157,
                    7950,
                    20176,
                    11748,
                    13003,
                    13852,
                    19656,
                    25305,
                    7830,
                    3328,
                    19092,
                    28245,
                    18635,
                    5806,
                    18915,
                    31639,
                    24247,
                    32269,
                    29079,
                    24394,
                    18031,
                    9395,
                    8569,
                    11364,
                    28701,
                    32496,
                    28203,
                    4175,
                    20889,
                    28943,
                    6495,
                    14919,
                    16441,
                    4568,
                    23111,
                    20995,
                    7401,
                    30298,
                    2636,
                    16791,
                    1662,
                    27367,
                    2563,
                    22169,
                    1607,
                    15711,
                    29277,
                    32386,
                    27365,
                    31922,
                    26142,
                    8792
                ),
                1244
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the maximum difference between two successive elements in its sorted form`(
        nums: IntArray,
        expected: Int
    ) {
        val actual = MaximumGap().maximumGap(nums)
        assertEquals(expected, actual)
    }
}