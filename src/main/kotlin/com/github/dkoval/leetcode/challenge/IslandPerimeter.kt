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

object IslandPerimeterIter : IslandPerimeter {

    override fun islandPerimeter(grid: Array<IntArray>): Int {
        var p = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) continue
                if (i == 0 || grid[i - 1][j] == 0) p++ // look up
                if (i == grid.lastIndex || grid[i + 1][j] == 0) p++ // look down
                if (j == 0 || grid[i][j - 1] == 0) p++ // look left
                if (j == grid[0].lastIndex || grid[i][j + 1] == 0) p++ // look right
            }
        }
        return p
    }
}

object IslandPerimeterDFS : IslandPerimeter {

    override fun islandPerimeter(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) continue
                return dfs(i, j, grid)
            }
        }
        return -1
    }

    private data class Cell(val row: Int, val col: Int) {
        fun up(): Cell = Cell(row - 1, col)
        fun down(): Cell = Cell(row + 1, col)
        fun left(): Cell = Cell(row, col - 1)
        fun right(): Cell = Cell(row, col + 1)
    }

    private data class PerimeterValue(var value: Int)

    private fun dfs(i: Int, j: Int, grid: Array<IntArray>): Int {
        val p = PerimeterValue(0)
        doDfs(grid, Cell(i, j), mutableSetOf(), p)
        return p.value
    }

    private fun doDfs(grid: Array<IntArray>, cell: Cell, visited: MutableSet<Cell>, p: PerimeterValue) {
        visited.add(cell)

        if (cell.row == 0 || grid[cell.row - 1][cell.col] == 0) p.value++ // look up
        if (cell.row == grid.lastIndex || grid[cell.row + 1][cell.col] == 0) p.value++ // look down
        if (cell.col == 0 || grid[cell.row][cell.col - 1] == 0) p.value++ // look left
        if (cell.col == grid[0].lastIndex || grid[cell.row][cell.col + 1] == 0) p.value++ // look right

        // keep on doing DFS
        if (cell.row > 0) doDfsIfPossible(grid, cell.up(), visited, p)
        if (cell.row < grid.lastIndex) doDfsIfPossible(grid, cell.down(), visited, p)
        if (cell.col > 0) doDfsIfPossible(grid, cell.left(), visited, p)
        if (cell.col < grid[0].lastIndex) doDfsIfPossible(grid, cell.right(), visited, p)
    }

    private fun doDfsIfPossible(grid: Array<IntArray>, cell: Cell, visited: MutableSet<Cell>, p: PerimeterValue) {
        if (grid[cell.row][cell.col] == 1 && !visited.contains(cell)) {
            doDfs(grid, cell, visited, p)
        }
    }
}