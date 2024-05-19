package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.DistributeCoinsInBinaryTree.DistributeCoinsInBinaryTreeRev1
import com.github.dkoval.leetcode.challenge.DistributeCoinsInBinaryTree.DistributeCoinsInBinaryTreeRev2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DistributeCoinsInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(0)
                    right = TreeNode(0)
                },
                2
            ),
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(3)
                    right = TreeNode(0)
                },
                3
            )
        )
    }

    @Nested
    inner class DistributeCoinsInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the minimum number of moves required to make every node have exactly one coin`(
            root: TreeNode,
            expected: Int
        ) {
            DistributeCoinsInBinaryTreeRev1().test(root, expected)
        }
    }

    @Nested
    inner class DistributeCoinsInBinaryTreeRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should Return the minimum number of moves required to make every node have exactly one coin`(
            root: TreeNode,
            expected: Int
        ) {
            DistributeCoinsInBinaryTreeRev2().test(root, expected)
        }
    }
}

private fun DistributeCoinsInBinaryTree.test(root: TreeNode, expected: Int) {
    val actual = distributeCoins(root)
    assertEquals(expected, actual)
}
