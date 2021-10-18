package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public interface CousinsInBinaryTree {

    boolean isCousins(TreeNode root, int x, int y);

    class CousinsInBinaryTreeBFS implements CousinsInBinaryTree {

        private static class TreeNodeInfo {
            TreeNode self;
            TreeNode parent;

            TreeNodeInfo(TreeNode self, TreeNode parent) {
                this.self = self;
                this.parent = parent;
            }
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            TreeNodeInfo infoX = null;
            TreeNodeInfo infoY = null;

            // BFS
            Queue<TreeNodeInfo> q = new LinkedList<>();
            q.offer(new TreeNodeInfo(root, null));
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNodeInfo info = q.poll();
                    if (info.self.val == x) {
                        infoX = info;
                    } else if (info.self.val == y) {
                        infoY = info;
                    }

                    if (info.self.left != null) {
                        q.offer(new TreeNodeInfo(info.self.left, info.self));
                    }

                    if (info.self.right != null) {
                        q.offer(new TreeNodeInfo(info.self.right, info.self));
                    }
                }

                if (infoX != null && infoY != null) {
                    return (infoX.parent != infoY.parent);
                } else if (infoX != null || infoY != null) {
                    // either x or y was found, but not both
                    return false;
                }
            }
            return false;
        }
    }
}
