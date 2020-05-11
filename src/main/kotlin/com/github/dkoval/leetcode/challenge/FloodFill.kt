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