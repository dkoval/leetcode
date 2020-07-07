package com.github.dkoval.leetcode.challenge

/**
 * [Island Perimeter](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/)
 */
object IslandPerimeter {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var p = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) continue
                if (j == 0 || grid[i][j - 1] == 0) p++ // look left
                if (i == 0 || grid[i - 1][j] == 0) p++ // look up
                if (j == grid[0].lastIndex || grid[i][j + 1] == 0) p++ // look right
                if (i == grid.lastIndex || grid[i + 1][j] == 0) p++ // look bottom
            }
        }
        return p
    }
}