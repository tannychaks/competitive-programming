package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem uses Space Complexity as O(1) which was O(N) in case of
 * recursive and iterative solution
 * 
 * TC remains as O(N)
 */
public class MorrisInorderTraversal {

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

        List<Integer> ans = morrisInorderTraversal(root);
        ans.stream().forEach(val -> System.out.print(val + " "));
    }

    private static List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) // Find the rightmost code of curr's left
                    prev = prev.right;
                if (prev.right == null) { // Create a thread
                    prev.right = curr;
                    curr = curr.left;
                } else { // There exist a thread
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }

            }
        }
        return inorder;
    }
}
