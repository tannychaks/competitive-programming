package striverSDEsheet.day18;

public class SameTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);

        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(9);
        q.right = new TreeNode(20);
        q.right.left = new TreeNode(15);
        q.right.right = new TreeNode(7);

        boolean ans = isSameTree(p, q);
        System.out.println(ans);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
