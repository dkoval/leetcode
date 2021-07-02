package com.github.dkoval.leetcode.challenge;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3800/">Find K Closest Elements</a>
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <pre>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * </pre>
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int idx = indexOfFirstSmallerElement(arr, x);

        // expand out from idx
        int left = idx;
        int right = idx + 1;

        LinkedList<Integer> result = new LinkedList<>();
        while (result.size() < k && left >= 0 && right < n) {
            if (x - arr[left] <= arr[right] - x) {
                result.addFirst(arr[left]);
                left--;
            } else {
                result.addLast(arr[right]);
                right++;
            }
        }

        while (result.size() < k && left >= 0) {
            result.addFirst(arr[left]);
            left--;
        }

        while (result.size() < k && right < n) {
            result.addLast(arr[right]);
            right++;
        }

        return result;
    }

    private int indexOfFirstSmallerElement(int[] arr, int target) {
        // use binary search, since arr[] is sorted
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
