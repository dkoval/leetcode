package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/">Maximum Number of Balloons</a>
 * <p>
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= text.length <= 10^4</li>
 *  <li>text consists of lower case English letters only</li>
 * </ul>
 */
public interface MaximumNumberOfBalloons {

    int maxNumberOfBalloons(String text);

    class MaximumNumberOfBalloonsUsingTwoMaps implements MaximumNumberOfBalloons {

        private static final Map<Character, Integer> BALLOON = frequencies("balloon");

        public int maxNumberOfBalloons(String text) {
            Map<Character, Integer> word = frequencies(text);

            int total = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : BALLOON.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();

                if (!word.containsKey(c)) {
                    return 0;
                }

                int x = word.get(c) / count;
                if (x < 1) {
                    return 0;
                }
                total = Math.min(total, x);
            }
            return total;
        }

        private static Map<Character, Integer> frequencies(String s) {
            Map<Character, Integer> frequencies = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
            return frequencies;
        }
    }

    class MaximumNumberOfBalloonsUsingSingleMap implements MaximumNumberOfBalloons {

        @Override
        public int maxNumberOfBalloons(String text) {
            Map<Character, Integer> frequencies = new HashMap<>();
            for (char c : "balon".toCharArray()) {
                frequencies.put(c, 0);
            }

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (frequencies.containsKey(c)) {
                    frequencies.put(c, frequencies.get(c) + 1);
                }
            }

            frequencies.put('l', frequencies.get('l') / 2);
            frequencies.put('o', frequencies.get('o') / 2);

            int total = Integer.MAX_VALUE;
            for (int frequency : frequencies.values()) {
                total = Math.min(total, frequency);
            }
            return total;
        }
    }
}
