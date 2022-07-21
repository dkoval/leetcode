package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.ReverseLinkedList2.ReverseLinkedList2Rev1
import com.github.dkoval.leetcode.challenge.ReverseLinkedList2.ReverseLinkedList2Rev2
import com.github.dkoval.leetcode.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ReverseLinkedList2Test {

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

    @Nested
    inner class ReverseLinkedList2Rev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse the nodes of the list from position left to position right, and return the reversed list`(
            head: ListNode,
            left: Int,
            right: Int,
            expected: List<Int>
        ) {
            ReverseLinkedList2Rev1().test(head, left, right, expected)
        }
    }

    @Nested
    inner class ReverseLinkedList2Rev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should reverse the nodes of the list from position left to position right, and return the reversed list`(
            head: ListNode,
            left: Int,
            right: Int,
            expected: List<Int>
        ) {
            ReverseLinkedList2Rev2().test(head, left, right, expected)
        }
    }

    private fun ReverseLinkedList2.test(head: ListNode, left: Int, right: Int, expected: List<Int>) {
        val actual = reverseBetween(head, left, right)
        assertThat(actual.toList()).containsExactlyElementsOf(expected)
    }
}