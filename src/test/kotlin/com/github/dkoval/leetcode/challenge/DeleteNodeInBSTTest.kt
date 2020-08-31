package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.TreeNode
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteNodeInBSTTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                null,
                -1,
                null
            ),
            Arguments.of(
                TreeNode(1),
                1,
                null
            ),
            Arguments.of(
                TreeNode(1),
                2,
                TreeNode(1)
            ),
            Arguments.of(
                TreeNode(2).apply {
                    left = TreeNode(1)
                },
                1,
                TreeNode(2)
            ),
            Arguments.of(
                TreeNode(2).apply {
                    right = TreeNode(3)
                },
                3,
                TreeNode(2)
            ),
            // case 1: delete a leaf node
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18)
                        right = TreeNode(25)
                    }
                },
                18,
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        right = TreeNode(25)
                    }
                }
            ),
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18)
                        right = TreeNode(25)
                    }
                },
                25,
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18)
                    }
                }
            ),
            // case 2: delete a node with 2 children
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                            right = TreeNode(19)
                        }
                        right = TreeNode(30)
                    }
                },
                10,
                TreeNode(15).apply {
                    left = TreeNode(8).apply {
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                            right = TreeNode(19)
                        }
                        right = TreeNode(30)
                    }
                }
            ),
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                            right = TreeNode(19)
                        }
                        right = TreeNode(30)
                    }
                },
                20,
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(19).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                        }
                        right = TreeNode(30)
                    }
                }
            ),
            // case 3: delete a node with 1 child
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            right = TreeNode(19)
                        }
                        right = TreeNode(25).apply {
                            right = TreeNode(30)
                        }
                    }
                },
                18,
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(19)
                        right = TreeNode(25).apply {
                            right = TreeNode(30)
                        }
                    }
                }
            ),
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                            right = TreeNode(19)
                        }
                        right = TreeNode(25).apply {
                            right = TreeNode(30)
                        }
                    }
                },
                25,
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18).apply {
                            left = TreeNode(16)
                            right = TreeNode(19)
                        }
                        right = TreeNode(30)
                    }
                }
            ),
            // extra
            Arguments.of(
                TreeNode(15).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                        right = TreeNode(12)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18)
                        right = TreeNode(25)
                    }
                },
                15,
                TreeNode(12).apply {
                    left = TreeNode(10).apply {
                        left = TreeNode(8)
                    }
                    right = TreeNode(20).apply {
                        left = TreeNode(18)
                        right = TreeNode(25)
                    }
                }
            )
        )
    }

    @Nested
    inner class DeleteNodeInBSTCaseByCaseTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete node in a BST`(root: TreeNode?, key: Int, expected: TreeNode?) {
            DeleteNodeInBSTCaseByCase.test(root, key, expected)
        }
    }

    @Nested
    inner class DeleteNodeInBSTRecursiveTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete node in a BST`(root: TreeNode?, key: Int, expected: TreeNode?) {
            DeleteNodeInBSTRecursive.test(root, key, expected)
        }
    }

    private fun DeleteNodeInBST.test(root: TreeNode?, key: Int, expected: TreeNode?) {
        val actual = deleteNode(root, key)
        assertTrue(actual.equalsTo(expected))
    }
}