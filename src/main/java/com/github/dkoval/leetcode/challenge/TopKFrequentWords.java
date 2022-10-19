package com.github.dkoval.leetcode.challenge;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 * <p>
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * <p>
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= words.length <= 500</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>words[i] consists of lowercase English letters</li>
 *  <li>k is in the range [1, The number of unique words[i]]</li>
 * </ul>
 */
public interface TopKFrequentWords {

    List<String> topKFrequent(String[] words, int k);

    class TopKFrequentWordsRev1 implements TopKFrequentWords {

        @Override
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> frequencies = new HashMap<>();
            for (String word : words) {
                int oldFrequency = frequencies.getOrDefault(word, 0);
                frequencies.put(word, oldFrequency + 1);
            }

            // min heap
            Comparator<String> cmp = (word1, word2) -> {
                int frequency1 = frequencies.get(word1);
                int frequency2 = frequencies.get(word2);
                if (frequency1 == frequency2) {
                    return -word1.compareTo(word2);
                }
                return Integer.compare(frequency1, frequency2);
            };

            Queue<String> pq = new PriorityQueue<>(cmp);
            for (String word : frequencies.keySet()) {
                pq.offer(word);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<String> ans = new ArrayList<>(pq);
            ans.sort(cmp.reversed());
            return ans;
        }
    }
}
