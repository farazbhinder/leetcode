package com.faraz.bhinder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));
        Solution s = new Solution();

        List<Integer> postOrderList = s.postorderTraversal(root);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        list.clear();
        postOrderHelper(root);
        return list;

    }

    private void postOrderHelper(TreeNode root) {
        if (root != null && root.left != null) {
            postOrderHelper(root.left);
        }
        if (root != null && root.right != null) {
            postOrderHelper(root.right);
        }
        if (root != null) {
            list.add(root.val);
        }
    }
}