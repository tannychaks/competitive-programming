package striverSDEsheet.day27;

public class CompleteString {
    public static void main(String[] args) {
        int n = 6;
        String[] a = new String[] { "n", "ni", "ninja", "nin", "ninj", "ninga" };

        String ans = completeString(n, a);
        System.out.println(ans);
    }

    static class Node {

        private Node[] links;
        private boolean flag;

        Node() {
            links = new Node[26];
            flag = false;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            this.flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;

            char[] wordArr = word.toCharArray();

            for (char ch : wordArr) {
                if (!node.containsKey(ch))
                    node.put(ch, new Node());
                node = node.get(ch);
            }
            node.setEnd();
        }

        public boolean checkIfPrefixExists(String word) {
            Node node = root;
            boolean flag = true;
            char[] wordArr = word.toCharArray();
            for (char ch : wordArr) {
                if (flag) {

                    if (!node.containsKey(ch))
                        return false;
                    node = node.get(ch);
                    flag = flag & node.isEnd();
                }
            }

            return flag;
        }
    }

    private static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (int i = 0; i < n; i++)
            trie.insert(a[i]);
        String longest = "";
        for (String word : a) {
            if (trie.checkIfPrefixExists(word)) {
                if (word.length() > longest.length())
                    longest = word;
                else if (word.length() == longest.length() && word.compareTo(longest) < 0)
                    longest = word;
            }
        }
        if (longest == "")
            return "None";
        return longest;
    }

}
