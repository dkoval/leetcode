package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/two-best-non-overlapping-events/">Two Best Non-Overlapping Events</a>
 * <p>
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
 * You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
 * <p>
 * Return this maximum sum.
 * <p>
 * Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and
 * the other ends at the same time. More specifically, if you attend an event with end time t,
 * the next event must start at or after t + 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>>2 <= events.length <= 10^5</li>
 *  <li>>events[i].length == 3</li>
 *  <li>>1 <= startTimei <= endTimei <= 10^9</li>
 *  <li>>1 <= valuei <= 10^6</li>
 * </ul>
 */
public interface TwoBestNonOverlappingEvents {

    int maxTwoEvents(int[][] events);

    class TwoBestNonOverlappingEventsRev1 implements TwoBestNonOverlappingEvents {

        @Override
        public int maxTwoEvents(int[][] events) {
            // sort events by the starting point in ASC order
            Arrays.sort(events, Comparator.comparingInt(it -> it[0]));

            var bestPrev = Integer.MIN_VALUE;
            var best = Arrays.stream(events)
                    .mapToInt(it -> it[2])
                    .max()
                    .orElseThrow();

            Queue<EventInfo> minHeap = new PriorityQueue<>(Comparator.comparingInt(it -> it.endedAt));
            for (var event : events) {
                // check all events ending BEFORE the current one
                while (!minHeap.isEmpty() && minHeap.peek().endedAt < event[0]) {
                    var prev = minHeap.poll();
                    bestPrev = Math.max(bestPrev, prev.value);
                }
                minHeap.offer(new EventInfo(event[1], event[2]));
                best = Math.max(best, bestPrev + event[2]);
            }
            return best;
        }

        private record EventInfo(int endedAt, int value) {
        }
    }

    class TwoBestNonOverlappingEventsRev2 implements TwoBestNonOverlappingEvents {

        @Override
        public int maxTwoEvents(int[][] events) {
            // sort events by the startTime
            Arrays.sort(events, Comparator.comparingInt(it -> it[0]));

            // sort events by the endTime
            final var minHeap = new PriorityQueue<Event>(Comparator.comparingInt(it -> it.endedAt));

            var best = 0;
            var prevBest = 0;
            for (var event : events) {
                // check all events ending before the current one
                while (!minHeap.isEmpty() && minHeap.peek().endedAt < event[0]) {
                    prevBest = Math.max(prevBest, minHeap.poll().value);
                }
                minHeap.offer(new Event(event[1], event[2]));
                best = Math.max(best, prevBest + event[2]);
            }
            return best;
        }

        record Event(int endedAt, int value) {
        }
    }
}
