package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.PartitionArrayForMaximumSum.PartitionArrayForMaximumSumDPTopDown
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionArrayForMaximumSumTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 15, 7, 9, 2, 5, 10),
                3,
                84
            ),
            Arguments.of(
                intArrayOf(1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3),
                4,
                83
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                1
            )
        )
    }

    @Nested
    inner class PartitionArrayForMaximumSumDPTopDownTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the largest sum of the given array after partitioning`(
            arr: IntArray,
            k: Int,
            expected: Int
        ) {
            PartitionArrayForMaximumSumDPTopDown().test(arr, k, expected)
        }
    }
}

private fun PartitionArrayForMaximumSum.test(arr: IntArray, k: Int, expected: Int) {
    val actual = maxSumAfterPartitioning(arr, k)
    assertEquals(expected, actual)
}
