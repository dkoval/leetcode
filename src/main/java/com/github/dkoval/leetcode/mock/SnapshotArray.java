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
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= length <= 5 * 10^4</li>
 *  <li>0 <= index < length</li>
 *  <li>0 <= val <= 10^9</li>
 *  <li>0 <= snap_id < (the total number of times we call snap())</li>
 *  <li>At most 5 * 10^4 calls will be made to set, snap, and get.</li>
 * </ul>
 */
public abstract class SnapshotArray {

    public SnapshotArray(int length) {
        // noop
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
        // arr[index]: snapId -> value
        private final NavigableMap<Integer, Integer>[] arr;
        private int snapId = 0;

        public SnapshotArrayBackedByTreeMap(int length) {
            super(length);
            arr = new NavigableMap[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new TreeMap<>();
                arr[i].put(0, 0);
            }
        }

        @Override
        public void set(int index, int val) {
            arr[index].put(snapId, val);
        }

        @Override
        public int snap() {
            return snapId++;
        }

        @Override
        public int get(int index, int snapId) {
            // find the maximum recorded snapId that is <= snapId
            return arr[index].floorEntry(snapId).getValue();
        }
    }

    public static class SnapshotArrayUsingBinarySearch extends SnapshotArray {
        // arr[index]: snapId -> value
        private final Snapshots[] arr;
        private int currSnapId = 0;

        public SnapshotArrayUsingBinarySearch(int length) {
            super(length);
            arr = new Snapshots[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new Snapshots();
                arr[i].items.add(new Snapshots.Item(0, 0));
            }
        }

        @Override
        public void set(int index, int val) {
            List<Snapshots.Item> snapshots = arr[index].items;
            Snapshots.Item last = snapshots.get(snapshots.size() - 1);
            if (last.snapId != currSnapId) {
                snapshots.add(new Snapshots.Item(currSnapId, val));
            } else {
                last.val = val;
            }
        }

        @Override
        public int snap() {
            return currSnapId++;
        }

        @Override
        public int get(int index, int snapId) {
            // snapId is a monotonically increasing function, therefore binary search can be applied to
            // find the maximum recorded snapId that is <= snapId (upper boundary)
            List<Snapshots.Item> snapshots = arr[index].items;
            int left = 0;
            int right = snapshots.size() - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (snapshots.get(mid).snapId <= snapId) {
                    // snapshots[mid] can be the answer;
                    // check if there's a better alternative to the right of `mid` index.
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return snapshots.get(left).val;
        }

        private static class Snapshots {
            final List<Item> items = new ArrayList<>();

            static class Item {
                final int snapId;
                int val;

                Item(int snapId, int val) {
                    this.snapId = snapId;
                    this.val = val;
                }
            }
        }
    }
}
