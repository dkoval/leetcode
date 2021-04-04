package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.challenge.DesignCircularQueue.MyCircularQueue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class DesignCircularQueueTest {

    @Test
    fun `verify implementation`() {
        val myCircularQueue = MyCircularQueue(3)

        myCircularQueue.enQueue(1).also { assertTrue(it) }
        myCircularQueue.enQueue(2).also { assertTrue(it) }
        myCircularQueue.enQueue(3).also { assertTrue(it) }
        myCircularQueue.enQueue(4).also { assertFalse(it) }

        myCircularQueue.Rear().also { assertEquals(3, it) }
        myCircularQueue.isFull.also { assertTrue(it) }

        myCircularQueue.deQueue().also { assertTrue(it) }
        myCircularQueue.enQueue(4).also { assertTrue(it) }
        myCircularQueue.Rear().also { assertEquals(4, it) }
    }
}