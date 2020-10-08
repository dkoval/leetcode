package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3487/">Two Sum III - Data structure design</a>
 * <p>
 * Design a data structure that accepts integers of a stream, and checks if it has a pair of integers
 * that sum up to a particular value.
 * <p>
 * Implement a TwoSum class:
 * <p>
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value,
 * otherwise, it returns false.
 */
public class TwoSum3 {

    // Time Complexity:
    //
    // - For the add(number): O(1), since it takes a constant time to update an entry in hashtable.
    // - For the find(value): O(N), where N is the total number of unique numbers.
    // In the worst case, we would iterate through the entire table.
    //
    // Space Complexity: O(N), where N is the total number of unique numbers.

    private final Map<Integer, Integer> nums = new HashMap<>();

    /** Add the number to an internal data structure. */
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int x : nums.keySet()) {
            int y = value - x;
            Integer count = nums.get(y);
            if (count != null && (x != y || count > 1)) {
                return true;
            }
        }
        return false;
    }
}
