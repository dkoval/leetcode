package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ConvertBinaryNumberInLinkedListToIntegerTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(0).apply {
                        next = ListNode(1)
                    }
                },
                5
            ),
            Arguments.of(
                ListNode(0),
                0
            ),
            Arguments.of(
                ListNode(1),
                1
            ),
            Arguments.of(
                ListNode(0).apply {
                    next = ListNode(0)
                },
                0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should return the decimal value of the number in the linked list`(head: ListNode, expected: Int) {
        val actual = ConvertBinaryNumberInLinkedListToInteger().getDecimalValue(head)
        assertEquals(expected, actual)
    }
}