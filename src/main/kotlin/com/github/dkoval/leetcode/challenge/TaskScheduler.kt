package com.github.dkoval.leetcode.challenge

import java.util.*

object TaskSchedulerRev1 : TaskScheduler {

    private data class Task(val id: Char, var count: Int = 1)

    override fun leastInterval(tasks: CharArray, n: Int): Int {
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