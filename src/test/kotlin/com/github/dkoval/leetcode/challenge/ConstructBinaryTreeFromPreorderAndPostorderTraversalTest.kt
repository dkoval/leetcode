package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.ConstructBinaryTreeFromPreorderAndPostorderTraversal.ConstructBinaryTreeFromPreorderAndPostorderTraversalRev1
import com.github.dkoval.leetcode.challenge.ConstructBinaryTreeFromPreorderAndPostorderTraversal.ConstructBinaryTreeFromPreorderAndPostorderTraversalRev2
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ConstructBinaryTreeFromPreorderAndPostorderTraversalTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 4, 5, 3, 6, 7),
                intArrayOf(4, 5, 2, 6, 7, 3, 1),
                TreeNode(1) {
                    left = TreeNode(2) {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3) {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                }
            ),
            Arguments.of(
                intArrayOf(1),
                intArrayOf(1),
                TreeNode(1)
            ),
            Arguments.of(
                intArrayOf(2, 1),
                intArrayOf(1, 2),
                TreeNode(2) {
                    left = TreeNode(1)
                }
            )
        )
    }

    @Nested
    inner class ConstructBinaryTreeFromPreorderAndPostorderTraversalRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should construct a binary tree from its preorder and postorder traversal`(
            preorder: IntArray,
            postorder: IntArray,
            expected: TreeNode?
        ) {
            ConstructBinaryTreeFromPreorderAndPostorderTraversalRev1().test(preorder, postorder, expected)
        }
    }

    @Nested
    inner class ConstructBinaryTreeFromPreorderAndPostorderTraversalRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should construct a binary tree from its preorder and postorder traversal`(
            preorder: IntArray,
            postorder: IntArray,
            expected: TreeNode?
        ) {
            ConstructBinaryTreeFromPreorderAndPostorderTraversalRev2().test(preorder, postorder, expected)
        }
    }
}

fun ConstructBinaryTreeFromPreorderAndPostorderTraversal.test(
    preorder: IntArray,
    postorder: IntArray,
    expected: TreeNode?
) {
    val actual = constructFromPrePost(preorder, postorder)
    assertTrue { actual.equalsTo(expected) }
}
