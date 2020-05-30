package com.github.dkoval.leetcode.challenge

/**
 * [Course Schedule](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/)
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: ```[0,1]```
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
object CourseSchedule {

    enum class VertexStatus {
        UNVISITED, BEING_VISITED, COMPLETELY_VISITED
    }

    // Resource: https://www.youtube.com/watch?v=iaaObeAEgxI
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = adjListOf(prerequisites)
        // Hint #1. This problem is equivalent to finding if a cycle exists in a directed graph.
        // If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
        return !hasCycle(numCourses, graph)
    }

    private fun adjListOf(prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((src, dest) in prerequisites) {
            graph.getOrPut(src) { mutableListOf() }.add(dest)
        }
        return graph
    }

    private fun hasCycle(numCourses: Int, graph: Map<Int, List<Int>>): Boolean {
        val visited = Array(numCourses) { VertexStatus.UNVISITED }
        for (i in 0 until numCourses) {
            if (hasCycleDFS(i, graph, visited)) {
                return true
            }
        }
        return false
    }

    private fun hasCycleDFS(v: Int, graph: Map<Int, List<Int>>, visited: Array<VertexStatus>): Boolean {
        // check for a back edge
        if (visited[v] == VertexStatus.BEING_VISITED) {
            return true
        }
        // skip over COMPLETELY_VISITED vertices
        if (visited[v] == VertexStatus.COMPLETELY_VISITED) {
            return false
        }
        // explore neighbours of vertex v
        visited[v] = VertexStatus.BEING_VISITED
        graph[v]?.let { neighbours ->
            for (u in neighbours) {
                if (hasCycleDFS(u, graph, visited)) {
                    return true
                }
            }
        }
        visited[v] = VertexStatus.COMPLETELY_VISITED
        return false
    }
}