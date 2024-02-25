package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/greatest-common-divisor-traversal/">Greatest Common Divisor Traversal (Hard)</a>
 * <p>
 * You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices.
 * You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1,
 * where gcd is the greatest common divisor.
 * <p>
 * Your task is to determine if for every pair of indices i and j in nums, where i < j,
 * there exists a sequence of traversals that can take us from i to j.
 * <p>
 * Return true if it is possible to traverse between all such pairs of indices, or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface GreatestCommonDivisorTraversal {

    boolean canTraverseAllPairs(int[] nums);

    class GreatestCommonDivisorTraversalRev1 implements GreatestCommonDivisorTraversal {

        @Override
        public boolean canTraverseAllPairs(int[] nums) {
            int n = nums.length;

            // idea: if two numbers x and y share a common prime factor, then
            // gcd(x, y) is always > 1

            // step #1: prime factorization
            // factor -> index of value in nums[] (storing the index i instead of nums[i] aims at handling duplicate numbers)
            Map<Integer, List<Integer>> primes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // brute force prime factorization (passes the test suite though);
                // a better alternative would be to use the sieve of Eratosthenes algorithm
                int v = nums[i];
                for (int factor = 2; factor * factor <= nums[i]; factor++) {
                    if (v == 1) {
                        break;
                    }

                    if (v % factor == 0) {
                        primes.computeIfAbsent(factor, __ -> new ArrayList<>()).add(i);
                        while (v % factor == 0) {
                            v /= factor;
                        }
                    }
                }

                // corner case
                if (v != 1) {
                    // we know that v is definitely is a prime factor of nums[i]
                    primes.computeIfAbsent(v, __ -> new ArrayList<>()).add(i);
                }
            }

            // step #2: connect values for each prime factor in factorization,
            // this is where Union-Find DS comes into play
            UnionFind uf = new UnionFind(n);
            for (List<Integer> indices : primes.values()) {
                for (int i = 1; i < indices.size(); i++) {
                    uf.union(indices.get(i), indices.get(i - 1));
                }
            }

            return uf.count == 1;
        }

        private static class UnionFind {
            final int[] parent;
            int count;

            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
                count = n;
            }

            int find(int x) {
                if (x != parent[x]) {
                    // path compression
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);

                if (px == py) {
                    return false;
                }

                parent[px] = py;
                count--;
                return true;
            }
        }
    }
}
