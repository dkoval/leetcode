package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/distribute-coins-in-binary-tree/">Distribute Coins in Binary Tree</a>
 * <p>
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins.
 * There are n coins in total throughout the whole tree.
 * <p>
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * A move may be from parent to child, or from child to parent.
 * <p>
 * Return the minimum number of moves required to make every node have exactly one coin.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is n</li>
 *  <li>1 <= n <= 100</li>
 *  <li>0 <= Node.val <= n</li>
 *  <li>The sum of all Node.val is n</li>
 * </ul>
 */
public interface DistributeCoinsInBinaryTree {

    int distributeCoins(TreeNode root);

    class DistributeCoinsInBinaryTreeRev1 implements DistributeCoinsInBinaryTree {

        @Override
        public int distributeCoins(TreeNode root) {
            int[] moves = {0};
            traverse(root, moves);
            return moves[0];
        }

        // Returns the number of extra coins for this node. The sign of the result matters:
        // result > 0 means that extra coins will be given to the parent node, whereas
        // result < 0 means that extra coins will be taken from the parent node.
        // Regardless of the sign, the total number of moves increments by |extra coins| value.
        private int traverse(TreeNode node, int[] moves) {
            if (node == null) {
                return 0;
            }

            int lhsExtraCoins = traverse(node.left, moves);
            int rhsExtraCoins = traverse(node.right, moves);

            int extraCoins = (node.val - 1) + lhsExtraCoins + rhsExtraCoins;
            moves[0] += Math.abs(extraCoins);
            return extraCoins;
        }
    }

    class DistributeCoinsInBinaryTreeRev2 implements DistributeCoinsInBinaryTree {

        @Override
        public int distributeCoins(TreeNode root) {
            TreeNodeInfo info = traverse(root);
            return info.totalMoves;
        }

        // Returns the number of extra coins for this node. The sign of the result matters:
        // result > 0 means that extra coins will be given to the parent node, whereas
        // result < 0 means that extra coins will be taken from the parent node.
        // Regardless of the sign, the total number of moves increments by |extra coins| value.
        private TreeNodeInfo traverse(TreeNode node) {
            if (node == null) {
                return new TreeNodeInfo(0, 0);
            }

            TreeNodeInfo lhs = traverse(node.left);
            TreeNodeInfo rhs = traverse(node.right);

            int extraCoins = (node.val - 1) + lhs.extraCoins + rhs.extraCoins;
            int totalMoves = Math.abs(extraCoins) + lhs.totalMoves + rhs.totalMoves;
            return new TreeNodeInfo(extraCoins, totalMoves);
        }

        private record TreeNodeInfo(int extraCoins, int totalMoves) {
        }
    }
}
