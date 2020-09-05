package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AllElementsInTwoBinarySearchTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(4)
                },
                TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(3)
                },
                listOf(0, 1, 1, 2, 3, 4)
            ),
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(-10)
                    right = TreeNode(10)
                },
                null,
                listOf(-10, 0, 10)
            ),
            Arguments.of(
                null,
                TreeNode(0).apply {
                    left = TreeNode(-10)
                    right = TreeNode(10)
                },
                listOf(-10, 0, 10)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(8)
                },
                TreeNode(8).apply {
                    left = TreeNode(1)
                },
                listOf(1, 1, 8, 8)
            )

        )
    }

    @Nested
    inner class AllElementsInTwoBinarySearchTreesUsingInorderTraversalWithMergeTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list containing all the integers from both trees sorted in ascending order`(
            root1: TreeNode?,
            root2: TreeNode?,
            expected: List<Int>
        ) {
            AllElementsInTwoBinarySearchTreesUsingInorderTraversalWithMerge.test(root1, root2, expected)
        }
    }

    @Nested
    inner class AllElementsInTwoBinarySearchTreesUsingInorderTraversalWithStackTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return a list containing all the integers from both trees sorted in ascending order`(
            root1: TreeNode?,
            root2: TreeNode?,
            expected: List<Int>
        ) {
            AllElementsInTwoBinarySearchTreesUsingInorderTraversalWithStack.test(root1, root2, expected)
        }
    }

    private fun AllElementsInTwoBinarySearchTrees.test(root1: TreeNode?, root2: TreeNode?, expected: List<Int>) {
        val actual = getAllElements(root1, root2)
        assertEquals(expected, actual)
    }
}