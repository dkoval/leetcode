package com.github.dkoval.leetcode.challenge

/**
 * [Queue Reconstruction by Height](https://leetcode.com/problems/queue-reconstruction-by-height/)
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers `(h, k)`,
 * where `h` is the height of the person and `k` is the number of people in front of this person who have a height greater
 * than or equal to `h`. Write an algorithm to reconstruct the queue.
 *
 * Constraints:
 *
 * - 1 <= people.length <= 2000
 * - 0 <= hi <= 106
 * - 0 <= ki < people.length
 * - It is guaranteed that the queue can be reconstructed
 */
object QueueReconstructionByHeight {

    // O(N^2) time (we may need to shift elements to insert new ones into the result[])
    // O(N) space
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith { (h1, k1), (h2, k2) ->
            // if persons are of the same height, sort by k in ascending order;
            // otherwise, sort by height in descending order
            if (h1 == h2) k1 - k2 else h2 - h1
        }

        val result = mutableListOf<IntArray>()
        for (person in people) {
            result.add(person[1], person) // shifts old value at index i by 1 position to the right
        }
        return result.toTypedArray()
    }
}