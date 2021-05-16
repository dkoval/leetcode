package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/">Binary Tree Cameras</a>
 * <p>
 * Given a binary tree, we install cameras on the nodes of the tree.
 * <p>
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 */
public interface BinaryTreeCameras {

    int minCameraCover(TreeNode root);

    // O(N) time | O(N) space
    class BinaryTreeCamerasTopDownWithMemoization implements BinaryTreeCameras {

        private static class State {
            final TreeNode node;
            final boolean hasCamera;
            final boolean parentHasCamera;

            State(TreeNode node, boolean hasCamera, boolean parentHasCamera) {
                this.node = node;
                this.hasCamera = hasCamera;
                this.parentHasCamera = parentHasCamera;
            }

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if (other == null || other.getClass() != getClass()) {
                    return false;
                }
                State that = (State) other;
                return (node == that.node) && (hasCamera == that.hasCamera) && (parentHasCamera == that.parentHasCamera);
            }

            @Override
            public int hashCode() {
                return Objects.hash(node, hasCamera, parentHasCamera);
            }
        }

        @Override
        public int minCameraCover(TreeNode root) {
            // DP: recursive top-down with memoization
            Map<State, Integer> memo = new HashMap<>();
            return minCameraCover(root, false, false, memo);
        }

        private int minCameraCover(TreeNode node, boolean hasCamera, boolean parentHasCamera, Map<State, Integer> memo) {
            if (node == null) {
                return 0;
            }

            State key = new State(node, hasCamera, parentHasCamera);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int minCount = Integer.MAX_VALUE;
            if (hasCamera) {
                int currCount = minCameraCover(node.left, false, true, memo)
                        + minCameraCover(node.right, false, true, memo);
                minCount = Math.min(minCount, currCount);
            } else if (parentHasCamera) {
                // option #1: don't place a camera into the current node
                int currCount = minCameraCover(node.left, false, false, memo)
                        + minCameraCover(node.right, false, false, memo);
                minCount = Math.min(minCount, currCount);

                // option #2: place a camera into the current node
                currCount = minCameraCover(node.left, false, true, memo)
                        + minCameraCover(node.right, false, true, memo) + 1;
                minCount = Math.min(minCount, currCount);
            } else {
                // option #1: place a camera into the current node
                int currCount = minCameraCover(node.left, false, true, memo)
                        + minCameraCover(node.right, false, true, memo) + 1;
                minCount = Math.min(minCount, currCount);

                // option #2: place a camera into the root node of the left subtree
                if (node.left != null) {
                    currCount = minCameraCover(node.left, true, false, memo)
                            + minCameraCover(node.right, false, false, memo) + 1;
                    minCount = Math.min(minCount, currCount);
                }

                // option #3: place a camera into the root node of the right subtree
                if (node.right != null) {
                    currCount = minCameraCover(node.left, false, false, memo)
                            + minCameraCover(node.right, true, false, memo) + 1;
                    minCount = Math.min(minCount, currCount);
                }
            }

            memo.put(key, minCount);
            return minCount;
        }
    }
}
