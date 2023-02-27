package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/construct-quad-tree/">Construct Quad Tree</a>
 * <p>
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
 * <p>
 * Return the root of the Quad-Tree representing the grid.
 * <p>
 * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
 * <p>
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 * <p>
 * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid
 * and set the four children to Null and stop.
 * <p>
 * If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into
 * four sub-grids as shown in the photo.
 * <p>
 * Recurse for each of the children with the proper sub-grid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length == grid[i].length</li>
 *  <li>n == 2^x where 0 <= x <= 6</li>
 * </ul>
 */
public interface ConstructQuadTree {

    Node construct(int[][] grid);

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return String.format("isLeaf: %d, val: %d", isLeaf ? 1 : 0, val ? 1 : 0);
        }
    }

    class ConstructQuadTreeRev1 implements ConstructQuadTree {

        @Override
        public Node construct(int[][] grid) {
            int n = grid.length;
            return construct(grid, 0, 0, n);
        }

        // (row, col) are the coordinates of the top-left corner a square with the side length = d
        private Node construct(int[][] grid, int row, int col, int d) {
            if (d == 1) {
                return new Node(grid[row][col] == 1, true);
            }

            // divide & conquer
            int d2 = d / 2;
            Node topLeft = construct(grid, row, col, d2);
            Node topRight = construct(grid, row, col + d2, d2);
            Node bottomLeft = construct(grid, row + d2, col, d2);
            Node bottomRight = construct(grid, row + d2, col + d2, d2);

            // all 0's or all 1's
            Node[] nodes = {topLeft, topRight, bottomLeft, bottomRight};
            boolean isLeaf = true;
            boolean val = topLeft.val;
            for (Node node : nodes) {
                if (!node.isLeaf || node.val != val) {
                    isLeaf = false;
                    break;
                }
            }

            return isLeaf
                    ? new Node(topLeft.val, true) // "merge" 4 leaf nodes sharing the same value into a bigger leaf node
                    : new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
