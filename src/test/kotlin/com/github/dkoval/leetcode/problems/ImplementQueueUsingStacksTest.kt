package com.github.dkoval.leetcode.problems

import com.github.dkoval.leetcode.problems.ImplementQueueUsingStacks.MyQueue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ImplementQueueUsingStacksTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.Push(1),
                    Command.Push(2),
                    Command.Peek(1),
                    Command.Pop(1),
                    Command.Empty(false)
                )
            )
        )
    }

    sealed class Command {
        data class Push(val x : Int) : Command()
        data class Pop(val expected: Int) : Command()
        data class Peek(val expected: Int) : Command()
        data class Empty(val expected: Boolean) : Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands : List<Command>) {
        val q = MyQueue()
        for (command in commands) {
            when (command) {
                is Command.Push -> q.push(command.x)
                is Command.Pop -> assertEquals(command.expected, q.pop())
                is Command.Peek -> assertEquals(command.expected, q.peek())
                is Command.Empty -> assertEquals(command.expected, q.empty())
            }
        }
    }
}