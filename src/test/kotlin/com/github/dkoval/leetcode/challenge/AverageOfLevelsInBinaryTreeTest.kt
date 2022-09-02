package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.AverageOfLevelsInBinaryTree.AverageOfLevelsInBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AverageOfLevelsInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                listOf(3.00000,14.50000,11.00000)
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                    right = TreeNode(20)
                },
                listOf(3.00000,14.50000,11.00000)
            ),
            Arguments.of(
                TreeNode(1),
                listOf(1.00000)
            ),
            Arguments.of(
                TreeNode(Int.MAX_VALUE).apply {
                    left = TreeNode(Int.MAX_VALUE)
                    right = TreeNode(Int.MAX_VALUE)
                },
                listOf(Int.MAX_VALUE.toDouble(), Int.MAX_VALUE.toDouble())
            )
        )
    }

    @Nested
    inner class AverageOfLevelsInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the average value of the nodes on each level`(root: TreeNode, expected: List<Double>) {
            AverageOfLevelsInBinaryTreeRev1().test(root, expected)
        }
    }

    private fun AverageOfLevelsInBinaryTree.test(root: TreeNode, expected: List<Double>) {
        val actual = averageOfLevels(root)
        assertEquals(expected, actual)
    }
}