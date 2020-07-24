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
        val paths = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        dfs(graph, 0, graph.lastIndex, paths, path)
        return paths
    }

    private fun dfs(
        graph: Array<IntArray>,
        source: Int,
        target: Int,
        paths: MutableList<List<Int>>,
        path: MutableList<Int>
    ) {
        path.add(source)
        if (source == target) {
            val copy = mutableListOf<Int>().apply { addAll(path) }
            paths.add(copy)
        } else {
            for (v in graph[source]) {
                dfs(graph, v, target, paths, path)
            }
        }
        path.removeAt(path.lastIndex)
    }
}