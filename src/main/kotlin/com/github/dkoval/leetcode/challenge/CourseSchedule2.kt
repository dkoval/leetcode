package com.github.dkoval.leetcode.challenge

import java.util.*


/**
 * [Course Schedule II](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/)
 *
 * There are a total of n courses you have to take, labeled from `0` to `n-1`.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: ```[0,1]```
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 */
object CourseSchedule2 {

    enum class VertexStatus {
        UNVISITED, BEING_VISITED, COMPLETELY_VISITED
    }

    // Resource: https://www.youtube.com/watch?v=_BGK0kpE4oE
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = adjListOf(prerequisites)
        return doFindOrder(numCourses, graph)
    }

    private fun adjListOf(prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((next, curr) in prerequisites) {
            graph.getOrPut(curr) { mutableListOf() }.add(next)
        }
        return graph
    }

    private fun doFindOrder(numCourses: Int, graph: Map<Int, List<Int>>): IntArray {
        // do topological sort along with cycle detection
        val visited = Array(numCourses) { VertexStatus.UNVISITED }
        val stack: Deque<Int> = LinkedList()
        for (i in 0 until numCourses) {
            if (!doFindOrderDFS(i, graph, visited, stack)) {
                return intArrayOf()
            }
        }
        return stack.toIntArray()
    }

    private fun doFindOrderDFS(
        u: Int,
        graph: Map<Int, List<Int>>,
        visited: Array<VertexStatus>,
        stack: Deque<Int>
    ): Boolean {
        // check for a back edge
        if (visited[u] == VertexStatus.BEING_VISITED) {
            return false
        }
        // skip over COMPLETELY_VISITED vertices
        if (visited[u] == VertexStatus.COMPLETELY_VISITED) {
            return true
        }
        // explore neighbours of vertex v
        visited[u] = VertexStatus.BEING_VISITED
        graph[u]?.also { neighbours ->
            for (v in neighbours) {
                if (!doFindOrderDFS(v, graph, visited, stack)) {
                    return false
                }
            }
        }
        visited[u] = VertexStatus.COMPLETELY_VISITED
        stack.push(u)
        return true
    }
}