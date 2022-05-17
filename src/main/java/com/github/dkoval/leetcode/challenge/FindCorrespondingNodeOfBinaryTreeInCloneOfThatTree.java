package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/">Find a Corresponding Node of a Binary Tree in a Clone of That Tree</a>
 * <p>
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * <p>
 * The cloned tree is a copy of the original tree.
 * <p>
 * Return a reference to the same node in the cloned tree.
 * <p>
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *  <li>The values of the nodes of the tree are unique</li>
 *  <li>target node is a node from the original tree and is not null</li>
 * </ul>
 */
public interface FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

    TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target);

    class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTreeDFS implements FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

        @Override
        public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
            if (original == null || cloned == null) {
                return null;
            }

            if (original.val == target.val && cloned.val == target.val) {
                return cloned;
            }

            TreeNode ans = getTargetCopy(original.left, cloned.left, target);
            if (ans == null) {
                ans = getTargetCopy(original.right, cloned.right, target);
            }
            return ans;
        }
    }

    class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTreeBFS implements FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

        private static class Pair {
            final TreeNode original;
            final TreeNode cloned;

            Pair(TreeNode original, TreeNode cloned) {
                this.original = original;
                this.cloned = cloned;
            }
        }

        @Override
        public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
            // BFS
            Queue<Pair> q = new ArrayDeque<>();
            q.offer(new Pair(original, cloned));
            while (!q.isEmpty()) {
                Pair curr = q.poll();
                if (curr.original.val == target.val && curr.cloned.val == target.val) {
                    return curr.cloned;
                }

                if (curr.original.left != null) {
                    q.offer(new Pair(curr.original.left, curr.cloned.left));
                }

                if (curr.original.right != null) {
                    q.offer(new Pair(curr.original.right, curr.cloned.right));
                }
            }
            return null;
        }
    }
}
