package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.UniqueBinarySearchTrees2.UniqueBinarySearchTrees2Rev1
import com.github.dkoval.leetcode.challenge.UniqueBinarySearchTrees2.UniqueBinarySearchTrees2Rev2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class UniqueBinarySearchTrees2Test {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1,
                listOf(
                    TreeNode(1)
                )
            ),
            Arguments.of(
                3,
                listOf(
                    TreeNode(1) {
                        right = TreeNode(3) {
                            left = TreeNode(2)
                        }
                    },
                    TreeNode(1) {
                        right = TreeNode(2) {
                            right = TreeNode(3)
                        }
                    },
                    TreeNode(2) {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    },
                    TreeNode(3) {
                        left = TreeNode(2) {
                            left = TreeNode(1)
                        }
                    },
                    TreeNode(3) {
                        left = TreeNode(1) {
                            right = TreeNode(2)
                        }
                    }
                )
            )
        )
    }

    @Nested
    inner class UniqueBinarySearchTrees2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the structurally unique BSTs`(n: Int, expected: List<TreeNode>) {
            UniqueBinarySearchTrees2Rev1().test(n, expected)
        }
    }

    @Nested
    inner class UniqueBinarySearchTrees2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return all the structurally unique BSTs`(n: Int, expected: List<TreeNode>) {
            UniqueBinarySearchTrees2Rev2().test(n, expected)
        }
    }
}

private fun UniqueBinarySearchTrees2.test(n: Int, expected: List<TreeNode>) {
    val actual = generateTrees(n)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
