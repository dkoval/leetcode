package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3681/">Vowel Spellchecker</a>
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
 */
public class VowelSpellchecker {
    private static final Set<Character> LOWERCASE_VOWELS = new HashSet<>();

    static {
        for (char c : "aeiou".toCharArray()) {
            LOWERCASE_VOWELS.add(c);
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>();
        Map<String, String> capitalizationLookup = new HashMap<>();
        Map<String, String> vowelLookup = new HashMap<>();

        for (String word : wordlist) {
            wordSet.add(word);

            String key = capitalizationLookupKey(word);
            if (!capitalizationLookup.containsKey(key)) {
                capitalizationLookup.put(key, word);
            }

            key = vowelLookupKey(word);
            if (!vowelLookup.containsKey(key)) {
                vowelLookup.put(key, word);
            }
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < result.length; i++) {
            String word = queries[i];
            if (wordSet.contains(word)) {
                result[i] = word;
                continue;
            }

            String key = capitalizationLookupKey(word);
            if (capitalizationLookup.containsKey(key)) {
                result[i] = capitalizationLookup.get(key);
                continue;
            }

            key = vowelLookupKey(word);
            if (vowelLookup.containsKey(key)) {
                result[i] = vowelLookup.get(key);
                continue;
            }

            result[i] = "";
        }
        return result;
    }

    private String capitalizationLookupKey(String word) {
        return word.toLowerCase();
    }

    private String vowelLookupKey(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            sb.append(LOWERCASE_VOWELS.contains(c) ? '*' : c);
        }
        return sb.toString();
    }
}
