package striverSDEsheet.day27;

public class TrieDriver1 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }

}

class NodeII {
    NodeII[] links = new NodeII[26];
    boolean flag = false;

    NodeII() {
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

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {

    private static NodeII root;

    public Trie() {
        root = new NodeII();
    }

    public void insert(String word) {
        NodeII node = root;

        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) {
            if (!node.containsKey(ch))
                node.put(ch, new NodeII());
            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        NodeII node = root;

        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) {
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        if (node.isEnd())
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        NodeII node = root;

        char[] wordArr = prefix.toCharArray();
        for (char ch : wordArr) {
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }

        return true;
    }
}