package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 * <p>
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * <ul>
 *  <li>You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.</li>
 *  <li>Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.</li>
 *  <li>Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</li>
 * </ul>
 * <p>
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= fruits.length <= 10^5</li>
 *  <li>0 <= fruits[i] < fruits.length</li>
 * </ul>
 */
public interface FruitIntoBaskets {

    int totalFruit(int[] fruits);

    // O(N) time | O(1) space
    class FruitIntoBasketsRev1 implements FruitIntoBaskets {

        @Override
        public int totalFruit(int[] fruits) {
            int n = fruits.length;

            // baskets[i] - the last index we've seen a fruit this basket can hold
            int[] baskets = {-1, -1};

            int best = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count++;

                // check if we can put fruits[i] in either of the baskets
                boolean matches = false;
                for (int j = 0; j < 2 && !matches; j++) {
                    if (baskets[j] == -1 || fruits[baskets[j]] == fruits[i]) {
                        baskets[j] = i;
                        matches = true;
                    }
                }

                // a new type of fruit discovered, empty one of the baskets
                if (!matches) {
                    count = i - Math.min(baskets[0], baskets[1]);
                    baskets[0] = Math.max(baskets[0], baskets[1]);
                    baskets[1] = i;
                }

                best = Math.max(best, count);
            }
            return best;
        }
    }

    class FruitIntoBasketsRev2 implements FruitIntoBaskets {

        @Override
        public int totalFruit(int[] fruits) {
            // idea: sliding window
            int n = fruits.length;

            // type of fruit -> count
            Map<Integer, Integer> counts = new HashMap<>();

            int best = 0;
            int start = 0;
            for (int end = 0; end < n; end++) {
                counts.put(fruits[end], counts.getOrDefault(fruits[end], 0) + 1);
                // shrink the sliding window to make sure we only have 2 distinct type of fruits
                while (counts.size() > 2) {
                    int count = counts.get(fruits[start]);
                    if (count > 1) {
                        counts.put(fruits[start], count - 1);
                    } else {
                        counts.remove(fruits[start]);
                    }
                    start++;
                }
                best = Math.max(best, end - start + 1);
            }
            return best;
        }
    }
}
