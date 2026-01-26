package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MinimumAbsoluteDifference.MinimumAbsoluteDifferenceRev1
import com.github.dkoval.leetcode.challenge.MinimumAbsoluteDifference.MinimumAbsoluteDifferenceRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MinimumAbsoluteDifferenceTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(4, 2, 1, 3),
                listOf(
                    listOf(1, 2),
                    listOf(2, 3),
                    listOf(3, 4)
                )
            ),
            Arguments.of(
                intArrayOf(1, 3, 6, 10, 15),
                listOf(
                    listOf(1, 3)
                )
            ),
            Arguments.of(
                intArrayOf(3, 8, -10, 23, 19, -4, -14, 27),
                listOf(
                    listOf(-14, -10),
                    listOf(19, 23),
                    listOf(23, 27)
                )
            )
        )
    }

    @Nested
    inner class MinimumAbsoluteDifferenceRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all pairs of elements with the minimum absolute difference of any two elements`(
            arr: IntArray,
            expected: List<List<Int>>
        ) {
            MinimumAbsoluteDifferenceRev1().test(arr, expected)
        }
    }

    @Nested
    inner class MinimumAbsoluteDifferenceRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find all pairs of elements with the minimum absolute difference of any two elements`(
            arr: IntArray,
            expected: List<List<Int>>
        ) {
            MinimumAbsoluteDifferenceRev2().test(arr, expected)
        }
    }
}

private fun MinimumAbsoluteDifference.test(arr: IntArray, expected: List<List<Int>>) {
    val actual = minimumAbsDifference(arr)
    assertEquals(expected, actual)
}
