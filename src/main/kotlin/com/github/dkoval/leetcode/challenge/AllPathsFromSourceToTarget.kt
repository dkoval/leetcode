package com.github.dkoval.leetcode.challenge

/**
 * [All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1.
 * ```graph[i]``` is a list of all nodes j for which the edge (i, j) exists.
 *
 * Constraints:
 * - ```n == graph.length```
 * - ```2 <= n <= 15```
 * - ```0 <= graph[i][j] < n```
 * - ```graph[i][j] != i``` (i.e., there will be no self-loops).
 * - All the elements of ```graph[i]``` are unique.
 * - The input graph is guaranteed to be a DAG.
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
        u: Int,
        target: Int,
        path: MutableList<Int>,
        ans: MutableList<List<Int>>
    ) {
        path.add(u)
        if (u == target) {
            ans += path.toList()
        } else {
            for (v in graph[u]) {
                dfs(graph, v, target, path, ans)
            }
        }
        path.removeLast()
    }
}