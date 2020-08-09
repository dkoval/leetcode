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

internal class PathSum3Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            // Return 3. The paths that sum to 8 are:
            // 5 -> 3
            // 5 -> 2 -> 1
            // -3 -> 11
            Arguments.of(
                TreeNode(10).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(3)
                            right = TreeNode(-2)
                        }
                        right = TreeNode(2).apply {
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(-3).apply {
                        right = TreeNode(11)
                    }
                },
                8,
                3
            )
        )
    }

    @Nested
    inner class PathSum3BruteForceTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the number of paths that sum to a given value`(root: TreeNode?, sum: Int, expected: Int) {
            PathSum3BruteForce.test(root, sum, expected)
        }
    }

    @Nested
    inner class PathSum3HashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should find the number of paths that sum to a given value`(root: TreeNode?, sum: Int, expected: Int) {
            PathSum3HashMap.test(root, sum, expected)
        }
    }

    private fun PathSum3.test(root: TreeNode?, sum: Int, expected: Int) {
        val actual = pathSum(root, sum)
        assertEquals(expected, actual)
    }
}