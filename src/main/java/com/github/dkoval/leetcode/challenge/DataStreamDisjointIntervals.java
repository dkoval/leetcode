package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/data-stream-as-disjoint-intervals/">Data Stream as Disjoint Intervals (Hard)</a>
 * <p>
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * Implement the SummaryRanges class:
 * <ul>
 *  <li>SummaryRanges() Initializes the object with an empty stream.</li>
 *  <li>void addNum(int value) Adds the integer value to the stream.</li>
 *  <li>int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= value <= 10^4</li>
 *  <li>At most 3 * 104 calls will be made to addNum and getIntervals.</li>
 * </ul>
 * <p>
 * Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
 */
public interface DataStreamDisjointIntervals {

    interface SummaryRanges {
        void addNum(int value);

        int[][] getIntervals();
    }

    class DataStreamDisjointIntervalsNaive implements DataStreamDisjointIntervals, SummaryRanges {
        final SortedSet<Integer> seen = new TreeSet<>();

        // O(logN) time
        @Override
        public void addNum(int value) {
            seen.add(value);
        }

        // O(N) time
        @Override
        public int[][] getIntervals() {
            List<int[]> ans = new ArrayList<>();
            for (int x : seen) {
                if (ans.isEmpty()) {
                    ans.add(new int[]{x, x});
                    continue;
                }

                int[] last = ans.get(ans.size() - 1);
                if (x > last[1] + 1) {
                    // start a new interval
                    ans.add(new int[]{x, x});
                } else {
                    last[1] = x;
                }
            }
            return ans.toArray(int[][]::new);
        }
    }
}
