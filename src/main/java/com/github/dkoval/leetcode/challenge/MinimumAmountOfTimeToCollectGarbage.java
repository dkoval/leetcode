package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/">Minimum Amount of Time to Collect Garbage</a>
 * <p>
 * You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house.
 * garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively.
 * Picking up one unit of any type of garbage takes 1 minute.
 * <p>
 * You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
 * <p>
 * There are three garbage trucks in the city, each responsible for picking up one type of garbage.
 * Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
 * <p>
 * Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
 * <p>
 * Return the minimum number of minutes needed to pick up all the garbage.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= garbage.length <= 10^5</li>
 *  <li>garbage[i] consists of only the letters 'M', 'P', and 'G'.</li>
 *  <li>1 <= garbage[i].length <= 10</li>
 *  <li>travel.length == garbage.length - 1</li>
 *  <li>1 <= travel[i] <= 100</li>
 * </ul>
 */
public interface MinimumAmountOfTimeToCollectGarbage {

    int garbageCollection(String[] garbage, int[] travel);

    class MinimumAmountOfTimeToCollectGarbageRev1 implements MinimumAmountOfTimeToCollectGarbage {

        @Override
        public int garbageCollection(String[] garbage, int[] travel) {
            int n = garbage.length;

            int totalTime = 0;

            // pickupTime[k] - min time needed to pick up all units of k-th type of garbage
            // 0 - 'M'
            // 1 - 'P'
            // 2 - 'G'
            int[] pickupTime = new int[3];

            int time = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    time += travel[i - 1];
                }

                // count units of each type of garbage
                int[] units = new int[3];
                for (int j = 0; j < garbage[i].length(); j++) {
                    char c = garbage[i].charAt(j);
                    units["MPG".indexOf(c)]++;
                }

                for (int k = 0; k < 3; k++) {
                    if (units[k] > 0) {
                        totalTime += units[k];
                        pickupTime[k] = time;
                    }
                }
            }

            for (int x : pickupTime) {
                totalTime += x;
            }
            return totalTime;
        }
    }

    class MinimumAmountOfTimeToCollectGarbageRev2 implements MinimumAmountOfTimeToCollectGarbage {

        @Override
        public int garbageCollection(String[] garbage, int[] travel) {
            int n = garbage.length;

            int totalTime = 0;

            // pickupTime[k] - min time needed to pick up all units of k-th type of garbage
            // 0 - 'M'
            // 1 - 'P'
            // 2 - 'G'
            int[] pickupTime = new int[3];

            int time = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    time += travel[i - 1];
                }

                // pickup up all the garbage from the i-th house
                totalTime += garbage[i].length();

                // count units of each type of garbage
                Set<Character> uniq = new HashSet<>();
                for (int j = 0; j < garbage[i].length() && uniq.size() < 3; j++) {
                    char t = garbage[i].charAt(j);
                    uniq.add(t);
                }

                for (char t : uniq) {
                    // minutes needed to travel to the last house containing t type of garbage
                    pickupTime["MPG".indexOf(t)] = time;
                }
            }

            for (int x : pickupTime) {
                totalTime += x;
            }
            return totalTime;
        }
    }
}
