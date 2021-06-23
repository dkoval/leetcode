package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ReverseLinkedList2Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                2,
                4,
                listOf(1, 4, 3, 2, 5)
            ),
            Arguments.of(
                ListNode(5),
                1,
                1,
                listOf(5)
            ),
            Arguments.of(
                ListNode(3).apply {
                    next = ListNode(5)
                },
                1,
                2,
                listOf(5, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should reverse the nodes of the list from position left to position right, and return the reversed list`(
        head: ListNode,
        left: Int,
        right: Int,
        expected: List<Int>
    ) {
        val actual = ReverseLinkedList2().reverseBetween(head, left, right)
        assertThat(actual.toList()).containsExactlyElementsOf(expected)
    }
}