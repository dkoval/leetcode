package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.MaximumFrequencyStack.FreqStack
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaximumFrequencyStackTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
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

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands: List<Command>) {
        val freqStack = FreqStack()
        for (command in commands) {
            when (command) {
                is Command.Push -> freqStack.push(command.x)
                is Command.Pop -> assertEquals(command.expected, freqStack.pop())
            }
        }
    }
}