package com.github.dkoval.leetcode.challenge;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/">K-th Smallest Prime Fraction</a>
 * <p>
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique.
 * You are also given an integer k.
 * <p>
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
 * <p>
 * Return the kth smallest fraction considered. Return your answer as an array of integers of size 2,
 * where answer[0] == arr[i] and answer[1] == arr[j].
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= arr.length <= 1000</li>
 *  <li>1 <= arr[i] <= 3 * 10^4</li>
 *  <li>arr[0] == 1</li>
 *  <li>arr[i] is a prime number for i > 0</li>
 *  <li>All the numbers of arr are unique and sorted in strictly increasing order</li>
 *  <li>1 <= k <= arr.length * (arr.length - 1) / 2</li>
 * <ul>
 * Follow up: Can you solve the problem with better than O(n^2) complexity?
 */
public interface KthSmallestPrimeFraction {

    int[] kthSmallestPrimeFraction(int[] arr, int k);

    // O(N^2) time | O(K) space
    class KthSmallestPrimeFractionRev1 implements KthSmallestPrimeFraction {

        @Override
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;

            // max heap
            Queue<Rational> q = new PriorityQueue<>((r1, r2) -> -1 * r1.compareTo(r2));
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    q.offer(new Rational(arr[i], arr[j]));
                    if (q.size() > k) {
                        q.poll();
                    }
                }
            }

            // k >= 1
            Rational smallest = q.iterator().next();
            return new int[]{smallest.p, smallest.q};
        }

        private record Rational(int p, int q) implements Comparable<Rational> {

            public int compareTo(Rational that) {
                // Need to compare:
                // p1 / q1 vs p2 / q2
                // <=>
                // p1 * q2 / q1 * q2 vs p2 * q1 / q1 * q2
                // <=> comparing:
                // p1 * q2 vs p2 * q1
                long lhs = (long) p * that.q;
                long rhs = (long) that.p * q;
                return Long.compare(lhs, rhs);
            }
        }
    }
}
