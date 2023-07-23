package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.AllPossibleFullBinaryTrees.AllPossibleFullBinaryTreesRev1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class AllPossibleFullBinaryTreesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7,
                listOf(
                    // #1
                    TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0).apply {
                            left = TreeNode(0)
                            right = TreeNode(0).apply {
                                left = TreeNode(0)
                                right = TreeNode(0)
                            }
                        }
                    },
                    // #2
                    TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0).apply {
                            left = TreeNode(0).apply {
                                left = TreeNode(0)
                                right = TreeNode(0)
                            }
                            right = TreeNode(0)
                        }
                    },
                    // #3
                    TreeNode(0).apply {
                        left = TreeNode(0).apply {
                            left = TreeNode(0)
                            right = TreeNode(0)
                        }
                        right = TreeNode(0).apply {
                            left = TreeNode(0)
                            right = TreeNode(0)
                        }
                    },
                    // #4
                    TreeNode(0).apply {
                        left = TreeNode(0).apply {
                            left = TreeNode(0)
                            right = TreeNode(0).apply {
                                left = TreeNode(0)
                                right = TreeNode(0)
                            }
                        }
                        right = TreeNode(0)
                    },
                    // #5
                    TreeNode(0).apply {
                        left = TreeNode(0).apply {
                            left = TreeNode(0).apply {
                                left = TreeNode(0)
                                right = TreeNode(0)
                            }
                            right = TreeNode(0)
                        }
                        right = TreeNode(0)
                    }
                )
            ),
            Arguments.of(
                3,
                listOf(
                    TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0)
                    }
                )
            )
        )
    }

    @Nested
    inner class AllPossibleFullBinaryTreesRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the list of all possible full binary trees in any order`(n: Int, expected: List<TreeNode>) {
            AllPossibleFullBinaryTreesRev1().test(n, expected)
        }
    }
}

private fun AllPossibleFullBinaryTrees.test(n: Int, expected: List<TreeNode>) {
    val actual = allPossibleFBT(n)
    assertThat(actual).containsExactlyInAnyOrderElementsOf(expected)
}
