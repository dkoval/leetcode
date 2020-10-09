package com.github.dkoval.leetcode.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards">X of a Kind in a Deck of Cards</a>
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into
 * 1 or more groups of cards, where:
 *
 * - Each group has exactly X cards.
 * - All the cards in each group have the same integer.
 */
public abstract class XOfAKindInADeckOfCards {

    public abstract boolean hasGroupsSizeX(int[] deck);

    public static class XOfAKindInADeckOfCardsBruteForce extends XOfAKindInADeckOfCards {

        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int card : deck) {
                count.put(card, count.getOrDefault(card, 0) + 1);
            }
            // brute force: try all possible X values from 2..N range
            for (int x = 2; x <= deck.length; x++) {
                if (deck.length % x != 0) continue;
                boolean found = true;
                for (int v : count.values()) {
                    if (v % x != 0) {
                        found = false;
                        break;
                    }
                }
                if (found) return true;
            }
            return false;
        }
    }

    public static class XOfAKindInADeckOfCardsGCD extends XOfAKindInADeckOfCards {

        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int card : deck) {
                count.put(card, count.getOrDefault(card, 0) + 1);
            }
            int gcd = -1;
            for (int v : count.values()) {
                if (gcd == -1) {
                    gcd = v;
                } else {
                    gcd = gcd(gcd, v);
                }
            }
            return gcd >= 2;
        }

        private int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y,  x % y);
        }
    }
}
