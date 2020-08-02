package com.github.dkoval.leetcode.challenge

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MyHashSetTest {

    @Test
    fun `verify solution`() {
        val hashSet = MyHashSet()
        hashSet.add(1)
        hashSet.add(2)
        assertTrue(hashSet.contains(1))
        assertFalse(hashSet.contains(3))

        hashSet.add(2)
        assertTrue(hashSet.contains(2))

        hashSet.remove(2)
        assertFalse(hashSet.contains(2))
    }
}