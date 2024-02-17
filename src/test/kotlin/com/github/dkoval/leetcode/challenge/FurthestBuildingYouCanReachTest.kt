package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FurthestBuildingYouCanReach.FurthestBuildingYouCanReachRev1
import com.github.dkoval.leetcode.challenge.FurthestBuildingYouCanReach.FurthestBuildingYouCanReachRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FurthestBuildingYouCanReachTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 7, 6, 9, 14, 12),
                5,
                1,
                4
            ),
            Arguments.of(
                intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19),
                10,
                2,
                7
            ),
            Arguments.of(
                intArrayOf(14, 3, 19, 3),
                17,
                0,
                3
            )
        )
    }

    @Nested
    inner class FurthestBuildingYouCanReachRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally`(
            heights: IntArray,
            bricks: Int,
            ladders: Int,
            expected: Int
        ) {
            FurthestBuildingYouCanReachRev1().test(heights, bricks, ladders, expected)
        }
    }

    @Nested
    inner class FurthestBuildingYouCanReachRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally`(
            heights: IntArray,
            bricks: Int,
            ladders: Int,
            expected: Int
        ) {
            FurthestBuildingYouCanReachRev2().test(heights, bricks, ladders, expected)
        }
    }
}

private fun FurthestBuildingYouCanReach.test(heights: IntArray, bricks: Int, ladders: Int, expected: Int) {
    val actual = furthestBuilding(heights, bricks, ladders)
    assertEquals(expected, actual)
}
