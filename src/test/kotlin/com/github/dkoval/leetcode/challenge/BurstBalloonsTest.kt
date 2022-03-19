package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.BurstBalloons.BurstBalloonsDPBottomUp
import com.github.dkoval.leetcode.challenge.BurstBalloons.BurstBalloonsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BurstBalloonsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 1, 5, 8),
                167
            ),
            Arguments.of(
                intArrayOf(1, 5),
                10
            )
        )
    }

    @Nested
    inner class BurstBalloonsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum coins you can collect by bursting the balloons wisely`(
            nums: IntArray,
            expected: Int
        ) {
            BurstBalloonsDPTopDown()
                .test(nums, expected)
        }
    }

    @Nested
    inner class BurstBalloonsDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum coins you can collect by bursting the balloons wisely`(
            nums: IntArray,
            expected: Int
        ) {
            BurstBalloonsDPBottomUp()
                .test(nums, expected)
        }
    }

    private fun BurstBalloons.test(nums: IntArray, expected: Int) {
        val actual = maxCoins(nums)
        assertEquals(expected, actual)
    }
}