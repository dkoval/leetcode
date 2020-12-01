package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3550/">Shortest Word Distance</a>
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            } else if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                int currDistance = Math.abs(idx1 - idx2);
                minDistance = Math.min(minDistance, currDistance);
            }
        }
        return minDistance;
    }
}
