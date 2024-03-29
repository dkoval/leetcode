package com.github.dkoval.leetcode.challenge

/**
 * [Unique Paths III](https://leetcode.com/problems/unique-paths-iii/)
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * - 1 represents the starting square.  There is exactly one starting square.
 * - 2 represents the ending square.  There is exactly one ending square.
 * - 0 represents empty squares we can walk over.
 * - -1 represents obstacles that we cannot walk over.
 *
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Constraints:
 *
 * - ```m == grid.length```
 * - ```n == grid[i].length```
 * - ```1 <= m, n <= 20```
 * - ```1 <= m * n <= 20```
 * - ```-1 <= grid[i][j] <= 2```
 */
interface UniquePaths3 {
    fun uniquePathsIII(grid: Array<IntArray>): Int
}

object UniquePaths3Rev1 : UniquePaths3 {
    // (drow, dcol) - up, down, left and right
    private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    // Resource: https://www.youtube.com/watch?v=XNKCkX_tHhM
    override fun uniquePathsIII(grid: Array<IntArray>): Int {
        // there is exactly one starting square (== 1) in the grid
        var startRow = -1
        var startCol = -1
        // the number of empty squares (== 0) that need to be walked over
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
        // base case: reached the ending square
        if (grid[row][col] == 2) {
            // has every non-obstacle square been walked over?
            return if (numZeros == -1) 1 else 0
        }

        // mark the current square as visited
        grid[row][col] = 3

        // consider all possible 4 directions
        var numPaths = 0
        for ((drow, dcol) in directions) {
            val nextRow = row + drow
            val nextCol = col + dcol

            // check whether (nextRow, nextCol) is in bounds
            if (nextRow !in grid.indices || nextCol !in grid[0].indices) {
                continue
            }

            // ignore obstacles and already visited squares
            if (grid[nextRow][nextCol] == -1 || grid[nextRow][nextCol] == 3) {
                continue
            }

            numPaths += dfs(grid, nextRow, nextCol, numZeros - 1)
        }

        // backtrack to explore all remaining possible paths
        grid[row][col] = 0
        return numPaths
    }
}

object UniquePaths3Rev2 : UniquePaths3 {
    // (drow, dcol) - up, down, left and right
    private val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    private data class Square(val row: Int, val col: Int)

    override fun uniquePathsIII(grid: Array<IntArray>): Int {
        // there is exactly one starting square (== 1) in the grid
        var startRow = -1
        var startCol = -1
        // the number of empty squares (== 0) that need to be walked over;
        // starting (== 1) and ending (== 2) squares are also considered empty
        var numEmpty = 2
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                when (grid[row][col]) {
                    0 -> numEmpty++
                    1 -> {
                        startRow = row
                        startCol = col
                    }
                }
            }
        }

        val seen = mutableSetOf<Square>().apply { this += Square(startRow, startCol) }
        return dfs(grid, startRow, startCol, numEmpty, seen)
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, numEmpty: Int, seen: MutableSet<Square>): Int {
        // base case - reached the ending state
        if (grid[row][col] == 2) {
            return if (seen.size == numEmpty) 1 else 0
        }

        var numPaths = 0
        for ((drow, dcol) in directions) {
            val nextRow = row + drow
            val nextCol = col + dcol

            // make sure (nextRow, nextCol) is in bounds and not an obstacle
            if (nextRow !in grid.indices || nextCol !in grid[0].indices || grid[nextRow][nextCol] == -1) {
                continue
            }

            // already seen?
            val next = Square(nextRow, nextCol)
            if (next in seen) {
                continue
            }

            seen += next // add (nextRow, nextCol) to the current path
            numPaths += dfs(grid, nextRow, nextCol, numEmpty, seen)
            seen -= next // backtrack to check other possibilities
        }
        return numPaths
    }
}