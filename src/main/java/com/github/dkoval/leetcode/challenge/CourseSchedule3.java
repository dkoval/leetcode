package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a hrtef="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3729/">Course Schedule III</a>
 * <p>
 * There are n different online courses numbered from 1 to n. You are given an array courses where
 * courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days
 * and must be finished before or on lastDayi.
 * <p>
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * <p>
 * Return the maximum number of courses that you can take.
 */
public class CourseSchedule3 {

    // (N * logN) time | O(N) space
    public int scheduleCourse(int[][] courses) {
        // Sort `courses` array by `lastDay` attribute
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));

        // Max heap is here to keep track of `duration`s of taken courses
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(courses.length, Comparator.reverseOrder());
        int maxCoursesTaken = 0;
        int currDay = 0;

        for (int[] course : courses) {
            int duration = course[0], lastDay = course[1];
            maxHeap.offer(duration);
            currDay += duration;
            while (currDay > lastDay && !maxHeap.isEmpty()) {
                // remove course(s) with the longest duration to meet the deadline
                currDay -= maxHeap.poll();
            }
            // maxHeap.size() is the current number of taken courses.
            // Our goal is to maximize the total number number of taken courses.
            maxCoursesTaken = Math.max(maxCoursesTaken, maxHeap.size());
        }
        return maxCoursesTaken;
    }
}
