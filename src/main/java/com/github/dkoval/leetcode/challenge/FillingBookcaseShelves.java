package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/filling-bookcase-shelves/">Filling Bookcase Shelves</a>
 * <p>
 * You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book.
 * You are also given an integer shelfWidth.
 * <p>
 * We want to place these books in order onto bookcase shelves that have a total width shelfWidth.
 * <p>
 * We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth,
 * then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.
 * <p>
 * Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.
 * <p>
 * For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf,
 * the third book on the second shelf, and the fourth and fifth book on the last shelf.
 * <p>
 * Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= books.length <= 1000</li>
 *  <li>1 <= thicknessi <= shelfWidth <= 1000</li>
 *  <li>1 <= heighti <= 1000</li>
 * </ul>
 */
public interface FillingBookcaseShelves {

    int minHeightShelves(int[][] books, int shelfWidth);

    // O(N^2) time | O(N) space
    class FillingBookcaseShelvesDPTopDown implements FillingBookcaseShelves {

        @Override
        public int minHeightShelves(int[][] books, int shelfWidth) {
            // DP: top-down
            int n = books.length;
            return calc(books, shelfWidth, 0, new Integer[n]);
        }

        private int calc(int[][] books, int shelfWidth, int index, Integer[] dp) {
            if (index == books.length) {
                return 0;
            }

            // already solved
            if (dp[index] != null) {
                return dp[index];
            }

            // books[index : i] denotes books put on tne same shelve
            int height = 0;
            int width = 0;
            int best = Integer.MAX_VALUE;
            for (int i = index; i < books.length; i++) {
                width += books[i][0];
                if (width > shelfWidth) {
                    break;
                }
                // the nighest book on the current shelf
                height = Math.max(height, books[i][1]);
                // add a new shelf and choose the best option
                best = Math.min(best, height + calc(books, shelfWidth, i + 1, dp));
            }
            return dp[index] = best;
        }
    }
}
