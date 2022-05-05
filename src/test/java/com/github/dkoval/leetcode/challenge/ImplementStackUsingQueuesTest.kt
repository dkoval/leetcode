package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.ImplementStackUsingQueues.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ImplementStackUsingQueuesTest {

    class InputArgumentsProvider : ArgumentsProvider {

        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Command.Push(1),
                    Command.Push(2),
                    Command.Top(2),
                    Command.Pop(2),
                    Command.Empty(false)
                )
            )
        )
    }

    sealed class Command {
        data class Push(val x: Int) : Command()
        data class Pop(val expected: Int): Command()
        data class Top(val expected: Int): Command()
        data class Empty(val expected: Boolean): Command()
    }

    @Nested
    inner class ImplementStackUsingTwoQueuesVer1Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            ImplementStackUsingTwoQueuesVer1().test(commands)
        }
    }

    @Nested
    inner class ImplementStackUsingTwoQueuesVer2Test {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            ImplementStackUsingTwoQueuesVer2().test(commands)
        }
    }

    @Nested
    inner class ImplementStackUsingOneQueueTest {

        @ParameterizedTest
        @ArgumentsSource(InputArgumentsProvider::class)
        fun `should validate data structure design`(commands: List<Command>) {
            ImplementStackUsingOneQueue().test(commands)
        }
    }

    private fun ImplementStackUsingQueues.test(commands: List<Command>) {
        for (command in commands) {
            when (command) {
                is Command.Push -> push(command.x)
                is Command.Pop -> assertEquals(command.expected, pop())
                is Command.Top -> assertEquals(command.expected, top())
                is Command.Empty -> assertEquals(command.expected, empty())
            }
        }
    }
}