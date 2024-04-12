package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reveal-cards-in-increasing-order/">Reveal Cards In Increasing Order</a>
 * <p>
 * You are given an integer array deck. There is a deck of cards where every card has a unique integer.
 * The integer on the ith card is deck[i].
 * <p>
 * You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
 * <p>
 * You will do the following steps repeatedly until all cards are revealed:
 * <p>
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1. Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * <p>
 * Note that the first entry in the answer is considered to be the top of the deck.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= deck.length <= 1000</li>
 *  <li>1 <= deck[i] <= 106</li>
 *  <li>All the values of deck are unique</li>
 * </ul>
 */
public interface RevealCardsInIncreasingOrder {

    int[] deckRevealedIncreasing(int[] deck);

    class RevealCardsInIncreasingOrderRev1 implements RevealCardsInIncreasingOrder {

        @Override
        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;

            // idea: simulation
            Arrays.sort(deck);

            // stores indices of cards in the sorted deck
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                q.offer(i);
            }

            // current index in the sorted deck
            int i = 0;
            // run simulation
            int[] ans = new int[n];
            while (!q.isEmpty()) {
                // figure out the index in the resulting array to put the current deck[i] at
                int index = q.poll();
                ans[index] = deck[i++];
                if (q.size() > 1) {
                    // put the next card at the bottom of the deck
                    q.offer(q.poll());
                }
            }
            return ans;
        }
    }
}
