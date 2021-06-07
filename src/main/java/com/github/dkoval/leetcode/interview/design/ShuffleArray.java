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
    private int[] nums;
    private final int[] original;
    private final Random rand = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.nums = Arrays.copyOf(original, original.length);
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // Fisher-Yates algorithm
        for (int i = 0; i < nums.length; i++) {
            // Note that it is possible to swap an element with itself
            swap(nums, i, randomIntFromRange(i, nums.length));
        }
        return nums;
    }

    private int randomIntFromRange(int min, int max) {
        return min + rand.nextInt(max - min);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
