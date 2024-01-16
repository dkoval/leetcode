package com.github.dkoval.leetcode.challenge

import kotlin.random.Random

/**
 * [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)
 *
 * Implement the RandomizedSet class:
 *
 * - RandomizedSet() Initializes the RandomizedSet object.
 * - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * - bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Constraints:
 *
 * - -2^31 <= val <= 2^31 - 1
 * - At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * - There will be at least one element in the data structure when getRandom is called.
 */
class RandomizedSet {
    private val nums = arrayListOf<Int>()
    private val numToIndex = hashMapOf<Int, Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (`val` in numToIndex) {
            return false
        }

        nums += `val`
        numToIndex[`val`] = nums.lastIndex
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (`val` !in numToIndex) {
            return false
        }

        val currIndex = numToIndex[`val`]!!
        val lastNum = nums.last()

        // put the last element of `nums` at the current index
        nums[currIndex] = lastNum
        numToIndex[lastNum] = currIndex

        // O(1) time: remove the last element from `nums` list
        // O(1) time: remove `val` from `numToIndex` map
        nums.removeAt(nums.lastIndex)
        numToIndex.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val index = Random.nextInt(0, nums.size)
        return nums[index]
    }
}