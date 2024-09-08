package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.SplitLinkedListInParts.SplitLinkedListInPartsRev1
import com.github.dkoval.leetcode.challenge.SplitLinkedListInParts.SplitLinkedListInPartsRev2
import com.github.dkoval.leetcode.challenge.SplitLinkedListInParts.SplitLinkedListInPartsRev3
import com.github.dkoval.leetcode.dump
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class SplitLinkedListInPartsTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
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
            ),
            Arguments.of(
                null,
                3,
                listOf(
                    listOf<Int>(),
                    listOf(),
                    listOf()
                )
            )
        )
    }

    @Nested
    inner class SplitLinkedListInPartsRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the k parts`(head: ListNode?, k: Int, expected: Iterable<List<Int>>) {
            SplitLinkedListInPartsRev1().test(head, k, expected)
        }
    }

    @Nested
    inner class SplitLinkedListInPartsRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the k parts`(head: ListNode?, k: Int, expected: Iterable<List<Int>>) {
            SplitLinkedListInPartsRev2().test(head, k, expected)
        }
    }

    @Nested
    inner class SplitLinkedListInPartsRev3Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should return an array of the k parts`(head: ListNode?, k: Int, expected: Iterable<List<Int>>) {
            SplitLinkedListInPartsRev3().test(head, k, expected)
        }
    }
}

private fun SplitLinkedListInParts.test(head: ListNode?, k: Int, expected: Iterable<List<Int>>) {
    val actual = splitListToParts(head, k)
    assertThat(actual.map { part -> part.dump() }).containsExactlyElementsOf(expected)
}
