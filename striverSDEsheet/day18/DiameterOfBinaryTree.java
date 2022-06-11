package striverSDEsheet.day18;

public class DiameterOfBinaryTree {
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
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        getDiameter(root, diameter);
        return diameter[0];
    }

    private static int getDiameter(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;
        int lh = getDiameter(root.left, diameter);
        int rh = getDiameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

}
