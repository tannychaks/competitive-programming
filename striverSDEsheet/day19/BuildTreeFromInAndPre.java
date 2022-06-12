package striverSDEsheet.day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BuildTreeFromInAndPre {
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
      int[] preorder = new int[] { 3, 9, 20, 15, 7 }, inorder = new int[] { 9, 3, 15, 20, 7 };
      TreeNode ans = buildTree(preorder, inorder);

      printTreeLevelWise(ans);
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

   private static TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null)
         return null;
      Map<Integer, Integer> mp = new HashMap<>();
      for (int i = 0; i < inorder.length; i++)
         mp.put(inorder[i], i);
      TreeNode root = buildTreeRecursive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mp);
      return root;
   }

   private static TreeNode buildTreeRecursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
         int inEnd,
         Map<Integer, Integer> inMap) {

      if (preStart > preEnd || inStart > inEnd)
         return null;

      TreeNode root = new TreeNode(preorder[preStart]);
      int inRoot = inMap.get(root.val);

      int numsLeft = inRoot - inStart;

      root.left = buildTreeRecursive(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);

      root.right = buildTreeRecursive(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
      return root;
   }
}
