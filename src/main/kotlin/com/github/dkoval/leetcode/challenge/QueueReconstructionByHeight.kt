package com.github.dkoval.leetcode.challenge

/**
 * [Queue Reconstruction by Height](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/)
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers `(h, k)`,
 * where `h` is the height of the person and `k` is the number of people in front of this person who have a height greater
 * than or equal to `h`. Write an algorithm to reconstruct the queue.
 */
object QueueReconstructionByHeight  {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator { (h1, k1), (h2, k2) ->
            // if persons are of the same height, sort by k in ascending order;
            // otherwise, sort by height in descending order
            if (h1 == h2) k1 - k2 else h2 - h1
        })
        val result = mutableListOf<IntArray>()
        for (person in people) {
            result.add(person[1], person)
        }
        return result.toTypedArray()
    }
}