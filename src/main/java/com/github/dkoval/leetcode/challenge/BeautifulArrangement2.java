package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/">Beautiful Arrangement II</a>
 * <p>
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 *
 * The n and k are in the range 1 <= k < n <= 10^4.
 */
public class BeautifulArrangement2 {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int idx = 0;
        int min = 1, max = n;
        boolean increasing = true;
        while (k-- > 0) {
            result[idx++] = increasing ? min++ : max--;
            if (k == 0 && idx < n) {
                // copy remaining elements
                while (idx < n) {
                    result[idx++] = increasing ? min++ : max--;
                }
            }
            increasing = !increasing;
        }
        return result;
    }
}
