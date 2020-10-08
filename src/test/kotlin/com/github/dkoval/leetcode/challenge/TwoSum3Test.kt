package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class TwoSum3Test {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.Add(1),
                    Command.Add(3),
                    Command.Add(5),
                    Command.Find(4, true),
                    Command.Find(7, false)
                )
            ),
            Arguments.of(
                listOf(
                    Command.Add(1),
                    Command.Add(-1),
                    Command.Find(0, true)
                )
            )
        )
    }

    sealed class Command {
        class Add(val number: Int) : Command()
        class Find(val number: Int, val expected: Boolean) : Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands: List<Command>) {
        val solution = TwoSum3()
        for (command in commands) {
            when(command) {
                is Command.Add -> solution.add(command.number)
                is Command.Find -> assertEquals(command.expected, solution.find(command.number), "Failed on find(${command.number})")
            }
        }
    }
}