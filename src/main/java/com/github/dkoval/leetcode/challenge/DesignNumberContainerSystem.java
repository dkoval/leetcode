package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/design-a-number-container-system/">Design a Number Container System</a>
 * <p>
 * Design a number container system that can do the following:
 * <ul>
 *  <li>Insert or Replace a number at the given index in the system.</li>
 *  <li>Return the smallest index for the given number in the system.</li>
 * </ul>
 * Implement the NumberContainers class:
 * <ul>
 *  <li>NumberContainers() Initializes the number container system.</li>
 *  <li>void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.</li>
 *  <li>int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= index, number <= 10^9</li>
 *  <li>At most 10^5 calls will be made in total to change and find.</li>
 * </ul>
 */
public interface DesignNumberContainerSystem {

    interface NumberContainers {
        void change(int index, int number);

        int find(int number);
    }

    class NumberContainersRev1 implements NumberContainers {
        // index -> num
        private final Map<Integer, Integer> nums = new HashMap<>();
        // num -> sorted indices
        private final Map<Integer, SortedSet<Integer>> indices = new HashMap<>();

        @Override
        public void change(int index, int number) {
            if (nums.containsKey(index)) {
                var prev = nums.get(index);
                var idxs = indices.get(prev);
                if (idxs.size() > 1) {
                    idxs.remove(index);
                } else {
                    indices.remove(prev);
                }
            }
            nums.put(index, number);
            indices.computeIfAbsent(number, __ -> new TreeSet<>()).add(index);
        }

        @Override
        public int find(int number) {
            if (indices.containsKey(number)) {
                return indices.get(number).first();
            }
            return -1;
        }
    }
}
