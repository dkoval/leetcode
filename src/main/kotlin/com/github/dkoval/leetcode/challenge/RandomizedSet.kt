package com.github.dkoval.leetcode.challenge

import kotlin.random.Random

/**
 * [Insert Delete GetRandom O(1)](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * - insert(val): Inserts an item val to the set if not already present.
 * - remove(val): Removes an item val from the set if present.
 * - getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
class RandomizedSet {
    private val values = ArrayList<Int>()
    private val indexByValue = HashMap<Int, Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        val exists = indexByValue.containsKey(`val`)
        if (exists) {
            return false
        }
        values.add(`val`)
        indexByValue[`val`] = values.lastIndex
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        val index = indexByValue[`val`] ?: return false
        values[index] = values.last()
        indexByValue[values[index]] = index
        values.removeAt(values.lastIndex)
        indexByValue.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val index = Random.nextInt(0, values.size)
        return values[index]
    }
}