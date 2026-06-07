package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions/">Create Binary Tree From Descriptions</a>
 * <p>
 * You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,
 * <p>
 * If isLefti == 1, then childi is the left child of parenti.
 * <p>
 * If isLefti == 0, then childi is the right child of parenti.
 * Construct the binary tree described by descriptions and return its root.
 * <p>
 * The test cases will be generated such that the binary tree is valid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= descriptions.length <= 10^4</li>
 *  <li>descriptions[i].length == 3</li>
 *  <li>1 <= parenti, childi <= 10^5</li>
 *  <li>0 <= isLefti <= 1</li>
 *  <li>The binary tree described by descriptions is valid.</li>
 * </ul>
 */
public interface CreateBinaryTreeFromDescriptions {

    TreeNode createBinaryTree(int[][] descriptions);

    class CreateBinaryTreeFromDescriptionsRev1 implements CreateBinaryTreeFromDescriptions {

        @Override
        public TreeNode createBinaryTree(int[][] descriptions) {
            final var parents = new HashSet<Integer>();
            final var children = new HashSet<Integer>();
            final var lookup = new HashMap<Integer, TreeNode>();

            for (var description : descriptions) {
                final var parent = description[0];
                final var child = description[1];
                final var isLeft = description[2];

                parents.add(parent);
                children.add(child);

                final var parentNode = lookup.computeIfAbsent(parent, __ -> new TreeNode(parent));
                final var childNode = lookup.computeIfAbsent(child, __ -> new TreeNode(child));
                addChild(parentNode, childNode, isLeft == 1);
            }

            final var root = findRoot(parents, children);
            return lookup.get(root);
        }

        private void addChild(TreeNode parent, TreeNode child, boolean isLeft) {
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        private int findRoot(Set<Integer> parents, Set<Integer> children) {
            // the root node never appears as a child to any other node
            for (var parent : parents) {
                if (!children.contains(parent)) {
                    return parent;
                }
            }
            throw new IllegalStateException("Could not determine the root node");
        }
    }
}
