package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.challenge.LinkedListInBinaryTree.LinkedListInBinaryTreeRev1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LinkedListInBinaryTreeTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(4, 2, 8),
                TreeNode(1) {
                    left = TreeNode(4) {
                        right = TreeNode(2) {
                            left = TreeNode(1)
                        }
                    }
                    right = TreeNode(4) {
                        left = TreeNode(2) {
                            left = TreeNode(6)
                            right = TreeNode(8) {
                                left = TreeNode(1)
                                right = TreeNode(3)
                            }
                        }
                    }
                },
                true
            ),
            Arguments.of(
                ListNode.headOf(1, 4, 2, 6),
                TreeNode(1) {
                    left = TreeNode(4) {
                        right = TreeNode(2) {
                            left = TreeNode(1)
                        }
                    }
                    right = TreeNode(4) {
                        left = TreeNode(2) {
                            left = TreeNode(6)
                            right = TreeNode(8) {
                                left = TreeNode(1)
                                right = TreeNode(3)
                            }
                        }
                    }
                },
                true
            ),
            Arguments.of(
                ListNode.headOf(1, 4, 2, 6, 8),
                TreeNode(1) {
                    left = TreeNode(4) {
                        right = TreeNode(2) {
                            left = TreeNode(1)
                        }
                    }
                    right = TreeNode(4) {
                        left = TreeNode(2) {
                            left = TreeNode(6)
                            right = TreeNode(8) {
                                left = TreeNode(1)
                                right = TreeNode(3)
                            }
                        }
                    }
                },
                false
            )
        )
    }

    @Nested
    inner class LinkedListInBinaryTreeRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should check if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree`(
            head: ListNode,
            root: TreeNode,
            expected: Boolean
        ) {
            LinkedListInBinaryTreeRev1().test(head, root, expected)
        }
    }
}

fun LinkedListInBinaryTree.test(head: ListNode, root: TreeNode, expected: Boolean) {
    val actual = isSubPath(head, root)
    assertEquals(expected, actual)
}
