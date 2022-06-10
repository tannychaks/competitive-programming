package striverSDEsheet.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class PreInPostSingleTraversal {
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

    static class Pair {
        TreeNode node;
        int num;

        Pair() {
        }

        Pair(TreeNode node) {
            this.node = node;
            this.num = 1;
        }

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> ans = traversal(root);
        IntStream.range(0, ans.size()).forEach(index -> {

            switch (index + 1) {
                case 1:
                    System.out.print("PRE-ORDER : ");
                    Optional.ofNullable(ans.get(index)).ifPresent(list -> {
                        list.stream().forEach(val -> System.out.print(val + " "));
                        System.out.println();
                    });
                    break;
                case 2:
                    System.out.print("IN-ORDER : ");
                    Optional.ofNullable(ans.get(index)).ifPresent(list -> {
                        list.stream().forEach(val -> System.out.print(val + " "));
                        System.out.println();
                    });
                    break;
                case 3:
                    System.out.print("POST-ORDER : ");
                    Optional.ofNullable(ans.get(index)).ifPresent(list -> {
                        list.stream().forEach(val -> System.out.print(+val + " "));
                        System.out.println();
                    });
                    break;
            }

        });
    }

    private static List<List<Integer>> traversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root));

        while (!st.isEmpty()) {
            Pair it = st.pop();

            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.left != null)
                    st.push(new Pair(it.node.left));
            } else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.right != null)
                    st.push(new Pair(it.node.right));
            } else {
                post.add(it.node.val);
            }
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        return ans;
    }
}
