package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ZeroOneMatrix.ZeroOneMatrixBFS
import com.github.dkoval.leetcode.challenge.ZeroOneMatrix.ZeroOneMatrixDPBottomUp
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ZeroOneMatrixTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1)
                ),
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 2, 1)
                )
            )
        )
    }

    @Nested
    inner class ZeroOneMatrixBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the distance of the nearest 0 for each cell`(mat: Array<IntArray>, expected: Array<IntArray>) {
            ZeroOneMatrixDPBottomUp().test(mat, expected)
        }
    }

    @Nested
    inner class ZeroOneMatrixDPBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the distance of the nearest 0 for each cell`(mat: Array<IntArray>, expected: Array<IntArray>) {
            ZeroOneMatrixBFS().test(mat, expected)
        }
    }

    private fun ZeroOneMatrix.test(mat: Array<IntArray>, expected: Array<IntArray>) {
        val actual = updateMatrix(mat)
        assertArrayEquals(expected, actual)
    }
}