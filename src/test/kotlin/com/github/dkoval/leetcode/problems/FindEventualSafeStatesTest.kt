package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.FindEventualSafeStates.FindEventualSafeStatesDFS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindEventualSafeStatesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(5),
                    intArrayOf(0),
                    intArrayOf(5),
                    intArrayOf(),
                    intArrayOf()
                ),
                listOf(2, 4, 5, 6)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(0, 4),
                    intArrayOf()
                ),
                listOf(4)
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(),
                    intArrayOf(0, 2, 3, 4),
                    intArrayOf(3),
                    intArrayOf(4),
                    intArrayOf()
                ),
                listOf(0, 1, 2, 3, 4)
            )
        )
    }

    @Nested
    inner class FindEventualSafeStatesDFSTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array containing all the safe nodes of the graph, the answer should be sorted in ascending order`(
            graph: Array<IntArray>,
            expected: List<Int>
        ) {
            FindEventualSafeStatesDFS().test(graph, expected)
        }
    }

    private fun FindEventualSafeStates.test(graph: Array<IntArray>, expected: List<Int>) {
        val actual = eventualSafeNodes(graph)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}