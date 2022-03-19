package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.CombinationIterator.CombinationIteratorRecursively
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CombinationIteratorTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abc",
                2,
                listOf(
                    Command.Next("ab"),
                    Command.HasNext(true),
                    Command.Next("ac"),
                    Command.HasNext(true),
                    Command.Next("bc"),
                    Command.HasNext(false)
                )
            ),
            Arguments.of(
                "bvwz",
                2,
                listOf<Command>(
                    Command.HasNext(true),
                    Command.HasNext(true),
                    Command.Next("bv"),
                    Command.Next("bw"),
                    Command.HasNext(true),
                    Command.HasNext(true),
                    Command.Next("bz"),
                    Command.HasNext(true),
                    Command.HasNext(true),
                    Command.HasNext(true)
                )
            )
        )
    }

    sealed class Command {
        class HasNext(val expected: Boolean) : Command()
        class Next(val expected: String) : Command()
    }

    @Nested
    inner class CombinationIteratorRecursivelyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(chars: String, length: Int, commands: List<Command>) {
            CombinationIteratorRecursively(chars, length).test(commands)
        }
    }

    @Nested
    inner class CombinationIteratorIterativelyTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(chars: String, length: Int, commands: List<Command>) {
            CombinationIteratorIteratively(chars, length).test(commands)
        }
    }

    private fun CombinationIterator.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.HasNext -> assertEquals(command.expected, hasNext())
                is Command.Next -> assertEquals(command.expected, next())
            }
        }
    }
}