package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/boats-to-save-people/">Boats to Save People</a>
 * <p>
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
 * where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= people.length <= 5 * 10^4</li>
 *  <li>1 <= people[i] <= limit <= 3 * 10^4</li>
 * </ul>
 */
public class BoatsToSavePeople {

    // O(N * logN) time | O(1) space
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        // greedy
        int count = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            // 1 <= people[i] <= limit,
            // meaning that we can always carry the heaviest person
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}
