package striverSDEsheet.day19;

public class SymmetricTree {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        boolean ans = isSymmetric(root);
        System.out.println(ans);
    }

    /**
     * Time Complexity: O(N)
     * 
     * Reason: We are doing simple tree traversal and changing both root1 and root2
     * simultaneously.
     * 
     * Space Complexity: O(N)
     * 
     * Reason: In the worst case (skewed tree), space complexity can be O(N).
     * 
     * @param root
     * @return
     */
    private static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
