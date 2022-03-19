package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumFrequencyStack.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class MaximumFrequencyStackTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Command.Push(5),
                    Command.Push(7),
                    Command.Push(5),
                    Command.Push(7),
                    Command.Push(4),
                    Command.Push(5),
                    Command.Pop(5),
                    Command.Pop(7),
                    Command.Pop(5),
                    Command.Pop(4)
                )
            )
        )
    }

    sealed class Command {
        class Push(val x: Int) : Command()
        class Pop(val expected: Int) : Command()
    }

    @Nested
    inner class FreqStackUsingFrequencyStacksTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            FreqStackUsingFrequencyStacks().test(commands)
        }
    }

    @Nested
    inner class FreqStackUsingMaxHeapTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            FreqStackUsingMaxHeap().test(commands)
        }
    }

    private fun FreqStack.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.Push -> push(command.x)
                is Command.Pop -> assertEquals(command.expected, pop())
            }
        }
    }
}