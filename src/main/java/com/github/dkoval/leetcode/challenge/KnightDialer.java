package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/knight-dialer/">Knight Dialer</a>
 * <p>
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically (with both forming the shape of an L).
 * <p>
 * A chess knight can move as indicated in the chess diagram below:
 * <pre>
 * <img src="https://assets.leetcode.com/uploads/2020/08/18/chess.jpg"/>
 * </pre>
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 * <pre>
 * <img src="https://assets.leetcode.com/uploads/2020/08/18/phone.jpg"/>
 * </pre>
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * <p>
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n.
 * All jumps should be valid knight jumps.
 * <p>
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 5000
 */
public interface KnightDialer {

    int MOD = 1_000_000_007;

    int knightDialer(int n);

    class KnightDialerDPTopDownRev1 implements KnightDialer {

        @Override
        public int knightDialer(int n) {
            Map<Integer, List<Integer>> moves = Map.of(
                    0, List.of(4, 6),
                    1, List.of(6, 8),
                    2, List.of(7, 9),
                    3, List.of(4, 8),
                    4, List.of(0, 3, 9),
                    5, List.of(),
                    6, List.of(0, 1, 7),
                    7, List.of(2, 6),
                    8, List.of(1, 3),
                    9, List.of(2, 4)
            );

            int count = 0;
            Map<Key, Integer> dp = new HashMap<>();
            for (int x = 0; x <= 9; x++) {
                count += calculate(moves, n, x, 1, dp);
                count %= MOD;
            }
            return count;
        }

        private int calculate(Map<Integer, List<Integer>> moves, int n, int last, int length, Map<Key, Integer> dp) {
            // base case
            if (length == n) {
                return 1;
            }

            // already solved?
            Key key = new Key(last, length);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            int count = 0;
            for (int x : moves.get(last)) {
                count += calculate(moves, n, x, length + 1, dp);
                count %= MOD;
            }

            dp.put(key, count);
            return count;
        }

        private static class Key {
            final int x1;
            final int x2;

            Key(int x1, int x2) {
                this.x1 = x1;
                this.x2 = x2;
            }

            @Override
            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (x1 == that.x1) && (x2 == that.x2);
            }

            @Override
            public int hashCode() {
                return Objects.hash(x1, x2);
            }
        }
    }
}
