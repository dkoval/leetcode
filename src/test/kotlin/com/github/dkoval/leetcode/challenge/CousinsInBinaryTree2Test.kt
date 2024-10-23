package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.CousinsInBinaryTree2.CousinsInBinaryTree2Rev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CousinsInBinaryTree2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(5) {
                    left = TreeNode(4) {
                        left = TreeNode(1)
                        right = TreeNode(10)
                    }
                    right = TreeNode(9) {
                        right = TreeNode(7)
                    }
                },
                TreeNode(0) {
                    left = TreeNode(0) {
                        left = TreeNode(7)
                        right = TreeNode(7)
                    }
                    right = TreeNode(0) {
                        right = TreeNode(11)
                    }
                }
            ),
            Arguments.of(
                TreeNode(3) {
                    left = TreeNode(1)
                    right = TreeNode(2)
                },
                TreeNode(0) {
                    left = TreeNode(0)
                    right = TreeNode(0)
                }
            )
        )
    }

    @Nested
    inner class CousinsInBinaryTree2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should replace the value of each node in the tree with the sum of all its cousins' values`(
            root: TreeNode,
            expected: TreeNode
        ) {
            CousinsInBinaryTree2Rev1().test(root, expected)
        }
    }
}

private fun CousinsInBinaryTree2.test(root: TreeNode, expected: TreeNode) {
    assertTrue { replaceValueInTree(root).equalsTo(expected) }
}
