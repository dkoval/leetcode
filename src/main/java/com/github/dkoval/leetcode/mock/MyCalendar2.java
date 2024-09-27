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
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= start < end <= 10^9</li>
 *  <li>At most 1000 calls will be made to book</li>
 * </ul>
 */
public abstract class MyCalendar2 {

    public abstract boolean book(int start, int end);

    // Time complexity: O(N). For each new event, we process every previous event to decide whether the new event can be booked.
    // Space complexity: O(N), the size of the calendar.
    public static class MyCalendar2BruteForce extends MyCalendar2 {

        private final List<Interval> allEvents = new ArrayList<>();
        private final List<Interval> doubleBookedEvents = new ArrayList<>();

        @Override
        public boolean book(int start, int end) {
            Interval newEvent = new Interval(start, end);
            for (Interval existingEvent : doubleBookedEvents) {
                if (overlap(existingEvent, newEvent)) {
                    // prevent triple booking
                    return false;
                }
            }

            // check if the new event causes double booking
            for (Interval existingEvent : allEvents) {
                if (overlap(existingEvent, newEvent)) {
                    int overlapStart = Math.max(start, existingEvent.start);
                    int overlapEnd = Math.min(end, existingEvent.end);
                    doubleBookedEvents.add(new Interval(overlapStart, overlapEnd));
                }
            }
            allEvents.add(newEvent);
            return true;
        }

        private boolean overlap(Interval event1, Interval event2) {
            // 2 events [start1, end1) and [start2, end2) do not conflict IFF one of them starts after the other one ends:
            // either end2 <= start1 || start2 >= end1.
            // Therefore, 2 event conflicts when
            // end2 > start1 && start2 < end1
            return (event2.end > event1.start) && (event2.start < event1.end);
        }

        private record Interval(int start, int end) {
            @Override
            public String toString() {
                return String.format("[%d, %d)", start, end);
            }
        }
    }

    public static class MyCalendar2BoundaryCount extends MyCalendar2 {
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
