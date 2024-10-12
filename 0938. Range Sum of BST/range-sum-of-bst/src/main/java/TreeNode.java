/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;            // The value of the node
    TreeNode left;     // Reference to the left child
    TreeNode right;    // Reference to the right child

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;        // Set the value of the node
        this.left = left;      // Set the left child
        this.right = right;    // Set the right child
    }
}
