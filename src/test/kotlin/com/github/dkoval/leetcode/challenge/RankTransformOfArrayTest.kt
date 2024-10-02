package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RankTransformOfArray.RankTransformOfArrayRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RankTransformOfArrayTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(40, 10, 20, 30),
                intArrayOf(4, 1, 2, 3)
            ),
            Arguments.of(
                intArrayOf(100, 100, 100),
                intArrayOf(1, 1, 1)
            ),
            Arguments.of(
                intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12),
                intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3)
            )
        )
    }

    @Nested
    inner class RankTransformOfArrayRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should replace each element with its rank`(arr: IntArray, expected: IntArray) {
            RankTransformOfArrayRev1().test(arr, expected)
        }
    }
}

private fun RankTransformOfArray.test(arr: IntArray, expected: IntArray) {
    val actual = arrayRankTransform(arr)
    assertArrayEquals(expected, actual)
}
