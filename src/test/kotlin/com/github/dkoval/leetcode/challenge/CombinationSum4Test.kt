package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CombinationSum4.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CombinationSum4Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3),
                4,
                // The possible combination ways are:
                // (1, 1, 1, 1)
                // (1, 1, 2)
                // (1, 2, 1)
                // (1, 3)
                // (2, 1, 1)
                // (2, 2)
                // (3, 1)
                7
            ),
            Arguments.of(
                intArrayOf(9),
                3,
                0
            )
        )
    }

    @Nested
    inner class CombinationSum4DPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible combinations that add up to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            CombinationSum4DPTopDown().test(nums, target, expected)
        }
    }

    @Nested
    inner class CombinationSum4DPTopDownEarlyTerminateTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible combinations that add up to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            CombinationSum4DPTopDownEarlyTerminate().test(nums, target, expected)
        }
    }

    @Nested
    inner class CombinationSum4DPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of possible combinations that add up to target`(
            nums: IntArray,
            target: Int,
            expected: Int
        ) {
            CombinationSumDPBottomUp().test(nums, target, expected)
        }
    }

}

private fun CombinationSum4.test(nums: IntArray, target: Int, expected: Int) {
    val actual = combinationSum4(nums, target)
    assertEquals(expected, actual)
}
