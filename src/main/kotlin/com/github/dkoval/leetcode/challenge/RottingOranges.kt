package com.github.dkoval.leetcode.challenge

object RottingOrangesUsingTwoSets : RottingOranges {

    private val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    private data class Cell(val row: Int, val col: Int)

    override fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val fresh = mutableSetOf<Cell>()
        val infected = mutableSetOf<Cell>()

        for (row in 0 until m) {
            for (col in 0 until n) {
                when {
                    grid[row][col] == 1 -> fresh.add(Cell(row, col))
                    grid[row][col] == 2 -> infected.add(Cell(row, col))
                }
            }
        }

        var numMinutes = 0
        while (fresh.isNotEmpty()) {
            val infectedNow = mutableSetOf<Cell>()
            for (cell in infected) {
                // try to infect 4-directionally adjacent fresh oranges
                for ((dx, dy) in directions) {
                    val nextRow = cell.row + dx
                    val nextCol = cell.col + dy

                    if (nextRow !in 0 until m || nextCol !in 0 until n) {
                        continue
                    }

                    val target = Cell(nextRow, nextCol)
                    if (target in fresh) {
                        fresh -= target
                        infectedNow += target
                    }
                }
            }

            if (infectedNow.isEmpty()) {
                return -1
            }

            infected.clear()
            infected += infectedNow
            numMinutes++
        }

        return numMinutes
    }
}