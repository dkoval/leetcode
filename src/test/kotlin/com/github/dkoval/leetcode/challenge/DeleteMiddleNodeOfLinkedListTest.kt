package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.DeleteMiddleNodeOfLinkedList.DeleteMiddleNodeOfLinkedListRev1
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DeleteMiddleNodeOfLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(7).apply {
                                next = ListNode(1).apply {
                                    next = ListNode(2).apply {
                                        next = ListNode(6)
                                    }
                                }
                            }
                        }
                    }
                },
                listOf(1, 3, 4, 1, 2, 6)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
                listOf(1, 2, 4)
            ),
            Arguments.of(
                ListNode(2).apply {
                    next = ListNode(1)
                },
                listOf(2)
            )
        )
    }

    @Nested
    inner class DeleteMiddleNodeOfLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should delete the middle node, and return the head of the modified linked list`(
            head: ListNode,
            expected: List<Int>
        ) {
            DeleteMiddleNodeOfLinkedListRev1().test(head, expected)
        }
    }

    private fun DeleteMiddleNodeOfLinkedList.test(head: ListNode, expected: List<Int>) {
        val actual = deleteMiddle(head)
        assertEquals(expected, actual.dump())
    }
}