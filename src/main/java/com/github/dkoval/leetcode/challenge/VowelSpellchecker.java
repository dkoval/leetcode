package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/vowel-spellchecker/">Vowel Spellchecker</a>
 * <p>
 * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
 * <p>
 * For a given query word, the spell checker handles two categories of spelling mistakes:
 * <ul>
 *   <li>Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned
 *   with the same case as the case in the wordlist.</li>
 *   <ul>
 *     <li>Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"</li>
 *     <li>Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"</li>
 *     <li>Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"</li>
 *   </ul>
 *   <li>Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel
 *   individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same
 *   case as the match in the wordlist.</li>
 *   <ul>
 *     <li>Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"</li>
 *     <li>Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)</li>
 *     <li>Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)</li>
 *   </ul>
 * </ul>
 * <p>
 * In addition, the spell checker operates under the following precedence rules:
 * <ul>
 *   <li>When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.</li>
 *   <li>When the query matches a word up to capitalization, you should return the first such match in the wordlist.</li>
 *   <li>When the query matches a word up to vowel errors, you should return the first such match in the wordlist.</li>
 *   <li>If the query has no matches in the wordlist, you should return the empty string.</li>
 * </ul>
 * <p>
 * Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= wordlist.length, queries.length <= 5000</li>
 *  <li>1 <= wordlist[i].length, queries[i].length <= 7</li>
 *  <li>wordlist[i] and queries[i] consist only of only English letters.</li>
 * </ul>
 */
public interface VowelSpellchecker {

    String[] spellchecker(String[] wordlist, String[] queries);

    class VowelSpellcheckerRev1 implements VowelSpellchecker {

        @Override
        public String[] spellchecker(String[] wordlist, String[] queries) {
            // preprocess the "wordlist"
            final var words = new HashSet<>(Arrays.asList(wordlist));
            // aims at matching a word up to capitalization
            final var caps = new HashMap<String, String>();
            // aims at matching a word up to vowels error
            final var vows = new HashMap<String, String>();
            for (var word : wordlist) {
                // store the first match only
                var key = word.toLowerCase();
                if (!caps.containsKey(key)) {
                    caps.put(key, word);
                }

                key = maskVowels(word);
                if (!vows.containsKey(key)) {
                    vows.put(key, word);
                }
            }

            // process the "queries"
            final var ans = new String[queries.length];
            for (var i = 0; i < queries.length; i++) {
                // matches the same word
                if (words.contains(queries[i])) {
                    ans[i] = queries[i];
                    continue;
                }

                // matches a word up to capitalization
                var q = queries[i].toLowerCase();
                if (caps.containsKey(q)) {
                    ans[i] = caps.get(q);
                    continue;
                }

                // matches a word up to vowels error
                q = maskVowels(queries[i]);
                if (vows.containsKey(q)) {
                    ans[i] = vows.get(q);
                    continue;
                }

                // no match by default
                ans[i] = "";
            }
            return ans;
        }

        private String maskVowels(String word) {
            word = word.toLowerCase();
            final var sb = new StringBuilder();
            for (var i = 0; i < word.length(); i++) {
                final var c = word.charAt(i);
                sb.append("aeiou".indexOf(c) != -1 ? "*" : c);
            }
            return sb.toString();
        }
    }
}
