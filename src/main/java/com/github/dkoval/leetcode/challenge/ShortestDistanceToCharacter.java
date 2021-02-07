package com.github.dkoval.leetcode.challenge;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/">Shortest Distance to a Character</a>
 * <p>
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length
 * and answer[i] is the shortest distance from s[i] to the character c in s.
 */
public abstract class ShortestDistanceToCharacter {

    public abstract int[] shortestToChar(String s, char c);

    public static class ShortestDistanceToCharacterUsingTreeSet extends ShortestDistanceToCharacter {

        @Override
        public int[] shortestToChar(String s, char c) {
            TreeSet<Integer> positions = new TreeSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    positions.add(i);
                }
            }
            int[] answer = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                Integer lo = positions.floor(i);
                Integer hi = positions.ceiling(i);
                int loDist = (lo == null) ? Integer.MAX_VALUE : Math.abs(i - lo);
                int hiDist = (hi == null) ? Integer.MAX_VALUE : Math.abs(i - hi);
                answer[i] = Math.min(loDist, hiDist);
            }
            return answer;
        }
    }
}
