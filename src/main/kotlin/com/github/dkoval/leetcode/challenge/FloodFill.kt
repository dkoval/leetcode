package com.github.dkoval.leetcode.challenge

/**
 * [Flood Fill](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/)
 */
object FloodFill {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val startingPixelColor = image[sr][sc]
        if (startingPixelColor != newColor) {
            doFloodFill(image, sr, sc, startingPixelColor, newColor)
        }
        return image
    }

    private fun doFloodFill(image: Array<IntArray>, row: Int, col: Int, startingPixelColor: Int, newColor: Int) {
        fun isWithinBoundaries(row: Int, col: Int): Boolean =
            row >= 0 && row < image.size && col >= 0 && col < image[0].size

        if (!isWithinBoundaries(row, col)) {
            return
        }
        if (image[row][col] != startingPixelColor) {
            return
        }
        image[row][col] = newColor
        doFloodFill(image, row - 1, col, startingPixelColor, newColor) // go up
        doFloodFill(image, row, col - 1, startingPixelColor, newColor) // go left
        doFloodFill(image, row, col + 1, startingPixelColor, newColor) // go right
        doFloodFill(image, row + 1, col, startingPixelColor, newColor) // go down
    }
}