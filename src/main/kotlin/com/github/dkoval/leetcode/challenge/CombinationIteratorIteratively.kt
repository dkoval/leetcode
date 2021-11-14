package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Iterator for Combination](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/)
 *
 * Design an Iterator class, which has:
 * - A constructor that takes a string characters of sorted distinct lowercase English letters
 * and a number combinationLength as arguments.
 * - A function next() that returns the next combination of length combinationLength in lexicographical order.
 * - A function hasNext() that returns True if and only if there exists a next combination.
 */
class CombinationIteratorIteratively(characters: String, combinationLength: Int) : CombinationIterator {

    private val iterator = combinationsOf(characters, combinationLength).iterator()

    private fun combinationsOf(characters: String, combinationLength: Int): Iterable<String> {
        val combinations = LinkedList<String>()
        // given N characters, there are 2^N possible combinations in total
        val numCombinations = 1 shl characters.length
        for (num in 1 until numCombinations) {
            var x = num
            var i = characters.lastIndex
            val combination = StringBuilder()
            while (x != 0) {
                if (x and 1 != 0) {
                    combination.append(characters[i])
                }
                i--
                x = x shr 1
            }
            if (combination.length == combinationLength) {
                // store combinations in reverse order of appearance
                // to preserve lexicographical order of next combinations
                combinations.addFirst(combination.reverse().toString())
            }
        }
        return combinations
    }

    override fun next(): String = iterator.next()

    override fun hasNext(): Boolean = iterator.hasNext()
}