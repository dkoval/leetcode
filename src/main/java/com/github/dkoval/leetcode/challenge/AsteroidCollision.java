package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3502/">Asteroid Collision</a>
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {

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
