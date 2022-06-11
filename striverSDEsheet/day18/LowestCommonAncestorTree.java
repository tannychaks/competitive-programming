package striverSDEsheet.day18;

public class LowestCommonAncestorTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode p = root.right.left;
        TreeNode q = root.right.right;
        TreeNode node = lowestCommonAncestor(root, p, q);
        LowestCommonAncestorTree tree = new LowestCommonAncestorTree();
        tree.printList(node);
    }

    private void printList(TreeNode node) {
        if (node != null)
            System.out.println(node.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

}
