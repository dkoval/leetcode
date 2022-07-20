package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/koko-eating-bananas/">Koko Eating Bananas</a>
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // The answer may be any number in [left : right] range
        int left = 1;
        int right = 1_000_000; // max piles[i] = 10^9
        // binary search in [left : right] range
        while (left < right) {
            int mid = left + (right - left) / 2;
            // isGoodSpeed(speed) output:
            // FF...FTT...T
            //       ^ <- we want the very 1st "good" answer
            if (eat(mid, piles) <= h) {
                // `mid` may be the possible answer; every number > `mid` is also "good",
                // however we want the very 1st good answer
                right = mid;
            } else {
                // `mid` is not a possible answer; every number < `mid` is not "good" either
                left = mid + 1;
            }
        }
        return left;
    }

    private int eat(int speed, int[] piles) {
        int hours = 0;
        for (int x : piles) {
            // http://www.cs.nott.ac.uk/~psarb2/G51MPC/slides/NumberLogic.pdf
            // round up: (x + speed - 1) / speed = (x - 1) / speed + 1
            hours += (x - 1) / speed + 1; // round up
        }
        return hours;
    }
}
