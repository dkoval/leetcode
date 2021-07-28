package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3829/">Beautiful Array (Notoriously Difficult!)</a>
 * <p>
 * For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
 * <p>
 * For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
 * <p>
 * Given n, return any beautiful array nums. (It is guaranteed that one exists.)
 */
public class BeautifulArray {

    // Resources:
    // https://www.programmersought.com/article/705430618/
    // https://leetcode.com/problems/beautiful-array/discuss/186679/C++JavaPython-Odd-+-Even-Pattern-O(N)
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < n) {
            // new result is a concatenation of odd and even numbers
            // generated from the previous result (order of concatenation doesn't matter)
            List<Integer> newResult = new ArrayList<>();

            // generate odd numbers
            for (int x : result) {
                int odd = 2 * x - 1;
                if (odd <= n) {
                    newResult.add(odd);
                }
            }

            // generate even numbers
            for (int x : result) {
                int even = 2 * x;
                if (even <= n) {
                    newResult.add(even);
                }
            }

            // update the result
            result = newResult;
        }
        return toArray(result);
    }

    private int[] toArray(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        int i = 0;
        for (int x : nums) {
            arr[i++] = x;
        }
        return arr;
    }
}
