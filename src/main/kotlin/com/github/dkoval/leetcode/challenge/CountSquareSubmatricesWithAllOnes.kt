package com.github.dkoval.leetcode.challenge

object CountSquareSubmatricesWithAllOnesRev1 : CountSquareSubmatricesWithAllOnes {

    // Resources:
    // https://www.youtube.com/watch?v=ojz8xZc8pog
    // https://www.youtube.com/watch?v=FO7VXDfS8Gk
    override fun countSquares(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size

        val cache = Array(n) { IntArray(m) } // (i, j) pair denotes bottom-right corner of a square
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i == 0 || j == 0) {
                    cache[i][j] = matrix[i][j]
                } else if (matrix[i][j] == 1) {
                    // explore previous column, previous row and previous diagonal
                    cache[i][j] = 1 + minOf(cache[i][j - 1], cache[i - 1][j], cache[i - 1][j - 1])
                }
                count += cache[i][j]
            }
        }
        return count
    }
}