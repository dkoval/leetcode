package com.github.dkoval.leetcode.challenge;

import java.util.List;

public class MaximumDistanceInArraysJava {

    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays.size() < 2) return 0;
        List<Integer> first = arrays.get(0);
        int min = first.get(0);
        int max = first.get(first.size() - 1);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int currMin = curr.get(0);
            int currMax = curr.get(curr.size() - 1);
            int currDistance = Math.max(Math.abs(currMax - min), Math.abs(max - currMin));
            result = Math.max(result, currDistance);
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }
        return result;
    }
}
