package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MakeArrayStrictlyIncreasing.MakeArrayStrictlyIncreasingRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MakeArrayStrictlyIncreasingTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(1, 3, 2, 4),
                1
            ),
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(4, 3, 1),
                2
            ),
            Arguments.of(
                intArrayOf(1, 5, 3, 6, 7),
                intArrayOf(1, 6, 3, 3),
                -1
            ),
            Arguments.of(
                intArrayOf(5, 16, 19, 2, 1, 12, 7, 14, 5, 16),
                intArrayOf(6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16),
                8
            )
        )
    }

    @Nested
    inner class MakeArrayStrictlyIncreasingRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the minimum number of operations needed to make arr1 strictly increasing`(
            arr1: IntArray,
            arr2: IntArray,
            expected: Int
        ) {
            MakeArrayStrictlyIncreasingRev1().test(arr1, arr2, expected)
        }
    }
}

private fun MakeArrayStrictlyIncreasing.test(arr1: IntArray, arr2: IntArray, expected: Int) {
    val actual = makeArrayIncreasing(arr1, arr2)
    assertEquals(expected, actual)
}
