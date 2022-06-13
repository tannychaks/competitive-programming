package striverSDEsheet.day20;

public class LowestCommonAncestorBST {
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

        TreeNode p = root.left.left;
        TreeNode q = root.left.right;

        TreeNode node = lowestCommonAncestor(root, p, q);
        if (node != null)
            System.out.println(node.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        int cur = root.val;
        if (cur < p.val && cur < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (cur > p.val && cur > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
