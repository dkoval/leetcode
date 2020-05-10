package com.github.dkoval.leetcode.challenge

/**
 * [Check If It Is a Straight Line](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/)
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 */
object CheckIfItIsAStraightLine {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        // (y - y0) / (y1 - y0) = (x - x0) / (x1 - x0)
        // or
        // (y0 - y1) * x + (x1 - x0) * y + (x0 * y1 - x1 * y0) = 0
        val a = coordinates[0][1] - coordinates[1][1]
        val b = coordinates[1][0] - coordinates[0][0]
        val c = coordinates[0][0] * coordinates[1][1] - coordinates[1][0] * coordinates[0][1]
        return coordinates.all { coordinate -> liesOnTheSameLine(coordinate, a, b, c) }
    }

    private fun liesOnTheSameLine(coordinate: IntArray, a: Int, b: Int, c: Int): Boolean =
        a * coordinate[0] + b * coordinate[1] + c == 0
}