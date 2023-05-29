package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/">Minimum Cost to Cut a Stick (Hard)</a>
 * <p>
 * Given a wooden stick of length n units. The stick is labelled from 0 to n.
 * <p>
 * Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
 * <p>
 * You should perform the cuts in order, you can change the order of the cuts as you wish.
 * <p>
 * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
 * When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut).
 * Please refer to the first example for a better explanation.
 * <p>
 * Return the minimum total cost of the cuts.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= n <= 10^6</li>
 *  <li>1 <= cuts.length <= min(n - 1, 100)</li>
 *  <li>1 <= cuts[i] <= n - 1</li>
 *  <li>All the integers in cuts array are distinct.</li>
 * </ul>
 */
public interface MinimumCostToCutStick {

    int minCost(int n, int[] cuts);

    class MinimumCostToCutStickDPTopDownRev1 implements MinimumCostToCutStick {

        @Override
        public int minCost(int n, int[] cuts) {
            // DP top-down
            Map<Key, Integer> dp = new HashMap<>();
            return calculate(cuts, 0, n, dp);
        }

        private int calculate(int[] cuts, int left, int right, Map<Key, Integer> dp) {
            if (right - left == 1) {
                // can't further cut a stick of length 1
                return 0;
            }

            // already solved?
            Key key = new Key(left, right);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            int best = Integer.MAX_VALUE;
            int cost = right - left;
            for (int x : cuts) {
                if (x > left && x < right) {
                    // cut the current [left : right] stick  at position x
                    best = Math.min(best, cost + calculate(cuts, left, x, dp) + calculate(cuts, x, right, dp));
                }
            }

            if (best == Integer.MAX_VALUE) {
                best = 0;
            }

            dp.put(key, best);
            return best;
        }

        private static class Key {
            final int left;
            final int right;

            Key(int left, int right) {
                this.left = left;
                this.right = right;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (left == that.left) && (right == that.right);
            }

            public int hashCode() {
                return Objects.hash(left, right);
            }
        }
    }


    class MinimumCostToCutStickDPTopDownRev2 implements MinimumCostToCutStick {

        @Override
        public int minCost(int n, int[] cuts) {
            // arrange cut positions
            Arrays.sort(cuts);

            int l = cuts.length;
            int[] newCuts = new int[l + 2];
            newCuts[0] = 0;
            for (int i = 1; i <= l; i++) {
                newCuts[i] = cuts[i - 1];
            }
            newCuts[l + 1] = n;

            Integer[][] dp = new Integer[l + 2][l + 2];
            return calculate(newCuts, 0, l + 1, dp);
        }

        private int calculate(int[] cuts, int left, int right, Integer[][] dp) {
            if (left + 1 >= right) {
                return 0;
            }

            // already solved?
            if (dp[left][right] != null) {
                return dp[left][right];
            }

            int best = Integer.MAX_VALUE;
            int cost = cuts[right] - cuts[left];
            for (int i = left + 1; i < right; i++) {
                best = Math.min(best, cost + calculate(cuts, left, i, dp) + calculate(cuts, i, right, dp));
            }
            return dp[left][right] = best;
        }
    }
}
