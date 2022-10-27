package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/image-overlap/">Image Overlap</a>
 * <p>
 * You are given two images, img1 and img2, represented as binary, square matrices of size n x n.
 * A binary matrix has only 0s and 1s as values.
 * <p>
 * We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units.
 * We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
 * <p>
 * Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
 * <p>
 * Return the largest possible overlap.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == img1.length == img1[i].length</li>
 *  <li>n == img2.length == img2[i].length</li>
 *  <li>1 <= n <= 30</li>
 *  <li>img1[i][j] is either 0 or 1</li>
 *  <li>img2[i][j] is either 0 or 1</li>
 * </ul>
 */
public interface ImageOverlap {

    int largestOverlap(int[][] img1, int[][] img2);

    class ImageOverlapRev1 implements ImageOverlap {

        @Override
        public int largestOverlap(int[][] img1, int[][] img2) {
            int n = img1.length;

            // brute-force
            int best = 0;
            for (int dx = -n + 1; dx < n; dx++) {
                for (int dy = -n + 1; dy < n; dy++) {
                    // process overlapping region
                    int count = 0;
                    for (int x = 0; x < n; x++) {
                        int nextX = x + dx;

                        // check boundaries
                        if (nextX < 0 || nextX >= n) {
                            continue;
                        }

                        for (int y = 0; y < n; y++) {
                            int nextY = y + dy;

                            // check boundaries
                            if (nextY < 0 || nextY >= n) {
                                continue;
                            }

                            if (img1[nextX][nextY] == 1 && img2[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                    best = Math.max(best, count);
                }
            }
            return best;
        }
    }
}
