package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SplitLinkedListInPartsTest {

    companion object {
        @JvmStatic
        fun input() = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                5,
                listOf(
                    listOf(1),
                    listOf(2),
                    listOf(3),
                    listOf(),
                    listOf()
                )
            ),
            Arguments.of(
                null,
                3,
                listOf(
                    listOf<Int>(),
                    listOf(),
                    listOf()
                )
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5).apply {
                                    next = ListNode(6).apply {
                                        next = ListNode(7).apply {
                                            next = ListNode(8).apply {
                                                next = ListNode(9).apply {
                                                    next = ListNode(10)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                3,
                listOf(
                    listOf(1, 2, 3, 4),
                    listOf(5, 6, 7),
                    listOf(8, 9, 10)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return an array of the k parts`(head: ListNode?, k: Int, expected: Iterable<List<Int>>) {
        val actual = SplitLinkedListInParts().splitListToParts(head, k)
        assertThat(actual.map { bucket -> bucket.toList() }).containsExactlyElementsOf(expected)
    }
}