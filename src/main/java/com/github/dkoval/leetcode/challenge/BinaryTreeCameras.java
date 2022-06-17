package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/binary-tree-cameras//">Binary Tree Cameras (Hard)</a>
 * <p>
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor
 * its parent, itself, and its immediate children.
 * <p>
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the given tree will be in the range [1, 1000]</li>
 *  <li>Every node has value 0</li>
 * </ul>
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
            // Idea: an arbitrary node can either be monitored by itself or by its parent, or by its children
            // DP: recursive top-down with memoization
            Map<State, Integer> memo = new HashMap<>();
            return cover(root, false, false, memo);
        }

        private int cover(TreeNode node, boolean hasCamera, boolean parentHasCamera, Map<State, Integer> memo) {
            if (node == null) {
                return 0;
            }

            State key = new State(node, hasCamera, parentHasCamera);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int minCount = Integer.MAX_VALUE;
            if (hasCamera) {
                // nothing to do since the current node monitors itself, its parent and immediate children
                minCount = Math.min(minCount,
                        cover(node.left, false, true, memo)
                                + cover(node.right, false, true, memo));
            } else if (parentHasCamera) {
                // option #1: don't place a camera at the current node since it gets monitored by its parent
                minCount = Math.min(minCount,
                        cover(node.left, false, false, memo)
                                + cover(node.right, false, false, memo));

                // option #2: place a camera at the current node to get it monitored
                minCount = Math.min(minCount,
                        1 + cover(node.left, false, true, memo)
                                + cover(node.right, false, true, memo));
            } else {
                // option #1: place a camera at the current node to get it monitored
                minCount = Math.min(minCount,
                        1 + cover(node.left, false, true, memo)
                                + cover(node.right, false, true, memo));

                // option #2: place a camera at the root node of the left subtree to get the current node monitored
                if (node.left != null) {
                    minCount = Math.min(minCount,
                            1 + cover(node.left, true, false, memo)
                                    + cover(node.right, false, false, memo));
                }

                // option #3: place a camera at the root node of the right subtree to get the current node monitored
                if (node.right != null) {
                    minCount = Math.min(minCount,
                            1 + cover(node.right, true, false, memo)
                                    + cover(node.left, false, false, memo));
                }
            }

            memo.put(key, minCount);
            return minCount;
        }
    }

    class BinaryTreeCamerasUsingPostorderTraversalWithStatuses implements BinaryTreeCameras {

        private enum Status {
            NEEDS_CAMERA, HAS_CAMERA, COVERED
        }

        private int numCameras = 0;

        @Override
        public int minCameraCover(TreeNode root) {
            return cover(root) == Status.NEEDS_CAMERA ? numCameras + 1 : numCameras;
        }

        private Status cover(TreeNode root) {
            if (root == null) {
                return Status.COVERED;
            }

            // post-order traversal
            Status l = cover(root.left);
            Status r = cover(root.right);

            // if any one of the children is not covered then we must place a camera at the current node
            if (l == Status.NEEDS_CAMERA || r == Status.NEEDS_CAMERA) {
                numCameras++;
                return Status.HAS_CAMERA;
            }

            // if any of the children has camera then the current node is also covered
            if (l == Status.HAS_CAMERA || r == Status.HAS_CAMERA) {
                return Status.COVERED;
            }

            // if none of the children is covers the current node then ask its parent to cover
            return Status.NEEDS_CAMERA;
        }
    }
}
