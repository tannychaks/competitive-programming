package striverSDEsheet.day21;

import java.util.Stack;

public class TwoSumBST {

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 9;

        TwoSumBST bst = new TwoSumBST();
        System.out.println(bst.findTarget(root, k));
    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int l = left.next();
        int r = right.next();

        while (l < r) {
            if (l + r == k)
                return true;
            else if (l + r < k)
                l = left.next();
            else
                r = right.next();
        }
        return false;
    }

    static class BSTIterator {

        Stack<TreeNode> st = new Stack<>();
        boolean reverse = true;

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root, reverse);
        }

        private void pushAll(TreeNode root, boolean isReverse) {
            while (root != null) {
                st.push(root);
                if (isReverse)
                    root = root.right;
                else
                    root = root.left;
            }
        }

        public int next() {
            TreeNode node = st.pop();
            if (!reverse)
                pushAll(node.right, reverse);
            else
                pushAll(node.left, reverse);
            return node.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

    }
}
