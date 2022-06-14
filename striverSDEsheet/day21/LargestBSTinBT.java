package striverSDEsheet.day21;

public class LargestBSTinBT {
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
        int ans = largestSizeBST(root);
        System.out.println(ans);
    }

    private static int largestSizeBST(TreeNode root) {

        return largestSizeBSTHelper(root).maxSize;
    }

    static class NodeTuple {
        int minNode, maxNode, maxSize;

        NodeTuple(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    private static NodeTuple largestSizeBSTHelper(TreeNode root) {
        if (root == null)
            return new NodeTuple(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeTuple l = largestSizeBSTHelper(root.left);
        NodeTuple r = largestSizeBSTHelper(root.right);

        if (l.maxNode < root.val && r.minNode > root.val) // Valid BST
            return new NodeTuple(Math.min(root.val, l.minNode), Math.max(root.val, r.maxNode),
                    l.maxSize + r.maxSize + 1);
        return new NodeTuple(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l.maxSize, r.maxSize));
    }

}
