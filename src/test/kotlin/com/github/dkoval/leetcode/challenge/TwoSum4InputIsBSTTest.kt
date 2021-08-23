package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.TwoSum4InputIsBST.TwoSum4InputIsBSTUsingInorderWithBinarySearch
import com.github.dkoval.leetcode.challenge.TwoSum4InputIsBST.TwoSum4InputIsBSTUsingInorderWithHashSet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class TwoSum4InputIsBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2)
                        right = TreeNode(4)
                    }
                    right = TreeNode(6).apply {
                        right = TreeNode(7)
                    }
                },
                9,
                true
            ),
            Arguments.of(
                TreeNode(5).apply {
                    left = TreeNode(3).apply {
                        left = TreeNode(2)
                        right = TreeNode(4)
                    }
                    right = TreeNode(6).apply {
                        right = TreeNode(7)
                    }
                },
                28,
                false
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                4,
                true
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                1,
                false
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                },
                3,
                true
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(-4)
                        right = TreeNode(1)
                    }
                    right = TreeNode(3)
                },
                -1,
                true
            )
        )
    }

    @Nested
    inner class TwoSum4InputIsBSTUsingInorderWithHashSetTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should true if there exist two elements in the BST such that their sum is equal to k`(
            root: TreeNode,
            k: Int,
            expected: Boolean
        ) {
            TwoSum4InputIsBSTUsingInorderWithHashSet().test(root, k, expected)
        }
    }

    @Nested
    inner class TwoSum4InputIsBSTUsingInorderWithBinarySearchTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should true if there exist two elements in the BST such that their sum is equal to k`(
            root: TreeNode,
            k: Int,
            expected: Boolean
        ) {
            TwoSum4InputIsBSTUsingInorderWithBinarySearch().test(root, k, expected)
        }
    }

    private fun TwoSum4InputIsBST.test(root: TreeNode, k: Int, expected: Boolean) {
        val actual = findTarget(root, k)
        assertEquals(expected, actual)
    }
}