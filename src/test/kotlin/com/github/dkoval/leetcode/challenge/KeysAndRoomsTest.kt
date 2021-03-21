package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class KeysAndRoomsTest {

    companion object {
        @JvmStatic
        fun input(): List<Arguments> = listOf(
            Arguments.of(
                listOf(
                    listOf(1),
                    listOf(2),
                    listOf(3),
                    listOf()
                ),
                // We start in room 0, and pick up key 1.
                // We then go to room 1, and pick up key 2.
                // We then go to room 2, and pick up key 3.
                // We then go to room 3.
                true
            ),
            Arguments.of(
                listOf(
                    listOf(1, 3),
                    listOf(3, 0, 1),
                    listOf(2),
                    listOf(0)
                ),
                // We can't enter the room with number 2.
                false
            )
        )
    }

    @ParameterizedTest
    @MethodSource("input")
    fun `should check if you can enter every room`(rooms: List<List<Int>>, expected: Boolean) {
        val actual = KeysAndRooms().canVisitAllRooms(rooms)
        assertEquals(expected, actual)
    }
}