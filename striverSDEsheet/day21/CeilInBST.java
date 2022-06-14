package striverSDEsheet.day21;

public class CeilInBST {
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

        int x = 5;
        int ans = ceilInBST(root, x);
        System.out.println(ans);
    }

    private static int ceilInBST(TreeNode root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.val == x) {
                ceil = x;
                return ceil;
            }
            if (root.val < x)

                root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
}
