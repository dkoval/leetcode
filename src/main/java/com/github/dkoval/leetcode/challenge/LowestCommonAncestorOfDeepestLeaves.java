package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/">Lowest Common Ancestor of Deepest Leaves</a>
 * <p>
 * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
 * <p>
 * Recall that:
 * <ul>
 *  <li>The node of a binary tree is a leaf if and only if it has no children</li>
 *  <li>The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.</li>
 *  <li>The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.</li>
 * </ul>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree will be in the range [1, 1000].</li>
 *  <li>0 <= Node.val <= 1000</li>
 *  <li>The values of the nodes in the tree are unique.</li>
 * </ul>
 */
public interface LowestCommonAncestorOfDeepestLeaves {

    TreeNode lcaDeepestLeaves(TreeNode root);

    class LowestCommonAncestorOfDeepestLeavesRev1 implements LowestCommonAncestorOfDeepestLeaves {

        @Override
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            final var info = postorder(root, 0);
            return info.node;
        }

        private TreeNodeInfo postorder(TreeNode node, int depth) {
            if (node == null) {
                return new TreeNodeInfo(null, depth);
            }

            final var linfo = postorder(node.left, depth + 1);
            final var rinfo = postorder(node.right, depth + 1);

            if (linfo.depth > rinfo.depth) {
                return linfo;
            } else if (linfo.depth < rinfo.depth) {
                return rinfo;
            }
            return new TreeNodeInfo(node, linfo.depth);
        }

        private record TreeNodeInfo(
                TreeNode node,
                int depth
        ) {
        }
    }
}
