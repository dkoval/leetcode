package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.problems.DiameterOfBinaryTree.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DiameterOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3)
                },
                3
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                1
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                1
            ),
            Arguments.of(
                TreeNode(1),
                0
            )
        )
    }

    @Nested
    inner class DiameterOfBinaryTreeRecursiveBruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the diameter of the tree`(root: TreeNode, expected: Int) {
            DiameterOfBinaryTreeRecursiveBruteForce().test(root, expected)
        }
    }

    @Nested
    inner class DiameterOfBinaryTreeRecursiveOptimizedRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the diameter of the tree`(root: TreeNode, expected: Int) {
            DiameterOfBinaryTreeRecursiveOptimizedRev1().test(root, expected)
        }
    }

    @Nested
    inner class DiameterOfBinaryTreeRecursiveOptimizedRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the length of the diameter of the tree`(root: TreeNode, expected: Int) {
            DiameterOfBinaryTreeRecursiveOptimizedRev2().test(root, expected)
        }
    }
}

private fun DiameterOfBinaryTree.test(root: TreeNode, expected: Int) {
    val actual = diameterOfBinaryTree(root)
    assertEquals(expected, actual)
}
