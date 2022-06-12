package striverSDEsheet.day19;

public class MaxPathSum {
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

        int ans = maxPathSum(root);
        System.out.println(ans);
    }

    private static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        getMaxPathSum(root, maxSum);
        return maxSum[0];
    }

    private static int getMaxPathSum(TreeNode root, int[] maxSum) {
        if (root == null)
            return 0;
        int leftMaxSum = Math.max(0, getMaxPathSum(root.left, maxSum));
        int rightMaxSum = Math.max(0, getMaxPathSum(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftMaxSum + rightMaxSum + root.val);
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }

}
