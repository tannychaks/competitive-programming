package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

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

        List<Integer> ans = inorderTraversal(root);
        ans.stream().forEach(val -> System.out.print(val + " "));

        System.out.println();
        List<Integer> iterativeAns = inorderTraversalIterative(root);
        iterativeAns.stream().forEach(val -> System.out.print(val + " "));
    }

    private static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty())
                    break;

                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }

}
