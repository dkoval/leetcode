package com.github.dkoval.leetcode.challenge

/**
 * [Largest Component Size by Common Factor](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/)
 *
 * Given a non-empty array of unique positive integers A, consider the following graph:
 * - There are `A.length` nodes, labelled ```A[0]``` to ```A[A.length - 1]```;
 * - There is an edge between ```A[i]``` and ```A[j]``` if and only if ```A[i]``` and ```A[j]``` share a
 * common factor greater than 1.
 *
 * Return the size of the largest connected component in the graph.
 */
object LargestComponentSizeByCommonFactor {
    // 1 <= A[i] <= 100000
    private const val MAX_VAL = 100000

    class UnionFind(size: Int) {
        // parent[i] is the parent of i
        private val parent = IntArray(size) { i -> i }

        fun find(x: Int): Int {
            var i = x
            while (i != parent[i]) {
                // path compression: make every other node in path point to its grandparent
                parent[i] = parent[parent[i]]
                i = parent[i]
            }
            return i
        }

        fun union(x: Int, y: Int) {
            val parentX = find(x)
            val parentY = find(y)
            if (parentX != parentY) {
                parent[parentY] = parentX
            }
        }
    }

    // Resource: https://www.youtube.com/watch?v=2mva2YRgrW8
    fun largestComponentSize(A: IntArray): Int {
        // for each number in the array, brute forcely find its prime factors and connect them
        // (there exist prime factors between 2 and sqrt(a))
        val uf = UnionFind(MAX_VAL + 1)
        for (a in A) {
            var i = 2
            while (i * i <= a) {
                if (a % i == 0) {
                    uf.union(a, i)
                    uf.union(a, a / i)
                }
                i++
            }
        }

        // compute the size of the largest connected component in the graph
        var result = 1
        val componentSizes = mutableMapOf<Int, Int>()
        for (a in A) {
            val parent = uf.find(a)
            val componentSize = componentSizes.getOrDefault(parent, 0) + 1
            componentSizes[parent] = componentSize
            result = maxOf(result, componentSize)
        }
        return result
    }
}