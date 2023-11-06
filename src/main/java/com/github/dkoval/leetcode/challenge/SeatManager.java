package com.github.dkoval.leetcode.challenge;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/seat-reservation-manager/">Seat Reservation Manager</a>
 * <p>
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
 * <p>
 * Implement the SeatManager class:
 * <ul>
 *  <li>SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.</li>
 *  <li>int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.</li>
 *  <li>void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= seatNumber <= n</li>
 *  <li>For each call to reserve, it is guaranteed that there will be at least one unreserved seat.</li>
 *  <li>For each call to unreserve, it is guaranteed that seatNumber will be reserved.</li>
 *  <li>At most 10^5 calls in total will be made to reserve and unreserve.</li>
 * </ul>
 */
public abstract class SeatManager {

    public SeatManager(int n) {
        // noop
    }

    public abstract int reserve();

    public abstract void unreserve(int seatNumber);

    static class SeatManagerRev1 extends SeatManager {
        private final SortedSet<Integer> availableSeats = new TreeSet<>();

        public SeatManagerRev1(int n) {
            super(n);
            for (int i = 1; i <= n; i++) {
                availableSeats.add(i);
            }
        }

        @Override
        public int reserve() {
            // returns the lowest element currently in this set
            int reservedSeatNumber = availableSeats.first();
            availableSeats.remove(reservedSeatNumber);
            return reservedSeatNumber;
        }

        @Override
        public void unreserve(int seatNumber) {
            availableSeats.add(seatNumber);
        }
    }
}
