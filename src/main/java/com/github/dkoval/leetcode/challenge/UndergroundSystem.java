package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/design-underground-system/">Design Underground System</a>
 * <p>
 * Implement the UndergroundSystem class:
 * <ul>
 *  <li>void checkIn(int id, string stationName, int t)</li>
 *  <ul>
 *    <li>A customer with a card id equal to id, gets in the station stationName at time t.</li>
 *    <li>A customer can only be checked into one place at a time.</li>
 *  </ul>
 *  <li>void checkOut(int id, string stationName, int t)</li>
 *  <ul>
 *    <li>A customer with a card id equal to id, gets out from the station stationName at time t.</li>
 *  </ul>
 *  <li>double getAverageTime(string startStation, string endStation)</li>
 *  <ul>
 *    <li>Returns the average time to travel between the startStation and the endStation.</li>
 *    <li>The average time is computed from all the previous traveling from startStation to endStation that happened directly.</li>
 *    <li>Call to getAverageTime is always valid.</li>
 *  </ul>
 * You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1 at some station,
 * they get out at time t2 with t2 > t1. All events happen in chronological order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= id, t <= 10^6</li>
 *  <li>1 <= stationName.length, startStation.length, endStation.length <= 10</li>
 *  <li>All strings consist of uppercase and lowercase English letters and digits.</li>
 *  <li>There will be at most 2 * 104 calls in total to checkIn, checkOut, and getAverageTime.</li>
 *  <li>Answers within 10^-5 of the actual value will be accepted.</li>
 * </ul>
 */
public class UndergroundSystem {
    // cardId -> (checkInStation, checkInTime)
    private final Map<Integer, CheckIn> checkIns = new HashMap<>();
    // route (startStation, endStation) -> avg time
    private final Map<String, AvgTime> avgTimePerRoute = new HashMap<>();

    private static class CheckIn {
        final String station;
        final int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class AvgTime {
        private int sum = 0;
        private int n = 0;

        void update(int time) {
            sum += time;
            n++;
        }

        double get() {
            return (n == 0) ? Double.POSITIVE_INFINITY : (double) sum / n;
        }
    }

    public void checkIn(int id, String stationName, int t) {
        if (!checkIns.containsKey(id)) {
            checkIns.put(id, new CheckIn(stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (checkIns.containsKey(id)) {
            CheckIn checkIn = checkIns.get(id);
            String route = route(checkIn.station, stationName);
            AvgTime avgTime = avgTimePerRoute.computeIfAbsent(route, __ -> new AvgTime());
            avgTime.update(t - checkIn.time);
            checkIns.remove(id); // information about check-in is no longer needed
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = route(startStation, endStation);
        // There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called
        AvgTime avgTime = avgTimePerRoute.get(route);
        return (avgTime != null) ? avgTime.get() : Double.POSITIVE_INFINITY;
    }

    private static String route(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}
