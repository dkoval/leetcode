package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/destroying-asteroids/">Destroying Asteroids</a>
 * <p>
 * You are given an integer mass, which represents the original mass of a planet.
 * You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
 * <p>
 * You can arrange for the planet to collide with the asteroids in any arbitrary order.
 * If the mass of the planet is greater than or equal to the mass of the asteroid, the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.
 * <p>
 * Return true if all asteroids can be destroyed. Otherwise, return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= mass <= 10^5</li>
 *  <li>1 <= asteroids.length <= 10^5</li>
 *  <li>1 <= asteroids[i] <= 10^5</li>
 * </ul>
 */
public interface DestroyingAsteroids {

    boolean asteroidsDestroyed(int mass, int[] asteroids);

    class DestroyingAsteroidsRev1 implements DestroyingAsteroids {

        @Override
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);

            var earth = (long) mass;
            for (int asteroid : asteroids) {
                if (asteroid > earth) {
                    return false;
                }
                earth += asteroid;
            }
            return true;
        }
    }
}
