package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FlattenMultilevelDoublyLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                Node(1).also { n1 ->
                    n1.next = Node(2).also { n2 ->
                        n2.prev = n1
                        n2.next = Node(3).also { n3 ->
                            n3.prev = n2
                            n3.next = Node(4).also { n4 ->
                                n4.next = Node(5).also { n5 ->
                                    n5.prev = n4
                                    n5.next = Node(6).also { n6 ->
                                        n6.prev = n5
                                    }
                                }
                            }
                            n3.child = Node(7).also { n7 ->
                                n7.next = Node(8).also { n8 ->
                                    n8.prev = n7
                                    n8.next = Node(9).also { n9 ->
                                        n9.prev = n8
                                        n9.next = Node(10).also { n10 ->
                                            n10.prev = n9
                                        }
                                    }
                                    n8.child = Node(11).also { n11 ->
                                        n11.next = Node(12).also { n12 ->
                                            n12.prev = n11
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6)
            ),
            Arguments.of(
                null,
                listOf<Int>()
            ),
            Arguments.of(
                Node(1).also { n1 ->
                    n1.child = Node(2).also { n2 ->
                        n2.child = Node(3)
                    }
                },
                listOf(1, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should flatten the list so that all the nodes appear in a single-level, doubly linked list`(
        root: Node?,
        expected: List<Int>
    ) {
        val actual = FlattenMultilevelDoublyLinkedList.flatten(root)
        assertEquals(expected, actual.toList())
    }
}