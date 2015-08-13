/*
 * Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    
    static final int TrieRange = 26;
    TrieNode next[];
    boolean isSet;
    // Initialize your data structure here.
    public TrieNode() {
        this.next = new TrieNode[TrieRange];
        this.isSet = false;
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    private TrieNode insertWord(TrieNode node, String word, int idx) {
        if (node == null) 
            node = new TrieNode();
        if (idx == word.length()) {
            node.isSet = true;
            return node;
        }
        int key = word.charAt(idx) - 'a';
        
        node.next[key] = insertWord(node.next[key], word, idx+1);
        
        return node;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        insertWord(root, word, 0);
        
    }
    
    private boolean searchWord(TrieNode node, String word, int idx) {
        if (node == null)
            return false;
        if (idx == word.length()) {
            if (node.isSet)
                return true;
            else 
                return false;
        }

        int key = word.charAt(idx) - 'a';
        return searchWord(node.next[key], word, idx+1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return true;
        return searchWord(root, word, 0);
    }
    private boolean searchPrefix(TrieNode node, String word, int idx) {
        if (node == null)
            return false;
        if (idx == word.length())
            return true;
        int key = word.charAt(idx) - 'a';
        return searchPrefix(node.next[key], word, idx+1);
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchPrefix(root, prefix, 0);
    }
    
    public static void main(String args[]) {
        Trie t = new Trie();
        t.insert("ab");
        System.out.println(t.startsWith("a"));
    }
}
