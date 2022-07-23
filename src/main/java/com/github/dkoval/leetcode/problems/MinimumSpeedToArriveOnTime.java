package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">Minimum Speed to Arrive on Time</a>
 * <p>
 * You are given a floating-point number hour, representing the amount of time you have to reach the office.
 * To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n,
 * where dist[i] describes the distance (in kilometers) of the ith train ride.
 * <p>
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * <p>
 * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours
 * before you can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you
 * to reach the office on time, or -1 if it is impossible to be on time.
 * <p>
 * Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.
 */
public interface MinimumSpeedToArriveOnTime {

    int minSpeedOnTime(int[] dist, double hour);

    class MinimumSpeedToArriveOnTimeUsingBinarySearchRev1 implements MinimumSpeedToArriveOnTime {

        @Override
        public int minSpeedOnTime(int[] dist, double hour) {
            // f(x) is the number of hours required to get to the office at speed x
            // Property: f(x) >= f(x + 1)
            // Condition f(x) <= hour becomes True at some point
            // FF...FTT...T
            //       ^ answer (lower bound)
            int left = 1;
            int right = Integer.MAX_VALUE;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (travelTime(dist, mid) <= hour) {
                    // mid might be the answer;
                    // check if there is a better option to the left of it
                    right = mid;
                } else {
                    // mid is not the answer + everything to the left of it
                    left = mid + 1;
                }
            }
            return (left < Integer.MAX_VALUE) ? left : -1;
        }

        private double travelTime(int[] dist, int speed) {
            int n = dist.length;
            double time = 0.0;
            for (int i = 0; i < n - 1; i++) {
                time += (dist[i] - 1) / speed + 1; // round up
            }
            return time + ((double) dist[n - 1] / speed);
        }
    }
}
