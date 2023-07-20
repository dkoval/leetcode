package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision/">Asteroid Collision</a>
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= asteroids.length <= 10^4</li>
 *  <li>-1000 <= asteroids[i] <= 1000</li>
 *  <li>asteroids[i] != 0</li>
 * </ul>
 */
public interface AsteroidCollision {

    int[] asteroidCollision(int[] asteroids);

    class AsteroidCollisionRev1 implements AsteroidCollision {

        @Override
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> result = new ArrayDeque<>();
            int i = 0;
            while (i < asteroids.length) {
                int curr = asteroids[i];
                if (result.isEmpty() || curr > 0 || result.peekLast() < 0) {
                    result.addLast(curr);
                } else {
                    // collision
                    int prev = result.peekLast();
                    if (prev <= -curr) {
                        result.pollLast();
                    }
                    if (prev < -curr) {
                        // let `curr` asteroid move to the left
                        i--;
                    }
                }
                i++;
            }
            int[] arr = new int[result.size()];
            i = 0;
            while (!result.isEmpty()) {
                arr[i++] = result.pollFirst();
            }
            return arr;
        }
    }

    class AsteroidCollisionRev2 implements AsteroidCollision {

        @Override
        public int[] asteroidCollision(int[] asteroids) {
            int n = asteroids.length;

            Deque<Integer> stack = new ArrayDeque<>();
            for (int x : asteroids) {
                // the current asteroid may be potentially destroyed
                boolean destroyed = false;
                // process a collision, if there is any
                while (!destroyed && !stack.isEmpty() && collide(stack.peek(), x)) {
                    int curr = Math.abs(x);
                    int top = Math.abs(stack.peek());
                    if (curr > top) {
                        stack.pop();
                    } else {
                        destroyed = true;
                        if (curr == top) {
                            stack.pop();
                        }
                    }
                }

                if (!destroyed) {
                    stack.push(x);
                }
            }

            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }

        private boolean collide(int x, int y) {
            // + / -
            // -> / <-
            return x > 0 && y < 0;
        }
    }
}
