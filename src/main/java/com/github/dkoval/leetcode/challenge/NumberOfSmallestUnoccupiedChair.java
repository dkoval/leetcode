package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/">The Number of the Smallest Unoccupied Chair</a>
 * <p>
 * There is a party where n friends numbered from 0 to n - 1 are attending.
 * There is an infinite number of chairs in this party that are numbered from 0 to infinity.
 * When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.
 * <p>
 * For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
 * <p>
 * When a friend leaves the party, their chair becomes unoccupied at the moment they leave.
 * If another friend arrives at that same moment, they can sit in that chair.
 * <p>
 * You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi],
 * indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend.
 * All arrival times are distinct.
 * <p>
 * Return the chair number that the friend numbered targetFriend will sit on.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == times.length</li>
 *  <li>2 <= n <= 104</li>
 *  <li>times[i].length == 2</li>
 *  <li>1 <= arrivali < leavingi <= 10^5</li>
 *  <li>0 <= targetFriend <= n - 1</li>
 *  <li>Each arrivali time is distinct</li>
 * </ul>
 */
public interface NumberOfSmallestUnoccupiedChair {

    int smallestChair(int[][] times, int targetFriend);

    class NumberOfSmallestUnoccupiedChairRev1 implements NumberOfSmallestUnoccupiedChair {

        @Override
        public int smallestChair(int[][] times, int targetFriend) {
            int n = times.length;

            // sort times[] by arrival time
            Friend[] friends = new Friend[n];
            for (int i = 0; i < n; i++) {
                friends[i] = new Friend(i, times[i][0], times[i][1]);
            }

            Arrays.sort(friends, Comparator.comparingInt(it -> it.arriveAt));

            // min heap #1 keeps available chairs sorted by their number;
            // it allows to grab the first unoccupied chair with the smallest number
            Queue<Integer> availableChairs = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                availableChairs.offer(i);
            }

            // min heap #2 keeps used chairs sorted by the occupiedUntil time;
            // when a friend takes a chair, that chair's occupied until time is set to
            // the friend's leaving time
            Queue<Chair> usedChairs = new PriorityQueue<>(Comparator.comparingInt(it -> it.occupiedUntil));

            for (Friend friend : friends) {
                // make some chairs available again
                while (!usedChairs.isEmpty() && usedChairs.peek().occupiedUntil <= friend.arriveAt) {
                    Chair chair = usedChairs.poll();
                    availableChairs.offer(chair.id);
                }

                int chair = availableChairs.poll();
                if (friend.id == targetFriend) {
                    return chair;
                }
                usedChairs.offer(new Chair(chair, friend.leaveAt));
            }
            return -1;
        }

        private record Friend(int id, int arriveAt, int leaveAt) {
        }

        private record Chair(int id, int occupiedUntil) {
        }
    }
}
