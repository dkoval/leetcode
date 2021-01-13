package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3602/">Boats to Save People</a>
 *
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person. (It is guaranteed each person can be carried by a boat.)
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, h = people.length - 1;
        int numBoats = 0;
        while (l <= h) {
            if (people[l] + people[h] <= limit) {
                // heaviest and lightest persons can be paired
                l++;
                h--;
            } else {
                // heaviest person is carried alone
                h--;
            }
            numBoats++;
        }
        return numBoats;
    }
}
