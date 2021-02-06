package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.BinaryTreeRightSideView.BinaryTreeRightSideViewLevelOrderTraversal
import com.github.dkoval.leetcode.challenge.BinaryTreeRightSideView.BinaryTreeRightSideViewPreorderTraversal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryTreeRightSideViewTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(4)
                    }
                },
                listOf(1, 3, 4)
            )
        )
    }

    @Nested
    inner class BinaryTreeRightSideViewLevelOrderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the values of the nodes of the binary tree right side view`(
            root: TreeNode?,
            expected: List<Int>
        ) {
            BinaryTreeRightSideViewLevelOrderTraversal().test(root, expected)
        }
    }

    @Nested
    inner class BinaryTreeRightSideViewPreorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the values of the nodes of the binary tree right side view`(
            root: TreeNode?,
            expected: List<Int>
        ) {
            BinaryTreeRightSideViewPreorderTraversal().test(root, expected)
        }
    }

    private fun BinaryTreeRightSideView.test(root: TreeNode?, expected: List<Int>) {
        val actual = rightSideView(root)
        assertEquals(expected, actual)
    }
}