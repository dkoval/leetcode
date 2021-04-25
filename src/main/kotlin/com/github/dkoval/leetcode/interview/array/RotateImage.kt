package com.github.dkoval.leetcode.interview.array

/**
 * [Rotate Image](https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/)
 *
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 */
object RotateImage {

    // O(N * N) time | O(1) space
    fun rotate(matrix: Array<IntArray>) {
        transpose(matrix)
        reverseEachRow(matrix)
    }

    private fun transpose(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in 0 until i) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
            }
        }
    }

    private fun reverseEachRow(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size / 2) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[i][matrix[i].size - j - 1]
                matrix[i][matrix[i].size - j - 1] = tmp
            }
        }
    }
}