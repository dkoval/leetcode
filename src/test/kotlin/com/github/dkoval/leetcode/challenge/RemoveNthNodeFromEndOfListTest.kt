package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.RemoveNthNodeFromEndOfList.RemoveNthNodeFromEndOfListRev1
import com.github.dkoval.leetcode.dump
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RemoveNthNodeFromEndOfListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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
                listOf(1, 2, 3, 5)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                1,
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                2,
                listOf(2)
            ),
            Arguments.of(
                ListNode(1),
                1,
                listOf<Int>()
            )
        )
    }

    @Nested
    inner class RemoveNthNodeFromEndOfListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should remove n-th node from the list`(head: ListNode, n: Int, expected: List<Int>) {
            RemoveNthNodeFromEndOfListRev1().test(head, n, expected)
        }
    }
}

private fun RemoveNthNodeFromEndOfList.test(head: ListNode, n: Int, expected: List<Int>) {
    val actual = removeNthFromEnd(head, n)
    assertEquals(expected, actual.dump())
}
