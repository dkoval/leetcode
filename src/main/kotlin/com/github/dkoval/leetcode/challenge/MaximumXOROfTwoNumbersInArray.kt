package com.github.dkoval.leetcode.challenge

/**
 * [Maximum XOR of Two Numbers in an Array](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/)
 *
 * Given a non-empty array of numbers, ```a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31```.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 */
interface MaximumXOROfTwoNumbersInArray {

    fun findMaximumXOR(nums: IntArray): Int
}

object MaximumXOROfTwoNumbersInArrayBruteForce : MaximumXOROfTwoNumbersInArray {

    // Time complexity: O(N^2)
    override fun findMaximumXOR(nums: IntArray): Int {
        var result = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                result = maxOf(result, nums[i] xor nums[j])
            }
        }
        return result
    }
}

// Time complexity: O(N), space complexity: O(N)
object MaximumXOROfTwoNumbersInArrayUsingTrie : MaximumXOROfTwoNumbersInArray {

    private class Trie {

        class Node {
            // next[0] and next[1] deal with binary values 0 and 1 respectively
            val next = Array<Node?>(2) { null }
        }

        private val root = Node()

        fun insert(x: Int) {
            // While inserting a number, we look into each bit of that number, starting from MSB.
            // If that bit is 1 then we move on right side else, if the bit is 0, we move on the left side.
            var curr = root
            for (i in 31 downTo 0) {
                val bit = (x shr i) and 1 // get i-th bit of num
                if (curr.next[bit] == null) {
                    curr.next[bit] = Node()
                }
                curr = curr.next[bit]!!
            }
        }

        fun findMaxXorWith(x: Int): Int {
            // The result of XOR is max when the bits are not same.
            // For each bit of x, starting from MSB, we try to maximise the XOR.
            // If the bit is 1, then we need a 0 to get the max XOR.
            // Similarly, if the bit is 0, then we need a 1.
            var cur = root
            var result = 0
            for (i in 31 downTo 0) {
                val bit = (x shr i) and 1 // get i-th bit of num
                val flippedBit = bit xor 1 // 0 -> 1, 1 -> 0
                if (cur.next[flippedBit] != null) {
                    result = result or (1 shl i)
                    cur = cur.next[flippedBit]!!
                } else {
                    cur = cur.next[bit]!!
                }
            }
            return result
        }
    }

    // Resource: https://www.ritambhara.in/maximum-xor-value-of-two-elements/
    override fun findMaximumXOR(nums: IntArray): Int {
        var result = 0
        val t = Trie()
        for (num in nums) {
            t.insert(num)
        }
        for (num in nums) {
            result = maxOf(result, t.findMaxXorWith(num))
        }
        return result
    }
}