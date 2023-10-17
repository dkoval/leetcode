package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">Validate Binary Tree Nodes</a>
 * <p>
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i],
 * return true if and only if all the given nodes form exactly one valid binary tree.
 * <p>
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 * <p>
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == leftChild.length == rightChild.length</li>
 *  <li>1 <= n <= 104</li>
 *  <li>-1 <= leftChild[i], rightChild[i] <= n - 1</li>
 * </ul>
 */
public interface ValidateBinaryTreeNodes {

    boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild);

    class ValidateBinaryTreeNodesRev1 implements ValidateBinaryTreeNodes {

        @Override
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            int[] indegree = new int[n];
            for (int i = 0; i < n; i++) {
                if (leftChild[i] != -1) {
                    if (++indegree[leftChild[i]] >= 2) {
                        return false;
                    }
                }

                if (rightChild[i] != -1) {
                    if (++indegree[rightChild[i]] >= 2) {
                        return false;
                    }
                }
            }

            int root = getRoot(indegree);
            if (root == -1) {
                return false;
            }

            // run DFS to make sure the graph is connected and has no cycles
            Set<Integer> visited = new HashSet<>();
            dfs(root, leftChild, rightChild, visited);
            return visited.size() == n;
        }

        private int getRoot(int[] indegree) {
            int root = -1;
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    // exactly 1 node has no parent
                    if (root != -1) {
                        return -1;
                    }
                    root = i;
                }
            }
            return root;
        }

        private void dfs(int root, int[] leftChild, int[] rightChild, Set<Integer> visited) {
            visited.add(root);
            if (leftChild[root] != -1 && !visited.contains(leftChild[root])) {
                dfs(leftChild[root], leftChild, rightChild, visited);
            }
            if (rightChild[root] != -1 && !visited.contains(rightChild[root])) {
                dfs(rightChild[root], leftChild, rightChild, visited);
            }
        }
    }

    class ValidateBinaryTreeNodesRev2 implements ValidateBinaryTreeNodes {

        @Override
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            int root = getRoot(n, leftChild, rightChild);
            if (root == -1) {
                return false;
            }

            // run DFS to make sure the graph is connected and has no cycles
            Set<Integer> visited = new HashSet<>();
            return dfs(root, leftChild, rightChild, visited) && (visited.size() == n);
        }

        private int getRoot(int n, int[] leftChild, int[] rightChild) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (leftChild[i] != -1) {
                    seen.add(leftChild[i]);
                }

                if (rightChild[i] != -1) {
                    seen.add(rightChild[i]);
                }
            }

            if (seen.size() != n - 1) {
                return -1;
            }

            for (int root = 0; root < n; root++) {
                if (!seen.contains(root)) {
                    return root;
                }
            }
            return -1;
        }

        private boolean dfs(int root, int[] leftChild, int[] rightChild, Set<Integer> visited) {
            if (visited.contains(root)) {
                return false;
            }

            if (root == -1) {
                return true;
            }

            visited.add(root);
            return dfs(leftChild[root], leftChild, rightChild, visited) && dfs(rightChild[root], leftChild, rightChild, visited);
        }
    }
}
