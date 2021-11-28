package com.github.dkoval.leetcode.challenge

/**
 * [All Paths From Source to Target](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/)
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1.
 * ```graph[i]``` is a list of all nodes j for which the edge (i, j) exists.
 */
object AllPathsFromSourceToTarget {

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        // Given graph is a directed acyclic graph, therefore
        // we can omit keeping track of visited vertices here
        dfs(graph, 0, graph.lastIndex, mutableListOf(), ans)
        return ans
    }

    private fun dfs(
        graph: Array<IntArray>,
        vertex: Int,
        target: Int,
        path: MutableList<Int>,
        ans: MutableList<List<Int>>
    ) {
        path.add(vertex)
        if (vertex == target) {
            val copy = mutableListOf<Int>().apply { addAll(path) }
            ans.add(copy)
        } else {
            for (neighbour in graph[vertex]) {
                dfs(graph, neighbour, target, path, ans)
            }
        }
        path.removeAt(path.lastIndex)
    }
}