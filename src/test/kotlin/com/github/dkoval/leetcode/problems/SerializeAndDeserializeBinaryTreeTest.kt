package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import com.github.dkoval.leetcode.problems.SerializeAndDeserializeBinaryTree.SerializeAndDeserializeBinaryTreeWithPreorderTraversal
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SerializeAndDeserializeBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3).apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                }
            ),
            Arguments.of(
                null
            ),
            Arguments.of(
                TreeNode(1)
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                }
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2)
                }
            )
        )
    }

    @Nested
    inner class SerializeAndDeserializeBinaryTreeWithPreorderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should serialize and deserialize binary tree`(root: TreeNode?) {
            SerializeAndDeserializeBinaryTreeWithPreorderTraversal().test(root)
        }
    }

    private fun SerializeAndDeserializeBinaryTree.Codec.test(root: TreeNode?) {
        val data = serialize(root)
        val actual = deserialize(data)
        assertTrue(actual.equalsTo(root))
    }
}