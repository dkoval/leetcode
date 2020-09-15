package com.github.dkoval.leetcode.interview.array

/**
 * [Set Matrix Zeroes](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/)
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 * - A straight forward solution using O(mn) space is probably a bad idea.
 * - A simple improvement uses O(m + n) space, but still not the best solution.
 * - Could you devise a constant space solution?
 */
interface SetMatrixZeroes {

    fun setZeroes(matrix: Array<IntArray>)
}

object SetMatrixZeroesUsingExtraSpace : SetMatrixZeroes {

    override fun setZeroes(matrix: Array<IntArray>) {
        val rowsToMark = mutableSetOf<Int>()
        val colsToMark = mutableSetOf<Int>()
        // compute rows and cols to mark
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    rowsToMark += i
                    colsToMark += j
                }
            }
        }
        // update the matrix
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (i in rowsToMark || j in colsToMark) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}

// Time complexity: O(M*N), space complexity: O(N)
object SetMatrixZeroesConstantSpace : SetMatrixZeroes {

    override fun setZeroes(matrix: Array<IntArray>) {
        // The idea is to use the first cell of every row and column as a flag.
        // If the first cell of a row is set to 0 this means the row should be marked 0.
        // Similarly, if the first cell of a column is set to 0 this means the column should be marked 0.
        // Since the first cell of the first row and the first column is the same, we use `markFirstCol`
        // variable to tell us if the first column needs to be marked.
        var markFirstCol = false
        for (i in matrix.indices) {
            if (matrix[i][0] == 0) {
                markFirstCol = true
            }
            for (j in 1 until matrix[i].size) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }
        // update the matrix, skipping the first row and the first column for now
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[i].size) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
        // see if the first row needs to be updated
        if (matrix[0][0] == 0) {
            for (j in matrix[0].indices) {
                matrix[0][j] = 0
            }
        }
        // see if the first column needs to be updated
        if (markFirstCol) {
            for (i in matrix.indices) {
                matrix[i][0] = 0
            }
        }
    }
}