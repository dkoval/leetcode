package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public interface MyCalendar1 {

    boolean book(int start, int end);

    class MyCalendar1BruteForce implements MyCalendar1 {

        private static class Interval {
            final int start;
            final int end;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        // PriorityQueue is used here to keep bookings sorted by their start time
        private final PriorityQueue<Interval> bookings = new PriorityQueue<>(
                Comparator.comparingInt(booking -> booking.start));

        @Override
        public boolean book(int start, int end) {
            Interval newBooking = new Interval(start, end);
            for (Interval existingBooking : bookings) {
                if (overlaps(existingBooking, newBooking)) {
                    return false;
                }
            }
            bookings.add(newBooking);
            return true;
        }

        private boolean overlaps(Interval booking1, Interval booking2) {
            return (booking2.start < booking1.end) && (booking2.end > booking1.start);
        }
    }
}
