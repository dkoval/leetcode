package com.github.dkoval.leetcode.mock

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.mock.DeleteNodesAndReturnForest.DeleteNodesAndReturnForestRecursiveBottomUp
import com.github.dkoval.leetcode.mock.DeleteNodesAndReturnForest.DeleteNodesAndReturnForestRecursiveBottomUpWithParentRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteNodesAndReturnForestTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(6)
                        right = TreeNode(7)
                    }
                },
                intArrayOf(3, 5),
                listOf(
                    TreeNode(1).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(4)
                        }
                    },
                    TreeNode(6),
                    TreeNode(7)
                )
            )
        )
    }

    @Nested
    inner class DeleteNodesAndReturnForestRecursiveBottomUpTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the roots of the trees in the remaining forest`(
            root: TreeNode,
            nodesToDelete: IntArray,
            expected: List<TreeNode>
        ) {
            DeleteNodesAndReturnForestRecursiveBottomUp().test(root, nodesToDelete, expected)
        }
    }

    @Nested
    inner class DeleteNodesAndReturnForestRecursiveBottomUpWithParentRefTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the roots of the trees in the remaining forest`(
            root: TreeNode,
            nodesToDelete: IntArray,
            expected: List<TreeNode>
        ) {
            DeleteNodesAndReturnForestRecursiveBottomUpWithParentRef().test(root, nodesToDelete, expected)
        }
    }

    private fun DeleteNodesAndReturnForest.test(root: TreeNode, nodesToDelete: IntArray, expected: List<TreeNode>) {
        val actual = delNodes(root, nodesToDelete)
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
    }
}