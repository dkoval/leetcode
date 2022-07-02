package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.IsGraphBipartite.IsGraphBipartiteBFS
import com.github.dkoval.leetcode.challenge.IsGraphBipartite.IsGraphBipartiteDFS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IsGraphBipartiteTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(0, 2),
                    intArrayOf(0, 1, 3),
                    intArrayOf(0, 2)
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(0, 2)
                ),
                true
            )
        )
    }

    @Nested
    inner class IsGraphBipartiteDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if it is bipartite`(graph: Array<IntArray>, expected: Boolean) {
            IsGraphBipartiteDFS().test(graph, expected)
        }
    }

    @Nested
    inner class IsGraphBipartiteBFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return true if and only if it is bipartite`(graph: Array<IntArray>, expected: Boolean) {
            IsGraphBipartiteBFS().test(graph, expected)
        }
    }

    private fun IsGraphBipartite.test(graph: Array<IntArray>, expected: Boolean) {
        val actual = isBipartite(graph)
        assertEquals(expected, actual)
    }
}