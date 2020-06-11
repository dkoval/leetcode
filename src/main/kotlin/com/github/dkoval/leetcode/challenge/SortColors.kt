package com.github.dkoval.leetcode.challenge

/**
 * [Sort Colors](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/)
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
object SortColors {

    enum class Color(val code: Int) {
        RED(0),
        WHITE(1),
        BLUE(2)
    }

    fun sortColors(nums: IntArray) {
        var red = 0 // read area
        var curr = 0 // white area
        var blue = nums.lastIndex // blue area
        while (curr <= blue) {
            when {
                nums[curr] == Color.RED.code -> {
                    nums[curr] = nums[red]
                    nums[red] = Color.RED.code
                    red++
                    curr++
                }
                nums[curr] == Color.BLUE.code -> {
                    nums[curr] = nums[blue]
                    nums[blue] = Color.BLUE.code
                    blue--
                }
                else -> {
                    curr++
                }
            }
        }
    }
}