package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3495/">Meeting Rooms II</a>
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 */
public abstract class MeetingRooms2 {

    public abstract int minMeetingRooms(int[][] intervals);

    public static class MeetingRooms2UsingSortingAndPriorityQueue extends MeetingRooms2 {

        @Override
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            PriorityQueue<Integer> endTimes = new PriorityQueue<>();
            int count = 0;
            for (int[] interval : intervals) {
                Integer closestEndTime = endTimes.peek();
                if (closestEndTime == null || interval[0] < closestEndTime) {
                    // book a new room
                    count++;
                } else {
                    // reuse a freed up meeting room
                    endTimes.poll();
                }
                endTimes.add(interval[1]);
            }
            return count;
        }
    }
}
