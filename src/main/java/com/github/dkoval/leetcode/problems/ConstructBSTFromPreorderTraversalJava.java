package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.TreeNode;
import com.github.dkoval.leetcode.challenge.ConstructBSTFromPreorderTraversal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConstructBSTFromPreorderTraversalJava implements ConstructBSTFromPreorderTraversal {

    @Nullable
    @Override
    public TreeNode bstFromPreorder(@NotNull int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);

        // find index i of the first element > preorder[start];
        // elements of the left sub-tree lie in the range [start + 1 : i - 1], whereas
        // elements of the right sub-tree lie in the range [i : end]
        int i = start;
        while (i <= end && preorder[i] <= preorder[start]) {
            i++;
        }
        root.left = bstFromPreorder(preorder, start + 1, i - 1);
        root.right = bstFromPreorder(preorder, i, end);
        return root;
    }
}
