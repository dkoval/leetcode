package com.github.dkoval.leetcode.challenge

/**
 * [Prison Cells After N Days](https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/)
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * - If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * - Otherwise, it becomes vacant.
 *
 * Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
 */
object PrisonCellsAfterNDays {

    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        val stateOnDayMap = mutableMapOf<String, Int>()
        for (i in 0 until N) {
            val state = cells.contentToString()
            val occurredOnDay = stateOnDayMap[state]
            if (occurredOnDay != null) {
                val loopLength = i - occurredOnDay
                val remainingDays = (N - i) % loopLength
                return prisonAfterNDays(cells, remainingDays)
            } else {
                stateOnDayMap[state] = i
                var prev = cells[0]
                for (j in 1..6) {
                    val curr = cells[j]
                    val next = cells[j + 1]
                    cells[j] = if (prev == next) 1 else 0
                    prev = curr
                }
            }
            cells[0] = 0
            cells[7] = 0
        }
        return cells
    }
}