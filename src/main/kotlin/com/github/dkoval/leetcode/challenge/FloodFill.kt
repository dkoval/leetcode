package com.github.dkoval.leetcode.challenge

/**
 * [Flood Fill](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/)
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
 * "flood fill" the image. To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 */
object FloodFill {

    private val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val origColor = image[sr][sc]
        if (origColor != newColor) {
            dfs(image, sr, sc, origColor, newColor)
        }
        return image
    }

    private fun dfs(image: Array<IntArray>, row: Int, col: Int, origColor: Int, newColor: Int) {
        // boundaries check
        if (row !in image.indices || col !in image[0].indices) {
            return
        }

        // skip over irrelevant pixels
        if (image[row][col] != origColor) {
            return
        }

        // change the pixel's color
        image[row][col] = newColor

        // explore 4-directionally adjacent pixels
        for ((dx, dy) in directions) {
            dfs(image, row + dx, col + dy, origColor, newColor)
        }
    }
}