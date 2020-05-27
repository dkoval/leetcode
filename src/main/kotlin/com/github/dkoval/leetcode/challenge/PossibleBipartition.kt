package com.github.dkoval.leetcode.challenge

/**
 * [Possible Bipartition](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/)
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if ```dislikes[i] = [a, b]```, it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 */
object PossibleBipartition {

    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val adj = adjListOf(N, dislikes)
        val groups = Array<Group?>(N) { null }
        for (i in 0 until N) {
            if (groups[i] == null && !dfs(i, Group.ZERO, adj, groups)) {
                return false
            }
        }
        return true
    }

    private fun adjListOf(N: Int, dislikes: Array<IntArray>): Array<MutableList<Int>> {
        val adj = Array(N) { mutableListOf<Int>() }
        for ((a, b) in dislikes) {
            adj[a - 1].add(b - 1)
            adj[b - 1].add(a - 1)
        }
        return adj
    }

    private fun dfs(v: Int, group: Group, adj: Array<MutableList<Int>>, groups: Array<Group?>): Boolean {
        if (groups[v] == null) {
            groups[v] = group
        } else {
            return groups[v] == group
        }
        for (u in adj[v]) {
            if (!dfs(u, group.flip(), adj, groups)) {
                return false
            }
        }
        return true
    }

    private enum class Group {
        ZERO {
            override fun flip(): Group = ONE
        },
        ONE {
            override fun flip(): Group = ZERO
        };

        abstract fun flip(): Group
    }
}