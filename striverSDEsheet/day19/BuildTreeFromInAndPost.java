package striverSDEsheet.day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BuildTreeFromInAndPost {
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

    /**
     * .Time Complexity: O(N)
     * 
     * Assumption: Hashmap returns the answer in constant time.
     * 
     * Space Complexity: O(N)
     * 
     * Reason: We are using an external hashmap of size ‘N’.
     */

    public static void main(String[] args) {
        int[] postorder = new int[] { 9, 15, 7, 20, 3 }, inorder = new int[] { 9, 3, 15, 20, 7 };
        TreeNode ans = buildTree(postorder, inorder);

        printTreeLevelWise(ans);
    }

    private static TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null)
            return null;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            mp.put(inorder[i], i);
        TreeNode root = buildTreeRecursive(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, mp);
        return root;
    }

    private static TreeNode buildTreeRecursive(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart,
            int inEnd,
            Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = buildTreeRecursive(postorder,
                postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1,
                inMap);
        root.right = buildTreeRecursive(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd,
                inMap);
        return root;
    }

    /**
     * LevelOrder Traversal
     * 
     * @param ans
     */
    private static void printTreeLevelWise(TreeNode root) {
        List<List<Integer>> ans = levelOrder(root);
        ans.stream().forEach(list -> {
            list.stream().forEach(val -> System.out.print(val + " "));
            System.out.println();
        });
    }

    /**
     * BFS
     * 
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }

}
