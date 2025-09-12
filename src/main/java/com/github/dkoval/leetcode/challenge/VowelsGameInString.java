package com.github.dkoval.leetcode.challenge;

import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/vowels-game-in-a-string/">Vowels Game in a String</a>
 * <p>
 * Alice and Bob are playing a game on a string.
 * <p>
 * You are given a string s, Alice and Bob will take turns playing the following game where Alice starts first:
 * <p>
 * On Alice's turn, she has to remove any non-empty substring from s that contains an odd number of vowels.
 * <p>
 * On Bob's turn, he has to remove any non-empty substring from s that contains an even number of vowels.
 * <p>
 * The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play optimally.
 * <p>
 * Return true if Alice wins the game, and false otherwise.
 * <p>
 * The English vowels are: a, e, i, o, and u.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>1 <= s.length <= 10^5</li>
 *  <ul>s consists only of lowercase English letters</li>
 * </ul>
 */
public interface VowelsGameInString {

    boolean doesAliceWin(String s);

    class VowelsGameInStringRev1 implements VowelsGameInString {

        private static final Set<Character> ALL_VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        @Override
        public boolean doesAliceWin(String s) {
            final var n = s.length();

            var vowels = 0;
            for (var i = 0; i < n; i++) {
                if (ALL_VOWELS.contains(s.charAt(i))) {
                    vowels++;
                }
            }

            // case 0: if there are no vowels in the initial string, then Bob wins
            // case 1: number of vowels is odd =>
            // Alice can remove the whole string on her first turn and win
            // case 2: number of vowels is even (say, 6) =>
            // Alice: 3, Bob: 2, Alice: 1, Bob: cannot make a move
            return vowels != 0;
        }
    }
}
