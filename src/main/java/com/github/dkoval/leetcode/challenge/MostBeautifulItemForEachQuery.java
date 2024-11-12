package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/most-beautiful-item-for-each-query/">Most Beautiful Item for Each Query</a>
 * <p>
 * You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.
 * <p>
 * You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of
 * an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.
 * <p>
 * Return an array answer of the same length as queries where answer[j] is the answer to the jth query.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= items.length, queries.length <= 10^5</li>
 *  <li>items[i].length == 2</li>
 *  <li>1 <= pricei, beautyi, queries[j] <= 10^9</li>
 * </ul>
 */
public interface MostBeautifulItemForEachQuery {

    int[] maximumBeauty(int[][] items, int[] queries);

    class MostBeautifulItemForEachQueryRev1 implements MostBeautifulItemForEachQuery {

        @Override
        public int[] maximumBeauty(int[][] items, int[] queries) {
            int n = items.length;
            int q = queries.length;

            // sort items by price to be able to binary search
            Arrays.sort(items, Comparator.comparingInt(it -> it[0]));

            // replace items[i][1] with the maximum beauty seen so far
            for (int i = 1; i < n; i++) {
                items[i][1] = Math.max(items[i][1], items[i - 1][1]);
            }

            int[] ans = new int[q];
            for (int i = 0; i < q; i++) {
                ans[i] = find(items, queries[i]);
            }
            return ans;
        }

        private int find(int[][] items, int target) {
            // binary search
            // condition: price > target
            // FF...FTT...T
            //       ^ find the min price > target
            //      ^ answer - the largest price <= target
            int left = 0;
            int right = items.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= target) {
                    // middle element can't be the answer
                    left = mid + 1;
                } else {
                    // middle element may be the answer;
                    // check if there's a better option to the left of it
                    right = mid;
                }
            }
            return (left > 0) ? items[left - 1][1] : 0;
        }
    }

    class MostBeautifulItemForEachQueryRev2 implements MostBeautifulItemForEachQuery {

        @Override
        public int[] maximumBeauty(int[][] items, int[] queries) {
            int n = items.length;
            int q = queries.length;

            // sort items by price
            Arrays.sort(items, Comparator.comparingInt(it -> it[0]));

            // sort queries
            IndexedValue[] indexedQueries = new IndexedValue[q];
            for (int i = 0; i < q; i++) {
                indexedQueries[i] = new IndexedValue(i, queries[i]);
            }

            Arrays.sort(indexedQueries, Comparator.comparingInt(it -> it.value));

            int[] ans = new int[q];
            int i = 0;
            int maxBeauty = 0;
            for (int j = 0; j < q; j++) {
                // consider all items with the price <= the current query;
                // while doing so, record the max beauty seen so far
                while (i < n && items[i][0] <= indexedQueries[j].value) {
                    maxBeauty = Math.max(maxBeauty, items[i][1]);
                    i++;
                }
                ans[indexedQueries[j].index] = maxBeauty;
            }
            return ans;
        }

        private record IndexedValue(int index, int value) {
        }
    }
}
