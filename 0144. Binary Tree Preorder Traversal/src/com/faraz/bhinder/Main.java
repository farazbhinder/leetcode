package com.faraz.bhinder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));
        Solution s = new Solution();

        s.preOrderHelper(root);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }

    public void preOrderHelper(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
        }
        if (root != null && root.left != null) {
            preOrderHelper(root.left);
        }
        if (root != null && root.right != null) {
            preOrderHelper(root.right);
        }

    }
}

/*
            1
          /   \
        /       \
       2         3
     /  \       / \
    4   5      6   7

preOrderHelper(1)
    sout 1
    preOrderHelper(2)
        sout 2
        preOrderHelper(4)
            sout 4
        preOrderHelper(5)
            sout 5
    preOrderHelper(3)
        sout 3
        preOrderHelper(6)
            sout 6
        preOrderHelper(7)
            sout 7

*/