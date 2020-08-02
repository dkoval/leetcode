package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 * - add(value): Insert a value into the HashSet.
 * - contains(value) : Return whether the value exists in the HashSet or not.
 * - remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 */
class MyHashSet {
    private val buckets = Array<MutableList<Int>>(16) { LinkedList() }

    fun add(key: Int) {
        val elements = findBucket(key)
        if (!elements.contains(key)) {
            elements.add(key)
        }
    }

    fun remove(key: Int) {
        val elements = findBucket(key)
        elements.remove(key)
    }

    fun contains(key: Int): Boolean {
        val elements = findBucket(key)
        return elements.contains(key)
    }

    private fun findBucket(key: Int): MutableList<Int> {
        val idx = key % buckets.size
        return buckets[idx]
    }
}