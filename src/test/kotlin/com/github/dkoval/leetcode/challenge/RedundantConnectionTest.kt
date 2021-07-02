package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.RedundantConnection.RedundantConnectionUsingDFS
import com.github.dkoval.leetcode.challenge.RedundantConnection.RedundantConnectionUsingUnionFind
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RedundantConnectionTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                ),
                intArrayOf(2, 3)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5)
                ),
                intArrayOf(1, 4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(9, 10),
                    intArrayOf(5, 8),
                    intArrayOf(2, 6),
                    intArrayOf(1, 5),
                    intArrayOf(3, 8),
                    intArrayOf(4, 9),
                    intArrayOf(8, 10),
                    intArrayOf(4, 10),
                    intArrayOf(6, 8),
                    intArrayOf(7, 9)
                ),
                intArrayOf(4, 10)
            )
        )
    }

    @Nested
    inner class RedundantConnectionUsingUnionFindTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return an edge that can be removed so that the resulting graph is a tree of n nodes`(
            edges: Array<IntArray>,
            expected: IntArray
        ) {
            RedundantConnectionUsingUnionFind().test(edges, expected)
        }
    }

    @Nested
    inner class RedundantConnectionUsingDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `return an edge that can be removed so that the resulting graph is a tree of n nodes`(
            edges: Array<IntArray>,
            expected: IntArray
        ) {
            RedundantConnectionUsingDFS().test(edges, expected)
        }
    }

    private fun RedundantConnection.test(edges: Array<IntArray>, expected: IntArray) {
        val actual = findRedundantConnection(edges)
        assertArrayEquals(expected, actual)
    }
}