package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.problems.ClosestBinarySearchTreeValue.ClosestBinarySearchTreeValueIter
import com.github.dkoval.leetcode.problems.ClosestBinarySearchTreeValue.ClosestBinarySearchTreeValueRecursive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ClosestBinarySearchTreeValueTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(5)
                },
                3.714286,
                4
            )
        )
    }

    @Nested
    inner class ClosestBinarySearchTreeValueIterTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the value in the BST that is closest to the target`(root: TreeNode, target: Double, expected: Int) {
            ClosestBinarySearchTreeValueIter().test(root, target, expected)
        }
    }

    @Nested
    inner class ClosestBinarySearchTreeValueRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the value in the BST that is closest to the target`(root: TreeNode, target: Double, expected: Int) {
            ClosestBinarySearchTreeValueRecursive().test(root, target, expected)
        }
    }

    private fun ClosestBinarySearchTreeValue.test(root: TreeNode, target: Double, expected: Int) {
        val actual = closestValue(root, target)
        assertEquals(expected, actual)
    }
}