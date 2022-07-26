package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.LowestCommonAncestorOfBinaryTree.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LowestCommonAncestorOfBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2).apply {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(8)
                    }
                },
                5,
                1,
                3
            ),
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(6)
                        right = TreeNode(2).apply {
                            left = TreeNode(7)
                            right = TreeNode(4)
                        }
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(8)
                    }
                },
                5,
                4,
                5
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                1,
                2,
                1
            )
        )
    }

    @Nested
    inner class LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the lowest common ancestor of two given nodes in the tree`(
            root: TreeNode,
            p: Int,
            q: Int,
            expected: Int
        ) {
            LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev1().test(root, p, q, expected)
        }
    }

    @Nested
    inner class LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the lowest common ancestor of two given nodes in the tree`(
            root: TreeNode,
            p: Int,
            q: Int,
            expected: Int
        ) {
            LowestCommonAncestorOfBinaryTreeUsingListToStorePathRev2().test(root, p, q, expected)
        }
    }

    @Nested
    inner class LowestCommonAncestorOfBinaryTreeUsingDequeToStorePathTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the lowest common ancestor of two given nodes in the tree`(
            root: TreeNode,
            p: Int,
            q: Int,
            expected: Int
        ) {
            LowestCommonAncestorOfBinaryTreeUsingDequeToStorePath().test(root, p, q, expected)
        }
    }

    private fun LowestCommonAncestorOfBinaryTree.test(root: TreeNode, p: Int, q: Int, expected: Int) {
        val actual = lowestCommonAncestor(root, TreeNode(p), TreeNode(q))
        assertEquals(expected, actual.`val`)
    }
}