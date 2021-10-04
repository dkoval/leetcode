package com.github.dkoval.leetcode.challenge

/**
 * [Island Perimeter](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/)
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 */
interface IslandPerimeter {

    fun islandPerimeter(grid: Array<IntArray>): Int
}

// O(M * N) time | O(1) space
object IslandPerimeterIter : IslandPerimeter {

    private val directions = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )

    override fun islandPerimeter(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        var p = 0
        for (row in 0 until m) {
            for (col in 0 until n) {
                if (grid[row][col] == 0) continue
                // explore all 4 directions
                for ((dx, dy) in directions) {
                    val nextRow = row + dx
                    val nextCol = col + dy
                    if (nextRow !in 0 until m || nextCol !in 0 until n || grid[nextRow][nextCol] == 0) {
                        p++;
                    }
                }
            }
        }
        return p
    }
}

object IslandPerimeterDFS : IslandPerimeter {

    private val directions = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1)
    )

    private data class Cell(val row: Int, val col: Int)

    override fun islandPerimeter(grid: Array<IntArray>): Int {
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 0) continue
                return dfs(grid, row, col, mutableSetOf())
            }
        }
        return -1
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, visited: MutableSet<Cell>): Int {
        val m = grid.size
        val n = grid[0].size

        if (row !in 0 until m || col !in 0 until n || grid[row][col] == 0) {
            return 1
        }

        val cell = Cell(row, col)
        if (cell in visited) {
            return 0
        }

        // mark current cell as visited
        visited += cell
        var p = 0
        // explore all 4 directions
        for ((dx, dy) in directions) {
           p += dfs(grid, row + dx, col + dy, visited)
        }
        return p
    }
}