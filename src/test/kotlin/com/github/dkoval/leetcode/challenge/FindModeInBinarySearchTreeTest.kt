package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.FindModeInBinarySearchTree.FindModeInBinarySearchTreeRev1
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindModeInBinarySearchTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        left = TreeNode(2)
                    }
                },
                intArrayOf(2)
            ),
            Arguments.of(
                TreeNode(0),
                intArrayOf(0)
            )
        )
    }

    @Nested
    inner class FindModeInBinarySearchTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the modes of a BST`(root: TreeNode, expected: IntArray) {
            FindModeInBinarySearchTreeRev1().test(root, expected)
        }
    }
}

private fun FindModeInBinarySearchTree.test(root: TreeNode, expected: IntArray) {
    val actual = findMode(root)
    assertArrayEquals(expected, actual)
}
