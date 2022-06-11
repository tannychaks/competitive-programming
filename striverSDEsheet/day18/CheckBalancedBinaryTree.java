package striverSDEsheet.day18;

public class CheckBalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(20);
        root.left.left.left = new TreeNode(15);
        boolean ans = isBalanced(root);
        System.out.println(ans);
    }

    private static boolean isBalanced(TreeNode root) {
        return (checkBT(root) != -1);
    }

    private static int checkBT(TreeNode root) {
        if (root == null)
            return 0;

        int lh = checkBT(root.left);
        if (lh == -1)
            return -1;
        int rh = checkBT(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }

}
