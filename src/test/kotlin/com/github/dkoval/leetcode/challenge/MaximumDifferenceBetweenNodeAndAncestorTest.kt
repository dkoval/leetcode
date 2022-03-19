package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenNodeAndAncestor.MaximumDifferenceBetweenNodeAndAncestorMaxMinusMin
import com.github.dkoval.leetcode.challenge.MaximumDifferenceBetweenNodeAndAncestor.MaximumDifferenceBetweenNodeAndAncestorPostOrderTraversal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumDifferenceBetweenNodeAndAncestorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(8).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(1)
                        right = TreeNode(6).apply {
                            left = TreeNode(4)
                            right = TreeNode(7)
                        }
                    }
                    right = TreeNode(10).apply {
                        right = TreeNode(14).apply {
                            left = TreeNode(13)
                        }
                    }
                },
                7
            ),
            Arguments.of(
                TreeNode(1).apply {
                    right = TreeNode(2).apply {
                        right = TreeNode(0).apply {
                            left = TreeNode(3)
                        }
                    }
                },
                3
            )
        )
    }

    @Nested
    inner class MaximumDifferenceBetweenNodeAndAncestorPostOrderTraversalTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximum difference between node and ancestor`(root: TreeNode, expected: Int) {
            MaximumDifferenceBetweenNodeAndAncestorPostOrderTraversal().test(root, expected)
        }
    }

    @Nested
    inner class MaximumDifferenceBetweenNodeAndAncestorMaxMinusMinTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should maximum difference between node and ancestor`(root: TreeNode, expected: Int) {
            MaximumDifferenceBetweenNodeAndAncestorMaxMinusMin().test(root, expected)
        }
    }

    private fun MaximumDifferenceBetweenNodeAndAncestor.test(root: TreeNode, expected: Int) {
        val actual = maxAncestorDiff(root)
        assertEquals(expected, actual)
    }
}