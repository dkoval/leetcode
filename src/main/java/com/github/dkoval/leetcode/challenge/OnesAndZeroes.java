package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3694/">Ones and Zeroes</a>
 * <p>
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public interface OnesAndZeroes {

    int findMaxForm(String[] strs, int m, int n);

    class OnesAndZeroesDPTopDown implements OnesAndZeroes {

        private static final class Key {
            final int idx;
            final int count0;
            final int count1;

            Key(int idx, int count0, int count1) {
                this.idx = idx;
                this.count0 = count0;
                this.count1 = count1;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Key that = (Key) o;
                return idx == that.idx && count0 == that.count0 && count1 == that.count1;
            }

            @Override
            public int hashCode() {
                return Objects.hash(idx, count0, count1);
            }
        }

        @Override
        public int findMaxForm(String[] strs, int m, int n) {
            // count[i][0] - the number of 0's in strs[i]
            // count[i][1] - the number of 1's in strs[i]
            int[][] count = new int[strs.length][2];
            for (int i = 0; i < strs.length; i++) {
                count[i] = countZerosAndOnes(strs[i]);
            }

            // DP top-down
            return doFindMaxForm(strs, 0, m, n, count, new HashMap<>());
        }

        private int doFindMaxForm(String[] strs, int idx, int count0, int count1, int[][] count, Map<Key, Integer> memo) {
            if (idx == strs.length) {
                return 0;
            }

            Key key = new Key(idx, count0, count1);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int best = 0;
            // option #1: include strs[idx] in the subset
            if (count0 >= count[idx][0] && count1 >= count[idx][1]) {
                best = Math.max(best, 1 + doFindMaxForm(strs, idx + 1, count0 - count[idx][0], count1 - count[idx][1], count, memo));
            }
            // option #2: skip strs[idx]
            best = Math.max(best, doFindMaxForm(strs, idx + 1, count0, count1, count, memo));

            memo.put(key, best);
            return best;
        }

        private int[] countZerosAndOnes(String str) {
            int n = str.length();
            int[] count = new int[2];
            for (int i = 0; i < n; i++) {
                count[str.charAt(i) - '0']++;
            }
            return count;
        }
    }

    class OnesAndZeroesDPBottomUp implements OnesAndZeroes {

        // O(L * M * N) time | O(M * N) space
        public int findMaxForm(String[] strs, int m, int n) {
            // dp[i][j] - best result given i 0s and j 1s
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                int[] count = countZerosAndOnes(str);
                for (int zero = m; zero >= count[0]; zero--) {
                    for (int one = n; one >= count[1]; one--) {
                        // case #1: accept str
                        int accept = 1 + dp[zero - count[0]][one - count[1]];
                        // case #2: reject str
                        int reject = dp[zero][one];
                        dp[zero][one] = Math.max(accept, reject);
                    }
                }
            }
            return dp[m][n];
        }

        private int[] countZerosAndOnes(String str) {
            int[] count = new int[2];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                count[c - '0']++;
            }
            return count;
        }
    }
}
