package com.github.dkoval.leetcode.challenge

import java.util.*

// Complexity: time - O(N), space - O(N)
object SortArrayByParityNaive: SortArrayByParity {

    override fun sortArrayByParity(nums: IntArray): IntArray {
        val evens: Queue<Int> = ArrayDeque()
        val odds: Queue<Int> = ArrayDeque()
        for (a in nums) {
            if (a % 2 == 0) {
                evens.add(a)
            } else {
                odds.add(a)
            }
        }

        var i = 0
        while (!evens.isEmpty() || !odds.isEmpty()) {
            nums[i++] = if (!evens.isEmpty()) evens.poll() else odds.poll()
        }
        return nums
    }
}

// Complexity: time - O(N), space - O(1)
object SortArrayByParityInplaceRev2: SortArrayByParity {

    override fun sortArrayByParity(nums: IntArray): IntArray {
        var writeIdx = 0 // points to the next vacant position of the `even` part
        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                nums.swap(writeIdx, i)
                writeIdx++
            }
        }
        return nums
    }

    private fun IntArray.swap(i: Int, j: Int) {
        if (i != j) {
            val tmp = this[i]
            this[i] = this[j]
            this[j] = tmp
        }
    }
}