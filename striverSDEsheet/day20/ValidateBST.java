package striverSDEsheet.day20;

public class ValidateBST {
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

        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        boolean ans = isValidBST(root);
        System.out.println(ans);
    }

    private static boolean isValidBST(TreeNode root) {
        return validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateHelper(TreeNode root, long minValue, long maxValue) {

        if (root == null)
            return true;
        if (root.val >= maxValue || root.val <= minValue)
            return false;
        return validateHelper(root.left, minValue, root.val) && validateHelper(root.right, root.val, maxValue);
    }
}
