package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumXORForEachQuery.MaximumXORForEachQueryRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumXORForEachQueryTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 1, 3),
                2,
                intArrayOf(0, 3, 2, 3)
            ),
            Arguments.of(
                intArrayOf(2, 3, 4, 7),
                3,
                intArrayOf(5, 2, 6, 5)
            ),
            Arguments.of(
                intArrayOf(0, 1, 2, 2, 5, 7),
                3,
                intArrayOf(4, 3, 6, 4, 6, 7)
            )
        )
    }

    @Nested
    inner class MaximumXORForEachQueryRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return an array answer, where answer(i) is the answer to the i-th query`(
            nums: IntArray,
            maximumBit: Int,
            expected: IntArray
        ) {
            MaximumXORForEachQueryRev1().test(nums, maximumBit, expected)
        }
    }
}

private fun MaximumXORForEachQuery.test(nums: IntArray, maximumBit: Int, expected: IntArray) {
    val actual = getMaximumXor(nums, maximumBit)
    assertArrayEquals(expected, actual)
}
