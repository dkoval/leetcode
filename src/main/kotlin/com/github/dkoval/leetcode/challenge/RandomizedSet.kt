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
    private val values = arrayListOf<Int>()
    private val indexByValue = hashMapOf<Int, Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (exists(`val`)) {
            return false
        }
        values += `val`
        indexByValue[`val`] = values.lastIndex
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!exists(`val`)) {
            return false
        }
        val index = indexByValue[`val`]!!
        val last = values.last()
        // put the last element of `values` at the current index
        values[index] = last
        indexByValue[last] = index
        // O(1) time: remove the last element from `values` list
        values.removeAt(values.lastIndex)
        // O(1) time: remove `val` from `indexByValue` map
        indexByValue.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val index = Random.nextInt(0, values.size)
        return values[index]
    }

    private fun exists(`val`: Int): Boolean = `val` in indexByValue
}