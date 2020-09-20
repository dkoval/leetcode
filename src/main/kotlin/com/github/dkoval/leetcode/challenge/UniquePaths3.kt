package com.github.dkoval.leetcode.challenge

/**
 * [Unique Paths III](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/)
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * - 1 represents the starting square.  There is exactly one starting square.
 * - 2 represents the ending square.  There is exactly one ending square.
 * - 0 represents empty squares we can walk over.
 * - -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 */
object UniquePaths3 {

    // Resource: https://www.youtube.com/watch?v=XNKCkX_tHhM
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var startRow = 0
        var startCol = 0
        var numZeros = 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                when (grid[row][col]) {
                    0 -> numZeros++
                    1 -> {
                        startRow = row
                        startCol = col
                    }
                }
            }
        }
        return dfs(grid, startRow, startCol, numZeros)
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, numZeros: Int): Int {
        if (row < 0 || row >= grid.size ||
            col < 0 || col >= grid[0].size ||
            grid[row][col] == -1
        ) {
            // grid[row][col] == -1 means that the cell is
            // either an obstacle or already visited
            return 0
        }
        if (grid[row][col] == 2) {
            // reached ending cell
            return if (numZeros == -1) return 1 else 0
        }
        // mark 0-cell as visited
        grid[row][col] = -1
        // consider all possible 4 directions
        val numPaths = dfs(grid, row + 1, col, numZeros - 1) +
                dfs(grid, row, col + 1, numZeros - 1) +
                dfs(grid, row - 1, col, numZeros - 1) +
                dfs(grid, row, col - 1, numZeros - 1)
        // backtrack to explore all remaining possible paths
        grid[row][col] = 0
        return numPaths
    }
}