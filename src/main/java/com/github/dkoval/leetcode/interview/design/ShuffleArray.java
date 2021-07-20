package com.github.dkoval.leetcode.interview.design;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/shuffle-an-array/">Shuffle an Array</a>
 * <p>
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * <p>
 * Implement the Solution class:
 * <ul>
 *  <li>Solution(int[] nums) Initializes the object with the integer array nums.</li>
 *  <li>int[] reset() Resets the array to its original configuration and returns it.</li>
 *  <li>int[] shuffle() Returns a random shuffling of the array.</li>
 * </ul>
 */
public class ShuffleArray {
    private final int[] nums;
    private final int[] orig;
    private final Random rand = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.orig = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        System.arraycopy(orig, 0, nums, 0, orig.length);
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // Fisher-Yates algorithm
        for (int i = 0; i < nums.length; i++) {
            // Note that it is possible to swap an element with itself
            swap(nums, i, randomIntFromRange(i, nums.length - 1));
        }
        return nums;
    }

    private int randomIntFromRange(int lo, int hi) {
        // Random.nextInt() returns a random int between 0 (inclusive) and 1 (exclusive),
        // therefore we add + 1 here to make `hi` boundary inclusive
        return lo + rand.nextInt(hi - lo + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
