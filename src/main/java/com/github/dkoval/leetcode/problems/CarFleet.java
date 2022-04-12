package com.github.dkoval.leetcode.problems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/car-fleet/">Car Fleet</a>
 * <p>
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car
 * and speed[i] is the speed of the ith car (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
 * The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored
 * (i.e., they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == position.length == speed.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>0 < target <= 10^6</li>
 *  <li>0 <= position[i] < target</li>
 *  <li>All the values of position are unique</li>
 *  <li>0 < speed[i] <= 10^6</li>
 * </ul>
 */
public interface CarFleet {

    int carFleet(int target, int[] position, int[] speed);

    class CarFleetWithStack implements CarFleet {

        private static class Car {
            final int position;
            final int speed;

            Car(int position, int speed) {
                this.position = position;
                this.speed = speed;
            }
        }

        // O(NlogN) time | O(N) space
        @Override
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            // O(N) space
            Car[] cars = new Car[n];
            for (int i = 0; i < n; i++) {
                cars[i] = new Car(position[i], speed[i]);
            }

            // O(NlogN) time
            Arrays.sort(cars, Comparator.comparingInt(car -> car.position));
            // O(N) space
            Deque<Double> stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                // time it takes for the i-th car to arrive at `target` destination
                double t = (double)(target - cars[i].position) / cars[i].speed;
                // Note that if time[i - 1] < time[i] that means
                // that the (i - 1)-th car will eventually catch up with the i-th car
                // forming a fleet
                if (stack.isEmpty() || t > stack.peek() /* i-th car won't catch up with any car ahead of it */) {
                    // new fleet formed
                    stack.push(t);
                }
            }
            return stack.size();
        }
    }

    // O(NlogN) time | O(N) space
    class CarFleetWithoutStack implements CarFleet {

        @Override
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;

            // store original (position -> index) mapping before sorting position[]
            Map<Integer, Integer> positionIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                positionIndex.put(position[i], i);
            }

            // O(NlogN) time
            Arrays.sort(position);

            int numFleets = 0;
            double lastTime = -1.0;
            for (int i = n - 1; i >= 0; i--) {
                // time it takes for the i-th car to arrive at destination
                int idx = positionIndex.get(position[i]);
                double t = (double)(target - position[i]) / speed[idx];
                if (t > lastTime) {
                    // i-th car won't catch up with any car ahead of it, therefore a new fleet formed
                    numFleets++;
                    lastTime = t;
                }
            }
            return numFleets;
        }
    }
}
