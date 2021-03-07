package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DesignHashMap.MyHashMap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class DesignHashMapTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    Command.Put(1, 1),
                    Command.Put(2, 2),
                    Command.Get(1, 1),
                    Command.Get(3, -1),
                    Command.Put(2, 1),
                    Command.Get(2, 1),
                    Command.Remove(2),
                    Command.Get(2, -1)
                )
            )
        )
    }

    sealed class Command {
        class Put(val key: Int, val value: Int) : Command()
        class Get(val key: Int, val expected: Int): Command()
        class Remove(val key: Int): Command()
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should validate data structure design`(commands: List<Command>) {
        val hashMap = MyHashMap()
        for (command in commands) {
            when (command) {
                is Command.Put -> hashMap.put(command.key, command.value)
                is Command.Get -> assertEquals(command.expected, hashMap.get(command.key))
                is Command.Remove -> hashMap.remove(command.key)
            }
        }
    }
}