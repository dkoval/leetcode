package com.github.dkoval.leetcode.challenge

object LargestNumberKt : LargestNumber {

    override fun largestNumber(nums: IntArray): String {
        val xs = Array(nums.size) { i -> nums[i].toString() }

        xs.sortWith { a, b ->
            val s1 = a + b
            val s2 = b + a
            s2.compareTo(s1)
        }

        if (xs[0] == "0") {
            return "0"
        }

        return xs.joinToString(separator = "")
    }
}