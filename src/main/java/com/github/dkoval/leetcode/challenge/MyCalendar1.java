package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3774/">My Calendar I</a>
 * <p>
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause
 * a double booking.
 * <p>
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval
 * [start, end), the range of real numbers x such that start <= x < end.
 * <p>
 * A double booking happens when two events have some non-empty intersection
 * (ie., there is some time that is common to both events.)
 * <p>
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully
 * without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * <p>
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 */
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

            Integer nextBookingStart = bookings.ceilingKey(start);
            if (nextBookingStart != null && end > nextBookingStart) {
                return false;
            }

            bookings.put(start, end);
            return true;
        }
    }

    class MyCalendar1UsingTreeSet implements MyCalendar1 {
        private final TreeSet<Interval> bookings = new TreeSet<>(
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

            Interval prevBooking = bookings.floor(newBooking);
            if (prevBooking != null && prevBooking.end > newBooking.start) {
                return false;
            }

            Interval nextBooking = bookings.ceiling(newBooking);
            if (nextBooking != null && newBooking.end > nextBooking.start) {
                return false;
            }

            bookings.add(newBooking);
            return true;
        }
    }
}
