package com.github.dkoval.leetcode.challenge

interface SingleNumber3 {

    fun singleNumber(nums: IntArray): IntArray
}

object NaiveSingleNumber3 : SingleNumber3 {

    override fun singleNumber(nums: IntArray): IntArray {
        val uniqueNums = mutableSetOf<Int>()
        for (num in nums) {
            if (uniqueNums.contains(num)) {
                uniqueNums.remove(num)
            } else {
                uniqueNums.add(num)
            }
        }
        return uniqueNums.toIntArray()
    }
}

object SmartSingleNumber3 : SingleNumber3 {

    // Resource: https://www.youtube.com/watch?v=L-EaPf5tD5A
    override fun singleNumber(nums: IntArray): IntArray {
        // xy denotes x XOR y here, where x and y refer to two elements that appear only once in nums[].
        // Note important property of XOR operator: x XOR x = 0
        var xy = 0
        for (num in nums) {
            xy = xy xor num
        }

        // Now, take any set bit in xy.
        // Here we take the least significant bit: LSB = 2^i = x AND -x
        val lsb = xy and -xy
        val result = IntArray(2)
        // Take XOR of all elements in nums[] once again, but this time elements into 2 groups:
        // with and without i-th bit set. Clearly, x and y will follow into different groups.
        for (num in nums) {
            // 1st group with i-th bit set, 2nd group with i-th bit unset
            if (num and lsb == 0) {
                result[0] = result[0] xor num
            } else {
                result[1] = result[1] xor num
            }
        }
        return result
    }
}