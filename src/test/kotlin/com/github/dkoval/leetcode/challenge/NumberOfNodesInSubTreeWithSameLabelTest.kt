package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NumberOfNodesInSubTreeWithSameLabel.NumberOfNodesInSubTreeWithSameLabelRev1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class NumberOfNodesInSubTreeWithSameLabelTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)
                ),
                "abaedcd",
                intArrayOf(2, 1, 1, 1, 1, 1, 1)
            ),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(0, 3)
                ),
                "bbbb",
                intArrayOf(4, 2, 1, 1)
            ),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 3),
                    intArrayOf(0, 4)
                ),
                "aabab",
                intArrayOf(3, 2, 1, 1, 1)
            )
        )
    }

    @Nested
    inner class NumberOfNodesInSubTreeWithSameLabelRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the number of nodes in the subtree with the same label`(
            n: Int,
            edges: Array<IntArray>,
            labels: String,
            expected: IntArray
        ) {
            NumberOfNodesInSubTreeWithSameLabelRev1().test(n, edges, labels, expected)
        }
    }

    private fun NumberOfNodesInSubTreeWithSameLabel.test(
        n: Int,
        edges: Array<IntArray>,
        labels: String,
        expected: IntArray
    ) {
        val actual = countSubTrees(n, edges, labels)
        assertArrayEquals(expected, actual)
    }
}
