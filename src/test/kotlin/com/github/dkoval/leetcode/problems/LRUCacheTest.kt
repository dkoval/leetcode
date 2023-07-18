package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.LRUCache.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LRUCacheTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                2,
                listOf(
                    Command.Put(1, 1),
                    Command.Put(2, 2),
                    Command.Get(1, 1),
                    Command.Put(3, 3),
                    Command.Get(2, -1),
                    Command.Put(4, 4),
                    Command.Get(1, -1),
                    Command.Get(3, 3),
                    Command.Get(4, 4),
                )
            )
        )
    }

    sealed class Command {
        data class Put(val key: Int, val value: Int) : Command()
        data class Get(val key: Int, val expected: Int) : Command()
    }

    @Nested
    inner class LRUCacheUsingDoublyLinkedListRev1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(capacity: Int, commands: List<Command>) {
            LRUCacheUsingDoublyLinkedListRev1(capacity).test(commands)
        }
    }

    @Nested
    inner class LRUCacheUsingDoublyLinkedListRev2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(capacity: Int, commands: List<Command>) {
            LRUCacheUsingDoublyLinkedListRev2(capacity).test(commands)
        }
    }

    @Nested
    inner class LRUCacheUsingLinkedHashMapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(capacity: Int, commands: List<Command>) {
            LRUCacheUsingLinkedHashMap(capacity).test(commands)
        }
    }

    private fun LRUCache.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.Put -> put(command.key, command.value)
                is Command.Get -> assertEquals(command.expected, get(command.key))
            }
        }
    }
}