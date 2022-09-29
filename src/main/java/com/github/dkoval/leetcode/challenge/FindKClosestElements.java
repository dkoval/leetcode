package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements/">Find K Closest Elements</a>
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <pre>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * </pre>
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= arr.length</li>
 *  <li>1 <= arr.length <= 10^4</li>
 *  <li>arr is sorted in ascending order</li>
 *  <li>-10^4 <= arr[i], x <= 10^4</li>
 * </ul>
 */
public interface FindKClosestElements {

    List<Integer> findClosestElements(int[] arr, int k, int x);

    class FindKClosestElementsUsingMaxHeap implements FindKClosestElements {

        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            Comparator<Integer> cmp = (a, b) -> {
                int d1 = Math.abs(a - x);
                int d2 = Math.abs(b - x);
                return (d1 == d2) ? Integer.compare(a, b) : Integer.compare(d1, d2);
            };

            // max heap
            Queue<Integer> pq = new PriorityQueue<>(cmp.reversed());
            for (int num : arr) {
                pq.offer(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<Integer> ans = new ArrayList<>(pq);
            Collections.sort(ans);
            return ans;
        }
    }

    class FindKClosestElementsUsingBinarySearch implements FindKClosestElements {

        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int n = arr.length;

            // use binary search to find the index of the largest arr[i] < x
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (arr[mid] >= x) {
                    right = mid - 1;
                } else {
                    // mid is a possible solution;
                    // check if there is a better option to the right of index mid
                    left = mid;
                }
            }

            int idx = right;
            LinkedList<Integer> ans = new LinkedList<>();

            // expand outwards from idx
            left = idx;
            right = idx + 1;
            while (ans.size() < k && left >= 0 && right < n) {
                if (x - arr[left] <= arr[right] - x) {
                    ans.addFirst(arr[left]);
                    left--;
                } else {
                    ans.addLast(arr[right]);
                    right++;
                }
            }

            while (ans.size() < k && left >= 0) {
                ans.addFirst(arr[left]);
                left--;
            }

            while (ans.size() < k && right < n) {
                ans.addLast(arr[right]);
                right++;
            }

            return ans;
        }
    }
}
