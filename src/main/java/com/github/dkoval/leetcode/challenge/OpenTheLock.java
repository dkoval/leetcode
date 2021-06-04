package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3767/">Open the Lock</a>
 * <p>
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    private static final int[] MOVES = {-1, 1};

    public int openLock(String[] deadends, String target) {
        String initialCode = "0000";
        Set<String> deadendsSet = toSet(deadends);

        if (deadendsSet.contains(initialCode)) {
            return -1;
        }

        Map<String, Integer> distance = new HashMap<>();
        distance.put(initialCode, 0);

        // BFS
        Queue<String> q = new LinkedList<>();
        q.offer(initialCode);
        while (!q.isEmpty()) {
            String currCode = q.poll();
            if (currCode.equals(target)) {
                return distance.get(currCode);
            }

            // generate 8 next possible 4-digit codes
            for (int i = 3; i >= 0; i--) {
                for (int move : MOVES) {
                    String nextCode = nextCode(currCode, i, move);
                    if (!deadendsSet.contains(nextCode) && !distance.containsKey(nextCode)) {
                        q.offer(nextCode);
                        distance.put(nextCode, distance.get(currCode) + 1);
                    }
                }
            }
        }
        return -1;
    }

    private Set<String> toSet(String[] elements) {
        Set<String> set = new HashSet<>();
        for (String element : elements) {
            set.add(element);
        }
        return set;
    }

    private String nextCode(String currCode, int idx, int move) {
        StringBuilder nextCode = new StringBuilder(currCode);
        char digit;
        if (currCode.charAt(idx) == '9' && move == 1) {
            digit = '0';
        } else if (currCode.charAt(idx) == '0' && move == -1) {
            digit = '9';
        } else {
            digit = (char) (currCode.charAt(idx) + move);
        }
        nextCode.setCharAt(idx, digit);
        return nextCode.toString();
    }
}
