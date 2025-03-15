package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.HouseRobber4.HouseRobber4Rev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class HouseRobber4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(contex: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 3, 5, 9),
                2,
                5
            ),
            Arguments.of(
                intArrayOf(2, 7, 9, 3, 1),
                2,
                2
            )
        )
    }

    @Nested
    inner class HouseRobber4Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum capability of the robber out of all the possible ways to steal at least k houses`(
            nums: IntArray,
            k: Int,
            expected: Int
        ) {
            HouseRobber4Rev1().test(nums, k, expected)
        }
    }
}

private fun HouseRobber4.test(nums: IntArray, k: Int, expected: Int) {
    val actual = minCapability(nums, k)
    assertEquals(expected, actual)
}
