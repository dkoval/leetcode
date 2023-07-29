package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/soup-servings/">Soup Servings</a>
 * <p>
 * There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds of operations:
 * <ul>
 *  <li>Serve 100 ml of soup A and 0 ml of soup B,</li>
 *  <li>Serve 75 ml of soup A and 25 ml of soup B,</li>
 *  <li>Serve 50 ml of soup A and 50 ml of soup B, and</li>
 *  <li>Serve 25 ml of soup A and 75 ml of soup B.</li>
 * </ul>
 * When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four operations
 * with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as possible.
 * We stop once we no longer have some quantity of both types of soup.
 * <p>
 * Note that we do not have an operation where all 100 ml's of soup B are used first.
 * <p>
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
 * Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 10^9
 */
public interface SoupServings {

    double soupServings(int n);

    class SoupServingsRev1 implements SoupServings {

        private static final List<Double> ans = new ArrayList<>();

        // precompute answers
        static {
            // terminate as soon as the answer becomes equal to 1.0
            Map<Key, Double> dp = new HashMap<>();
            int i = 0;
            while (true) {
                double res = calculate(i, i, dp);
                if (1 - res < 1e-5) {
                    break;
                }
                ans.add(res);
                i++;
            }
        }

        private static double calculate(int a, int b, Map<Key, Double> dp) {
            if (a <= 0 && b <= 0) {
                return 0.5;
            }

            if (a <= 0) {
                return 1.0;
            }

            if (b <= 0) {
                return 0.0;
            }

            // already solved?
            Key key = new Key(a, b);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            // step = i * 25 ml
            double p = 0.0;
            for (int i = 4; i > 0; i--) {
                p += calculate(a - i, b - (4 - i), dp);
            }
            p /= 4;

            // cache and return the answer
            dp.put(key, p);
            return p;
        }

        @Override
        public double soupServings(int n) {
            // scale in the input by the ratio = 25 ml (round up)
            // div_round_up(x, y) = (x + y - 1) / y
            n = (n + 24) / 25;
            return n < ans.size() ? ans.get(n) : 1.0;
        }

        private static class Key {
            final int a;
            final int b;

            Key(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || o.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) o;
                return (a == that.a) && (b == that.b);
            }

            public int hashCode() {
                return Objects.hash(a, b);
            }
        }
    }
}
