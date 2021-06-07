package com.github.dkoval.leetcode.interview.design

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinStackTest {

    @Test
    fun `verify implementation`() {
        val stack = MinStack()
        stack.push(-2)
        stack.push(0)
        stack.push(-3)
        assertEquals(-3, stack.min)

        stack.pop()
        assertEquals(0, stack.top())
        assertEquals(-2, stack.min)
    }
}