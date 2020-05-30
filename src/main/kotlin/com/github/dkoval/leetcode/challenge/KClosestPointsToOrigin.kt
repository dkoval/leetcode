package com.github.dkoval.leetcode.challenge

/**
 * [K Closest Points to Origin](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/)
 *
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 */
object KClosestPointsToOrigin {

    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        points.sortBy { point -> point[0] * point[0] + point[1] * point[1] }
        return points.take(K).toTypedArray()
    }
}