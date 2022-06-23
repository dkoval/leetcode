package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a hrtef="https://leetcode.com/problems/course-schedule-iii/">Course Schedule III</a>
 * <p>
 * There are n different online courses numbered from 1 to n. You are given an array courses where
 * courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days
 * and must be finished before or on lastDayi.
 * <p>
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * <p>
 * Return the maximum number of courses that you can take.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= courses.length <= 10^4</li>
 *  <li>1 <= durationi, lastDayi <= 10^4</li>
 * </ul>
 */
public class CourseSchedule3 {

    // (N * logN) time | O(N) space
    public int scheduleCourse(int[][] courses) {
        // Max heap is used to record durations of taken courses
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(courses.length, Comparator.reverseOrder());

        // Preprocessing step: sort courses array by the `lastDay` attribute
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));

        int currDay = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            if (duration > lastDay) {
                continue;
            }

            if (currDay + duration <= lastDay) {
                // take the current course
                currDay += duration;
                maxHeap.offer(duration);
            } else if (maxHeap.peek() > duration) {
                // take current course in favour of excluding a previously taken course with the biggest `duration`,
                // i.e. swap the current course with a previously taken course that has the biggest duration.
                currDay += duration;
                currDay -= maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        return maxHeap.size();
    }
}
