package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
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
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ans = postorderTraversal(root);
        ans.stream().forEach(val -> System.out.print(val + " "));

        System.out.println();
        List<Integer> iterativeAns = postorderTraversalIterative(root);
        iterativeAns.stream().forEach(val -> System.out.print(val + " "));

        System.out.println();
        List<Integer> iterativeAnsOpt = postorderTraversalIterativeOptimized(root);
        iterativeAnsOpt.stream().forEach(val -> System.out.print(val + " "));
    }

    // Using 2 stacks
    private static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.add(root);
            if (root.left != null)
                st1.push(root.left);
            if (root.right != null)
                st1.push(root.right);
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
        return ans;
    }

    // Using 1 stack
    private static List<Integer> postorderTraversalIterativeOptimized(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    ans.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                } else
                    curr = temp;
            }
        }
        return ans;

    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }

}
