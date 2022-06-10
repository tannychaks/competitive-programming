package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PathToGivenNode {
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

        int b = 7;
        List<Integer> ans = solve(root, b);

        IntStream.range(0, ans.size()).forEach(index -> {
            int val = ans.get(index);
            if (index == ans.size() - 1)
                System.out.print(val);
            else
                System.out.print(val + " -> ");
        });
    }

    /**
     * Time Complexity: O(N)
     * 
     * Reason: We are doing a simple tree traversal.
     * 
     * Space Complexity: O(N)
     * 
     * Reason: In the worst case (skewed tree), space complexity can be O(N).
     * 
     * @param root
     * @param b
     * @return
     */
    private static List<Integer> solve(TreeNode root, int b) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        getPath(root, list, b);
        return list;
    }

    private static boolean getPath(TreeNode root, List<Integer> list, int b) {
        if (root == null)
            return false;
        list.add(root.val);

        if (root.val == b)
            return true;

        if (getPath(root.left, list, b) || getPath(root.right, list, b))
            return true;

        list.remove(list.size() - 1);
        return false;
    }

}
