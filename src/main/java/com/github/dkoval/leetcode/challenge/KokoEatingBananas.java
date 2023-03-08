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
 * <ul>
 *  <li>1 <= piles.length <= 10^4</li>
 *  <li>piles.length <= h <= 10^9</li>
 *  <li>1 <= piles[i] <= 10^9</li>
 * </ul>
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // Idea: binary search.
        // The condition "the min speed k required to eat all the bananas within h hours" will eventually become true:
        // F, F, ..., F, T, T, ..., T
        //               ^ <- answer (lower bound)
        // 1 <= piles[i] <= 10^9
        int left = 1;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isGoodSpeed(mid, piles, h)) {
                // `mid` might be the answer; every number > `mid` is also "good",
                // therefore check if there's a better alternative to the left of mid.
                right = mid;
            } else {
                // `mid` can't be the answer; every number < `mid` is not "good" either
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isGoodSpeed(int speed, int[] piles, int h) {
        int hours = 0;
        for (int bananas : piles) {
            // http://www.cs.nott.ac.uk/~psarb2/G51MPC/slides/NumberLogic.pdf
            // round_up(x / y) = (x + y - 1) / y = (x - 1) / y + 1
            hours += (bananas - 1) / speed + 1;
        }
        return hours <= h;
    }
}
