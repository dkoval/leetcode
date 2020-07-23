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
        var xy = 0
        for (num in nums) {
            xy = xy xor num
        }
        val d = xy and -xy // find first least significant i-th bit set, i.e. 2^i = d
        val result = IntArray(2)
        for (num in nums) {
            // split numbers into 2 groups:
            // 1st group with i-th bit set, 2nd group with i-th bit unset
            // clearly, x and y will follow into different groups
            if (num and d == 0) {
                result[0] = result[0] xor num
            } else {
                result[1] = result[1] xor num
            }
        }
        return result
    }
}