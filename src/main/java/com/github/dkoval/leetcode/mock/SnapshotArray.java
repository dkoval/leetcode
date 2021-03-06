package com.github.dkoval.leetcode.mock;

import java.util.*;

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

    public static class SnapshotArrayBackedByNestedMap extends SnapshotArray {
        // snapId -> (index, val)
        private final Map<Integer, Map<Integer, Integer>> snapshot = new HashMap<>();
        private int snapId = 0;

        public SnapshotArrayBackedByNestedMap(int length) {
            super(length);
        }

        @Override
        public void set(int index, int val) {
            snapshot.computeIfAbsent(snapId, k -> new HashMap<>()).put(index, val);
        }

        @Override
        public int snap() {
            return snapId++;
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

    public static class SnapshotArrayBackedByTreeMap extends SnapshotArray {
        private static final int DUMMY_SNAP_ID = -1;
        private static final int INIT_VALUE = 0;

        // arr[index] is a map of (snapId, val) pairs
        private final List<NavigableMap<Integer, Integer>> arr;
        private int snapId = 0;

        public SnapshotArrayBackedByTreeMap(int length) {
            super(length);
            this.arr = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                NavigableMap<Integer, Integer> revisions = new TreeMap<>();
                revisions.put(DUMMY_SNAP_ID, INIT_VALUE);
                arr.add(revisions);
            }
        }

        @Override
        public void set(int index, int val) {
            arr.get(index).put(snapId, val);
        }

        @Override
        public int snap() {
            return snapId++;
        }

        @Override
        public int get(int index, int snapId) {
            return arr.get(index).floorEntry(snapId).getValue();
        }
    }
}
