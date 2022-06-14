package striverSDEsheet.day21;

import java.util.Stack;

public class BSTIterator {
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

    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    private void pushAll(TreeNode root) {
        for (; root != null; st.push(root), root = root.left)
            ;
    }

    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next()); // return 3
        System.out.println(bSTIterator.next()); // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next()); // return 20
        System.out.println(bSTIterator.hasNext()); // return False

    }
}
