package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/">Minimum Number of Pushes to Type Word I</a>
 * <p>
 * You are given a string word containing distinct lowercase English letters.
 * <p>
 * Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them.
 * For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
 * <p>
 * It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters,
 * but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
 * <p>
 * Return the minimum number of pushes needed to type word after remapping the keys.
 * <p>
 * An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= word.length <= 26</li>
 *  <li>word consists of lowercase English letters</li>
 *  <li>All letters in word are distinct</li>
 * </ul>
 */
public interface MinimumNumberOfPushesToTypeWord1 {

    int minimumPushes(String word);

    class MinimumNumberOfPushesToTypeWord1Rev1 implements MinimumNumberOfPushesToTypeWord1 {

        @Override
        public int minimumPushes(String word) {
            final var n = word.length();

            final var counts = new int[26];
            for (var i = 0; i < n; i++) {
                counts[word.charAt(i) - 'a']++;
            }

            var total = 0;
            var unique = 0;
            for (var count : counts) {
                if (count == 0) {
                    continue;
                }

                unique++;
                // round_up(x / y) = (x + y - 1) / y = (x - 1) / y + 1
                var pushes = (unique - 1) / 8 + 1;
                total += count * pushes;
            }
            return total;
        }
    }
}
