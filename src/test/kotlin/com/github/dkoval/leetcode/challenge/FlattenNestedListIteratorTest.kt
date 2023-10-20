package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.FlattenNestedListIterator.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FlattenNestedListIteratorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    DefaultNestedInteger(listOf(DefaultNestedInteger(1), DefaultNestedInteger(1))),
                    DefaultNestedInteger(2),
                    DefaultNestedInteger(listOf(DefaultNestedInteger(1), DefaultNestedInteger(1)))
                ),
                listOf(1, 1, 2, 1, 1)
            ),
            Arguments.of(
                listOf(
                    DefaultNestedInteger(1),
                    DefaultNestedInteger(
                        listOf(
                            DefaultNestedInteger(4),
                            DefaultNestedInteger(
                                listOf(DefaultNestedInteger(6))
                            )
                        )
                    )
                ),
                listOf(1, 4, 6)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `flatten nested list iterator`(nestedList: List<NestedInteger>, expected: List<Int>) {
        val iter = NestedIterator(nestedList)
        val actual = mutableListOf<Int>()
        while (iter.hasNext()) {
            actual += iter.next()
        }

        assertEquals(expected, actual)
    }
}