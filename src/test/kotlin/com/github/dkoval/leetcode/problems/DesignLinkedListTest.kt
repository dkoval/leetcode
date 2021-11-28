package com.github.dkoval.leetcode.problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class DesignLinkedListTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.AddAtHead(1),
                    Command.AddAtTail(3),
                    Command.AddAtIndex(1, 2),
                    Command.Get(1, 2),
                    Command.DeleteAtIndex(1),
                    Command.Get(1, 3)
                )
            ),
            Arguments.of(
                listOf(
                    Command.AddAtHead(1),
                    Command.DeleteAtIndex(0)
                )
            )
        )
    }

    sealed class Command {
        class Get(val index: Int, val expected: Int) : Command()
        class AddAtHead(val `val`: Int) : Command()
        class AddAtTail(val `val`: Int) : Command()
        class AddAtIndex(val index: Int, val `val`: Int) : Command()
        class DeleteAtIndex(val index: Int) : Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands: Iterable<Command>) {
        val list = DesignLinkedList.MyLinkedList()
        for (command in commands) {
            when (command) {
                is Command.Get -> assertEquals(command.expected, list.get(command.index))
                is Command.AddAtHead -> list.addAtHead(command.`val`)
                is Command.AddAtTail -> list.addAtTail(command.`val`)
                is Command.AddAtIndex -> list.addAtIndex(command.index, command.`val`)
                is Command.DeleteAtIndex -> list.deleteAtIndex(command.index)
            }
        }
    }
}