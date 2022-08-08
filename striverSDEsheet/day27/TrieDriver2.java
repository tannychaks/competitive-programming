package striverSDEsheet.day27;

public class TrieDriver2 {
    public static void main(String[] args) {
        TrieII trie = new TrieII();
        trie.insert("samsung");
        trie.insert("samsung");
        trie.insert("vivo");
        trie.erase("vivo");
        System.out.println(trie.countWordsEqualTo("samsung")); // return True
        System.out.println(trie.countWordsStartingWith("vi")); // return False
    }

    static class NodeII {
        private NodeII[] links;
        private int cntEndWith;
        private int cntPrefix;

        NodeII() {
            links = new NodeII[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }

        int getEnd() {
            return cntEndWith;
        }

        int getPrefix() {
            return cntPrefix;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        NodeII get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, NodeII node) {
            links[ch - 'a'] = node;
        }

        void increaseEndsWith() {
            cntEndWith++;
        }

        void decreaseEndsWith() {
            cntEndWith--;
        }

        public void increaseCountPrefix() {
            this.cntPrefix++;
        }

        void decreaseCountPrefix() {
            cntPrefix--;
        }
    }

    static class TrieII {

        private static NodeII root;

        public TrieII() {
            root = new NodeII();
        }

        public void insert(String word) {
            NodeII node = root;

            char[] wordArr = word.toCharArray();
            for (char ch : wordArr) {
                if (!node.containsKey(ch))
                    node.put(ch, new NodeII());
                node = node.get(ch);
                node.increaseCountPrefix();
            }

            node.increaseEndsWith();
        }

        public int countWordsEqualTo(String word) {
            NodeII node = root;

            char[] wordArr = word.toCharArray();
            for (char ch : wordArr) {
                if (!node.containsKey(ch))
                    return 0;
                node = node.get(ch);
            }
            return node.getEnd();
        }

        public int countWordsStartingWith(String word) {
            NodeII node = root;

            char[] wordArr = word.toCharArray();

            for (char ch : wordArr) {
                if (!node.containsKey(ch))
                    return 0;
                node = node.get(ch);
            }

            return node.getPrefix();
        }

        public void erase(String word) {
            NodeII node = root;
            char[] wordArr = word.toCharArray();

            for (char ch : wordArr) {
                if (!node.containsKey(ch))
                    return;
                node = node.get(ch);
                node.decreaseCountPrefix();
            }
            node.decreaseEndsWith();
        }
    }
}
