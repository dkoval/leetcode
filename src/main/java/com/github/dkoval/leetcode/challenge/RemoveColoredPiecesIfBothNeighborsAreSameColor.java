package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/">Remove Colored Pieces if Both Neighbors are the Same Color</a>
 * <p>
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
 * You are given a string colors of length n where colors[i] is the color of the ith piece.
 * <p>
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 * <ul>
 *  <li>Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.</li>
 *  <li>Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.</li>
 *  <li>Alice and Bob cannot remove pieces from the edge of the line.</li>
 *  <li>If a player cannot make a move on their turn, that player loses and the other player wins.</li>
 * </ul>
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= colors.length <= 10^5</li>
 *  <li>colors consists of only the letters 'A' and 'B'</li>
 * </ul>
 */
public interface RemoveColoredPiecesIfBothNeighborsAreSameColor {

    boolean winnerOfGame(String colors);

    class RemoveColoredPiecesIfBothNeighborsAreSameColorRev1 implements RemoveColoredPiecesIfBothNeighborsAreSameColor {

        @Override
        public boolean winnerOfGame(String colors) {
            int aliceMoves = numMoves(colors, 'A');
            int bobMoves = numMoves(colors, 'B');
            return aliceMoves > bobMoves;
        }

        private int numMoves(String colors, char player) {
            int n = colors.length();

            int moves = 0;
            int i = 0;
            while (i < n) {
                // skip improper colors
                while (i < n && colors.charAt(i) != player) {
                    i++;
                }

                // get the length of a group of consecutive pieces of the same color
                int length = 0;
                while (i < n && colors.charAt(i) == player) {
                    length++;
                    i++;
                }

                if (length >= 3) {
                    moves += length - 2;
                }
            }
            return moves;
        }
    }

    class RemoveColoredPiecesIfBothNeighborsAreSameColorRev2 implements RemoveColoredPiecesIfBothNeighborsAreSameColor {

        @Override
        public boolean winnerOfGame(String colors) {
            int n = colors.length();

            int aliceMoves = 0;
            int bobMoves = 0;
            for (int i = 1; i < n - 1; i++) {
                if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                    if (colors.charAt(i) == 'A') {
                        aliceMoves++;
                    } else if (colors.charAt(i) == 'B') {
                        bobMoves++;
                    }
                }
            }
            return aliceMoves > bobMoves;
        }
    }
}
