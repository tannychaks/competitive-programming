package striverSDEsheet.day21;

public class KthSmallestBST {
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

        int k = 5;
        int ans = kthSmallest(root, k);
        System.out.println(ans);
    }

    private static int kthSmallest(TreeNode root, int k) {
        TreeNode node = kthSmallestHelper(root, new int[] { k });
        if (node != null)
            return node.val;
        else
            return -1;
    }

    private static TreeNode kthSmallestHelper(TreeNode root, int[] k) {
        if (root == null)
            return null;
        TreeNode left = kthSmallestHelper(root.left, k);
        if (left != null)
            return left;
        k[0]--;
        if (k[0] == 0)
            return root;
        return kthSmallestHelper(root.right, k);
    }
}
