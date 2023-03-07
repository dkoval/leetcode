package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-complete-trips/">Minimum Time to Complete Trips</a>
 * <p>
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
 * <p>
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip.
 * Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
 * <p>
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
 * Return the minimum time required for all buses to complete at least totalTrips trips.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= time.length <= 10^5</li>
 *  <li>1 <= time[i], totalTrips <= 10^7</li>
 * </ul>
 */
public interface MinimumTimeToCompleteTrips {

    long minimumTime(int[] time, int totalTrips);

    // O(N * log(totalTrips * tmin)) time | O(1) space
    class MinimumTimeToCompleteTripsUsingBinarySearch implements MinimumTimeToCompleteTrips {

        @Override
        public long minimumTime(int[] time, int totalTrips) {
            // Idea: binary search.
            // At time t, the number of trips taken by the i-th bus trips[i] = t / time[i]
            // Condition: sum(trips[0], ..., trips[n - 1]) >= totalTrips will eventually become true.
            // [F, F, ..., F, T, T, ... T]
            //                ^ <- answer (lower bound)
            int n = time.length;

            long tmin = time[0];
            for (int t : time) {
                tmin = Math.min(tmin, t);
            }

            long left = 1;
            long right = totalTrips * tmin;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (good(mid, time, totalTrips)) {
                    // mid might be the answer; check if there's a better alternative to the left of mid.
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean good(long now, int[] time, int target) {
            long trips = 0L;
            for (int t : time) {
                trips += now / t;
            }
            return trips >= target;
        }
    }
}
