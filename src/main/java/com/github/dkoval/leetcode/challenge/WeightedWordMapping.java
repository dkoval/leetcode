package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/weighted-word-mapping/">Weighted Word Mapping</a>
 * <p>
 * You are given an array of strings words, where each string represents a word containing lowercase English letters.
 * <p>
 * You are also given an integer array weights of length 26, where weights[i] represents the weight of the ith lowercase English letter.
 * <p>
 * The weight of a word is defined as the sum of the weights of its characters.
 * <p>
 * For each word, take its weight modulo 26 and map the result to a lowercase English letter using reverse alphabetical order
 * (0 -> 'z', 1 -> 'y', ..., 25 -> 'a').
 * <p>
 * Return a string formed by concatenating the mapped characters for all words in order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 100</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>weights.length == 26</li>
 *  <li>1 <= weights[i] <= 100</li>
 *  <li>words[i] consists of lowercase English letters.</li>
 * </ul>
 */
public interface WeightedWordMapping {

    String mapWordWeights(String[] words, int[] weights);

    class WeightedWordMappingRev1 implements WeightedWordMapping {

        @Override
        public String mapWordWeights(String[] words, int[] weights) {
            final var sb = new StringBuilder();
            for (var word : words) {
                final var weight = weight(word, weights);
                sb.append((char) ('z' - weight));
            }
            return sb.toString();
        }

        private int weight(String word, int[] weights) {
            var res = 0;
            for (var i = 0; i < word.length(); i++) {
                res += weights[word.charAt(i) - 'a'];
                res %= 26;
            }
            return res;
        }
    }
}
