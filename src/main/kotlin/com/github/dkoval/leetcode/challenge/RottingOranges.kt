package com.github.dkoval.leetcode.challenge

/**
 * [Rotting Oranges](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/)
 *
 * In a given grid, each cell can have one of three values:
 * - the value 0 representing an empty cell;
 * - the value 1 representing a fresh orange;
 * - the value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 */
object RottingOranges {

    private data class Cell(val row: Int, val col: Int) {

        fun adjacent(delta: Pair<Delta, Delta>): Cell = adjacent(delta.first, delta.second)

        fun adjacent(rowDelta: Delta, colDelta: Delta): Cell = Cell(row + rowDelta.value, col + colDelta.value)

        enum class Delta(val value: Int) {
            ZERO(0),
            PLUS_ONE(1),
            MINUS_ONE(-1)
        }
    }

    fun orangesRotting(grid: Array<IntArray>): Int {
        val fresh = mutableSetOf<Cell>()
        var rotten = mutableSetOf<Cell>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    fresh.add(Cell(i, j))
                } else if (grid[i][j] == 2) {
                    rotten.add(Cell(i, j))
                }
            }
        }

        var numMinutes = 0
        // to be able to move left, right, up, bottom
        val deltas = arrayOf(
            Cell.Delta.ZERO to Cell.Delta.MINUS_ONE,
            Cell.Delta.ZERO to Cell.Delta.PLUS_ONE,
            Cell.Delta.MINUS_ONE to Cell.Delta.ZERO,
            Cell.Delta.PLUS_ONE to Cell.Delta.ZERO
        )

        while (fresh.size > 0) {
            // try to infect 4-directionally adjacent fresh oranges
            val infected = mutableSetOf<Cell>()
            for (currCell in rotten) {
                for (delta in deltas) {
                    val nextCell = currCell.adjacent(delta)
                    if (fresh.contains(nextCell)) {
                        fresh.remove(nextCell)
                        infected.add(nextCell)
                    }
                }
            }
            if (infected.isEmpty()) {
                return -1
            }
            rotten = infected
            numMinutes++
        }
        return numMinutes
    }
}