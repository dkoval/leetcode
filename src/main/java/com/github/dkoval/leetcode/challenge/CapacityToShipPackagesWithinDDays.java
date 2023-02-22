package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Capacity To Ship Packages Within D Days</a>
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt
 * (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= days <= weights.length <= 5 * 10^4</li>
 *  <li>1 <= weights[i] <= 500</li>
 * </ul>
 */
public interface CapacityToShipPackagesWithinDDays {

    int shipWithinDays(int[] weights, int days);

    // O(N * logS), where S = sum(weights) | O(1) space
    class CapacityToShipPackagesWithinDDaysUsingBinarySearch implements CapacityToShipPackagesWithinDDays {

        @Override
        public int shipWithinDays(int[] weights, int days) {
            // find the lower and upper bounds of the search space
            int max = -1;
            int sum = 0;
            for (int weight : weights) {
                max = Math.max(max, weight);
                sum += weight;
            }

            // binary search
            int left = max;
            int right = sum;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canShip(weights, days, mid)) {
                    // mid might be the answer; check if there's a better alternative to the left of mid.
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canShip(int[] weights, int days, int target) {
            int usedDays = 1;
            int capacity = target;
            for (int weight : weights) {
                if (weight > capacity) {
                    usedDays++;
                    capacity = target;
                }
                capacity -= weight;
            }
            return usedDays <= days;
        }
    }
}
