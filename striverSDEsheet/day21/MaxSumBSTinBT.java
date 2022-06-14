package striverSDEsheet.day21;

public class MaxSumBSTinBT {
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
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        int ans = maxSumBST(root);
        System.out.println(ans);
    }

    static int max = 0;

    private static int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return max;
    }

    static class NodeTuple {
        int maxNode, minNode, sum;

        NodeTuple(int maxNode, int minNode, int sum) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.sum = sum;
        }
    }

    private static NodeTuple maxSumBSTHelper(TreeNode root) {
        if (root == null)
            return new NodeTuple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeTuple l = maxSumBSTHelper(root.left);
        NodeTuple r = maxSumBSTHelper(root.right);

        if (l.maxNode < root.val && root.val < r.minNode) // Valid BST
        {
            int curSum = l.sum + r.sum + root.val;
            max = Math.max(max, curSum);
            return new NodeTuple(Math.max(root.val, r.maxNode), Math.min(root.val, l.minNode),
                    curSum);
        }
        return new NodeTuple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
}
