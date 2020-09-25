package com.github.dkoval.leetcode.challenge

/**
 * [Largest Number](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/)
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 */
interface LargestNumber {

    fun largestNumber(nums: IntArray): String
}

object LargestNumberKt : LargestNumber {

    private object LargestNumberComparator : Comparator<String> {

        override fun compare(a: String, b: String): Int {
            val o1 = a + b
            val o2 = b + a
            return o2.compareTo(o1)
        }
    }

    override fun largestNumber(nums: IntArray): String {
        val strs = Array(nums.size) { i -> nums[i].toString() }
        strs.sortWith(LargestNumberComparator)
        if (strs[0] == "0") return "0"
        return buildString {
            for (str in strs) {
                append(str)
            }
        }
    }
}