package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.InsertIntoBST.InsertIntoBSTRecursive
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class InsertIntoBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7)
                },
                5,
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(7).apply {
                        left = TreeNode(5)
                    }
                }
            ),
            Arguments.of(
                TreeNode(40).apply {
                    left = TreeNode(20).apply {
                        left = TreeNode(10)
                        right = TreeNode(30)
                    }
                    right = TreeNode(60).apply {
                        left = TreeNode(50)
                        right = TreeNode(70)
                    }
                },
                25,
                TreeNode(40).apply {
                    left = TreeNode(20).apply {
                        left = TreeNode(10)
                        right = TreeNode(30).apply {
                            left = TreeNode(25)
                        }
                    }
                    right = TreeNode(60).apply {
                        left = TreeNode(50)
                        right = TreeNode(70)
                    }
                }
            ),
            Arguments.of(
                null,
                42,
                TreeNode(42)
            )
        )
    }

    @Nested
    inner class InsertIntoBSTRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should insert value into BST`(root: TreeNode?, `val` : Int, expected: TreeNode) {
            InsertIntoBSTRecursive().test(root, `val`, expected)
        }
    }

    private fun InsertIntoBST.test(root: TreeNode?, `val` : Int, expected: TreeNode) {
        val actual = insertIntoBST(root, `val`)
        assertTrue(expected.equalsTo(actual))
    }
}