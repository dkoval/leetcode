package com.github.dkoval.leetcode.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/my-calendar-ii/">My Calendar II</a>
 * <p>
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause
 * a triple booking.
 * <p>
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the
 * half open interval [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A triple booking happens when three events have some non-empty intersection
 * (ie., there is some time that is common to all 3 events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
 * without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 */
public abstract class MyCalendarTwo {

    public abstract boolean book(int start, int end);

    // Time complexity: O(N). For each new event, we process every previous event to decide whether the new event can be booked.
    // Space complexity: O(N), the size of the calendar.
    public static class MyCalendarTwoBruteForce extends MyCalendarTwo {
        private final List<int[]> allEvents = new ArrayList<>();
        private final List<int[]> doubleBookingsEvents = new ArrayList<>();

        @Override
        public boolean book(int start, int end) {
            // 2 events [start1, end1) and [start2, end2) do not conflict IFF one of them starts after the other one ends:
            // either end1 <= start2 || end2 <= start1. Therefore, by De Morgan's laws, this means the 2 event conflict when
            // end1 > start2 && end2 > start1 <=> start1 < end2 && start2 < end1
            for (int[] event : doubleBookingsEvents) {
                if (event[0] < end && start < event[1]) {
                    // prevent triple booking
                    return false;
                }
            }
            for (int[] event : allEvents) {
                if (event[0] < end && start < event[1]) {
                    int overlapStart = Math.max(start, event[0]);
                    int overlapEnd = Math.min(end, event[1]);
                    doubleBookingsEvents.add(new int[]{overlapStart, overlapEnd});
                }
            }
            allEvents.add(new int[]{start, end});
            return true;
        }
    }

    public static class MyCalendarTwoBoundaryCount extends MyCalendarTwo {
        private final SortedMap<Integer, Integer> delta = new TreeMap<>();

        @Override
        public boolean book(int start, int end) {
            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);
            int active = 0;
            for (int d : delta.values()) {
                active += d;
                if (active == 3) {
                    // avoid triple booking
                    delta.put(start, delta.get(start) - 1);
                    delta.put(end, delta.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}
