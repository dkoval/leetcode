package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public interface MyCalendar1 {

    boolean book(int start, int end);

    class MyCalendar1BruteForce implements MyCalendar1 {
        // PriorityQueue is used here to keep bookings sorted by their start time
        private final PriorityQueue<Interval> bookings = new PriorityQueue<>(
                Comparator.comparingInt(booking -> booking.start));

        private static class Interval {
            final int start;
            final int end;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

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

    class MyCalendar1UsingTreeMap implements MyCalendar1 {
        private final TreeMap<Integer, Integer> bookings = new TreeMap<>();

        @Override
        public boolean book(int start, int end) {
            Integer prevBookingStart = bookings.floorKey(start);
            if (prevBookingStart != null && bookings.get(prevBookingStart) > start) {
                return false;
            }

            Integer nextBookingEnd = bookings.ceilingKey(start);
            if (nextBookingEnd != null && end > nextBookingEnd) {
                return false;
            }

            bookings.put(start, end);
            return true;
        }
    }
}
