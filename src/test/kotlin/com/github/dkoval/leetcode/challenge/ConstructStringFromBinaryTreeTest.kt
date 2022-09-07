package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.ConstructStringFromBinaryTree.ConstructStringFromBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ConstructStringFromBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                    }
                    right = TreeNode(3)
                },
                "1(2(4))(3)"
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(4)
                    }
                    right = TreeNode(3)
                },
                "1(2()(4))(3)"
            )
        )
    }

    @Nested
    inner class ConstructStringFromBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal `(
            root: TreeNode,
            expected: String
        ) {
            ConstructStringFromBinaryTreeRev1().test(root, expected)
        }
    }

    private fun ConstructStringFromBinaryTree.test(root: TreeNode, expected: String) {
        val actual = tree2str(root)
        assertEquals(expected, actual)
    }
}