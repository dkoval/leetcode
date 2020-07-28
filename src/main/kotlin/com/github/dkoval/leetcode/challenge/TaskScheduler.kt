package com.github.dkoval.leetcode.challenge

import java.util.*

/**
 * [Task Scheduler](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/)
 *
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where each letter represents a different task. Tasks could be done without the original order of the array.
 * Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks
 * (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * You need to return the least number of units of times that the CPU will take to finish all the given tasks.
 */
object TaskScheduler {

    private data class Task(val id: Char, var count: Int = 1)

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val maxHeap = PriorityQueue<Task>(compareByDescending { it.count })
        tasks.asIterable()
            .groupingBy { it }
            .eachCount()
            .map { (name, count) -> Task(name, count) }
            .also { maxHeap.addAll(it)  }

        var intervals = 0
        val numTasksToSchedule = n + 1
        while (!maxHeap.isEmpty()) {
            val scheduledTasks = mutableListOf<Task>()
            repeat(numTasksToSchedule) {
                if (!maxHeap.isEmpty()) {
                    maxHeap.poll().also { scheduledTasks.add(it) }
                }
            }
            for (scheduledTask in scheduledTasks) {
                if (--scheduledTask.count > 0) {
                    maxHeap.add(scheduledTask)
                }
            }
            intervals += if (!maxHeap.isEmpty()) numTasksToSchedule else scheduledTasks.size
        }
        return intervals
    }
}