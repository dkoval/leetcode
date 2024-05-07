package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.DoubleNumberRepresentedAsLinkedList.DoubleNumberRepresentedAsLinkedListRev1
import com.github.dkoval.leetcode.equalsTo
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DoubleNumberRepresentedAsLinkedListTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(conext: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode.headOf(1, 8, 9),
                ListNode.headOf(3, 7, 8)
            ),
            Arguments.of(
                ListNode.headOf(9, 9, 9),
                ListNode.headOf(1, 9, 9, 8)
            )
        )
    }

    @Nested
    inner class DoubleNumberRepresentedAsLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return the head of the linked list after doubling it`(head: ListNode, expected: ListNode) {
            DoubleNumberRepresentedAsLinkedListRev1().test(head, expected)
        }
    }
}

private fun DoubleNumberRepresentedAsLinkedList.test(head: ListNode, expected: ListNode) {
    assertTrue {
        val actual = doubleIt(head)
        actual.equalsTo(expected)
    }
}
