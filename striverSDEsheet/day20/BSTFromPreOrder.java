package striverSDEsheet.day20;

public class BSTFromPreOrder {
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

        int[] preorder = new int[] { 8, 5, 1, 7, 10, 12 };
        TreeNode ans = bstFromPreorder(preorder);
        if (ans != null)
            System.out.println(ans.val);
    }

    private static TreeNode bstFromPreorder(int[] preorder) {

        return buildtreehelper(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    private static TreeNode buildtreehelper(int[] preorder, int maxValue, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > maxValue)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = buildtreehelper(preorder, root.val, i);
        root.right = buildtreehelper(preorder, maxValue, i);
        return root;
    }

}
