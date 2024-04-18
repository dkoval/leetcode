package com.github.dkoval.leetcode.challenge

/**
 * [Island Perimeter](https://leetcode.com/problems/island-perimeter/)
 *
 * You are given `row x col` grid representing a map where ```grid[i][j] = 1``` represents land and ```grid[i][j] = 0```
 * represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The `grid` is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Constraints:
 *
 * - ```row == grid.length```
 * - ```col == grid[i].length```
 * - ```1 <= row, col <= 100```
 * - ```grid[i][j] is 0 or 1```
 * - ```There is exactly one island in grid```
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
                // there is exactly one island in grid
                if (grid[row][col] == 1) {
                    return dfs(grid, Cell(row, col), mutableSetOf())
                }
            }
        }
        return -1
    }

    private fun dfs(grid: Array<IntArray>, curr: Cell, visited: MutableSet<Cell>): Int {
        val m = grid.size
        val n = grid[0].size

        // mark current cell as visited
        visited += curr

        var p = 0
        // explore all 4 directions
        for ((dx, dy) in directions) {
            val nextRow = curr.row + dx
            val nextCol = curr.col + dy

            if (nextRow !in 0 until m || nextCol !in 0 until n || grid[nextRow][nextCol] == 0) {
                p++
                continue
            }

            val next = Cell(nextRow, nextCol)
            if (next !in visited) {
                p += dfs(grid, next, visited)
            }
        }
        return p
    }
}