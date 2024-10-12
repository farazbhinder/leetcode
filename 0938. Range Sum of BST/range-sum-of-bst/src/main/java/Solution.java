public class Solution {
    int GLOBAL_SUM = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTHelper(root, low, high);
    }

    private int rangeSumBSTHelper(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            rangeSumBSTHelper(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            GLOBAL_SUM = GLOBAL_SUM + root.val;
        }
        if (root.right != null) {
            rangeSumBSTHelper(root.right, low, high);
        }
        return GLOBAL_SUM;
    }
}