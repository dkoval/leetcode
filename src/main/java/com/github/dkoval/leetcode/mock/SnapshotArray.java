package com.github.dkoval.leetcode.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/snapshot-array/">Snapshot Array</a>
 * <p>
 * Implement a SnapshotArray that supports the following interface:
 * <ul>
 *     <li>SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.</li>
 *     <li>void set(index, val) sets the element at the given index to be equal to val.</li>
 *     <li>int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.</li>
 *     <li>int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id</li>
 * </ul>
 */
public abstract class SnapshotArray {

    public SnapshotArray(int length) {
    }

    public abstract void set(int index, int val);

    public abstract int snap();

    public abstract int get(int index, int snapId);

    public static class SnapshotArrayMemoryInefficient extends SnapshotArray {
        private final Map<Integer, Map<Integer, Integer>> snapshot = new HashMap<>();
        private int snapshotId = 0;

        public SnapshotArrayMemoryInefficient(int length) {
            super(length);
        }

        @Override
        public void set(int index, int val) {
            snapshot.computeIfAbsent(snapshotId, k -> new HashMap<>()).put(index, val);
        }

        @Override
        public int snap() {
            return snapshotId++;
        }

        @Override
        public int get(int index, int snapId) {
            Integer val;
            do {
                Map<Integer, Integer> indexedVal = snapshot.get(snapId);
                val = indexedVal != null ? indexedVal.get(index) : null;
            } while (val == null && snapId-- > 0);
            return val != null ? val : 0;
        }
    }
}
