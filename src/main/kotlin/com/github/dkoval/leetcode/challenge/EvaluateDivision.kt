package com.github.dkoval.leetcode.challenge

/**
 * [Evaluate Division](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3474/)
 *
 * You are given equations in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating-point number). Given some queries, return the answers.
 * If the answer does not exist, return -1.0.
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero
 * and there is no contradiction.
 */
object EvaluateDivisionKt {

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = buildGraph(equations, values)
        return processQueries(queries, graph)
    }

    private fun buildGraph(equations: List<List<String>>, values: DoubleArray): Map<String, Map<String, Double>> {
        val graph = mutableMapOf<String, MutableMap<String, Double>>()
        for (i in equations.indices) {
            val (a, b) = equations[i]
            graph.getOrPut(a) { mutableMapOf() }[b] = values[i]
            graph.getOrPut(b) { mutableMapOf() }[a] = 1 / values[i]
        }
        return graph
    }

    private fun processQueries(queries: List<List<String>>, graph: Map<String, Map<String, Double>>): DoubleArray {
        val result = DoubleArray(queries.size)
        for (i in queries.indices) {
            val (q1, q2) = queries[i]
            result[i] = evaluateDivision(q1, q2, graph)
        }
        return result
    }

    private fun evaluateDivision(q1: String, q2: String, graph: Map<String, Map<String, Double>>): Double =
        when {
            graph[q1] == null || graph[q2] == null -> -1.0
            q1 == q2 -> 1.0
            else -> dfs(graph, q1, q2, mutableSetOf())
        }

    private fun dfs(
        graph: Map<String, Map<String, Double>>,
        source: String,
        target: String,
        visited: MutableSet<String>
    ): Double {
        if (source == target) return 1.0
        if (source in visited) return -1.0
        visited += source
        val adjList = graph[source] ?: error("$source has no adjacent elements")
        for ((adj, value) in adjList) {
            val result = dfs(graph, adj, target, visited)
            if (result > 0) return result * value
        }
        return -1.0
    }
}