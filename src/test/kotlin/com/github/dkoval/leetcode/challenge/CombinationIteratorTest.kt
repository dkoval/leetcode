package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CombinationIteratorTest {

    @Test
    fun `should validate solution`() {
        val iterator = CombinationIterator("abc", 2) // creates the iterator.
        assertEquals("ab", iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals("ac", iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals("bc", iterator.next())
        assertFalse(iterator.hasNext())
    }
}