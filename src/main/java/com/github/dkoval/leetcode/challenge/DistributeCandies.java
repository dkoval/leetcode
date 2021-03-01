package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/">Distribute Candies</a>
 * <p>
 * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight,
 * so she visited a doctor.
 * <p>
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much,
 * and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
 * <p>
 * Given the integer array candyType of length n, return the maximum number of different types of candies she can eat
 * if she only eats n / 2 of them.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> kinds = new HashSet<>();
        for (int kind : candyType) {
            kinds.add(kind);
        }
        return Math.min(kinds.size(), candyType.length / 2);
    }
}
