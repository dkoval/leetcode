package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximizeScoreAfterNOperations.MaximizeScoreAfterNOperationsDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximizeScoreAfterNOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(3, 4, 6, 8),
                11
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6),
                14
            ),
            Arguments.of(
                intArrayOf(
                    109497,
                    983516,
                    698308,
                    409009,
                    310455,
                    528595,
                    524079,
                    18036,
                    341150,
                    641864,
                    913962,
                    421869,
                    943382,
                    295019
                ),
                527
            ),
        )
    }

    @Nested
    inner class MaximizeScoreAfterNOperationsDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the maximum score you can receive after performing n operations`(
            nums: IntArray,
            expected: Int
        ) {
            MaximizeScoreAfterNOperationsDPTopDown().test(nums, expected)
        }
    }
}

private fun MaximizeScoreAfterNOperations.test(nums: IntArray, expected: Int) {
    val actual = maxScore(nums)
    assertEquals(expected, actual)
}
