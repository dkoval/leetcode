package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DiagonalTraverse2.DiagonalTraverse2Rev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DiagonalTraverse2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    listOf(1, 2, 3),
                    listOf(4, 5, 6),
                    listOf(7, 8, 9)
                ),
                intArrayOf(1, 4, 2, 7, 5, 3, 8, 6, 9)
            ),
            Arguments.of(
                listOf(
                    listOf(1, 2, 3, 4, 5),
                    listOf(6, 7),
                    listOf(8),
                    listOf(9, 10, 11),
                    listOf(12, 13, 14, 15, 16)
                ),
                intArrayOf(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16)
            )
        )
    }

    @Nested
    inner class DiagonalTraverse2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all elements of nums in diagonal order`(nums: List<List<Int>>, expected: IntArray) {
            DiagonalTraverse2Rev1().test(nums, expected)
        }
    }
}

private fun DiagonalTraverse2.test(nums: List<List<Int>>, expected: IntArray) {
    val actual = findDiagonalOrder(nums)
    assertArrayEquals(expected, actual)
}
