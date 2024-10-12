public class Main {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        five.left = three;
        five.right = seven;
        TreeNode ten = new TreeNode(10);
        TreeNode fifteen = new TreeNode(15);
        TreeNode eighteen = new TreeNode(18);
        ten.left = five;
        ten.right = fifteen;
        fifteen.right = eighteen;

        Solution s = new Solution();
        System.out.println(s.rangeSumBST(ten, 7, 15));

    }
}
