package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.NaryTreeLevelOrderTraversal.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NaryTreeLevelOrderTraversalTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                Node(1).apply {
                    children = listOf(
                        Node(3).apply {
                            children = listOf(
                                Node(5),
                                Node(6)
                            )
                        },
                        Node(2),
                        Node(4)
                    )
                },
                listOf(
                    listOf(1),
                    listOf(3, 2, 4),
                    listOf(5, 6)
                )
            ),
            Arguments.of(
                Node(1).apply {
                    children = listOf(
                        Node(2),
                        Node(3).apply {
                            children = listOf(
                                Node(6),
                                Node(7).apply {
                                    children = listOf(
                                        Node(11).apply {
                                            children = listOf(
                                                Node(14)
                                            )
                                        }
                                    )
                                },
                            )
                        },
                        Node(4).apply {
                            children = listOf(
                                Node(8).apply {
                                    children = listOf(
                                        Node(12)
                                    )
                                }
                            )
                        },
                        Node(5).apply {
                            children = listOf(
                                Node(9).apply {
                                    children = listOf(
                                        Node(13)
                                    )
                                },
                                Node(10),
                            )
                        }
                    )
                },
                listOf(
                    listOf(1),
                    listOf(2, 3, 4, 5),
                    listOf(6, 7, 8, 9, 10),
                    listOf(11, 12, 13),
                    listOf(14)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the level-order traversal of a n-ary tree`(
        root: Node?,
        expected: List<List<Int>>
    ) {
        val actual = NaryTreeLevelOrderTraversal().levelOrder(root)
        assertThat(actual).containsExactlyElementsOf(expected)
    }
}