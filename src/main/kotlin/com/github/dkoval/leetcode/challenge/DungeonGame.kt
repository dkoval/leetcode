package com.github.dkoval.leetcode.challenge

import kotlin.math.max
import kotlin.math.min

/**
 * [Dungeon Game](https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/)
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid.
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon
 * to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point
 * drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 */
object DungeonGame {

    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val r = dungeon.size
        val c = dungeon[0].size
        val solution = Array(r) { IntArray(c) }
        // calculate min health point needed to reach the bottom-up cell
        solution[r - 1][c - 1] = if (dungeon[r - 1][c - 1] > 0) 1 else 1 - dungeon[r - 1][c - 1]
        // solve for the last column
        for (i in r - 2 downTo 0) {
            solution[i][c - 1] = ensureMinHealthPoint(solution[i + 1][c - 1] - dungeon[i][c - 1])
        }
        // solve for the last row
        for (j in c - 2 downTo 0) {
            solution[r - 1][j] = ensureMinHealthPoint(solution[r - 1][j + 1] - dungeon[r - 1][j])
        }
        // solve for remaining cells going bottom-up
        for (i in r - 2 downTo 0) {
            for (j in c - 2 downTo 0) {
                solution[i][j] = ensureMinHealthPoint(min(solution[i][j + 1], solution[i + 1][j]) - dungeon[i][j])
            }
        }
        return solution[0][0]
    }

    private fun ensureMinHealthPoint(healthPoint: Int): Int = max(healthPoint, 1)
}