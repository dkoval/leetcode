package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SameTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(3)
                },
                true
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                },
                TreeNode(1).apply {
                    right = TreeNode(2)
                },
                false
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2)
                    right = TreeNode(1)
                },
                TreeNode(1).apply {
                    left = TreeNode(1)
                    right = TreeNode(2)
                },
                false
            )
        )
    }

    @Nested
    inner class SameTreeRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if two binary trees are the same`(p: TreeNode?, q: TreeNode?, expected: Boolean) {
            SameTreeRecursive.test(p, q, expected)
        }
    }

    @Nested
    inner class SameTreeIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if two binary trees are the same`(p: TreeNode?, q: TreeNode?, expected: Boolean) {
            SameTreeIter.test(p, q, expected)
        }
    }

    private fun SameTree.test(p: TreeNode?, q: TreeNode?, expected: Boolean) {
        val actual = isSameTree(p, q)
        assertEquals(expected, actual)
    }
}