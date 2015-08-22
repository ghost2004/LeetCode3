/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing
 only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */


public class WordDictionary {
    class TrieNode {
        boolean flag;
        char val;
        TrieNode next[];
        
        public TrieNode() {
            next = new TrieNode[26];
            flag = false;
        }
        
    }
    
    private TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    private void addWord(TrieNode node, String word) {
        if (word.length() == 0) {
            node.flag  = true;
            return;
        }
        int key = word.charAt(0) - 'a';
        TrieNode n = node.next[key];
        if (n == null) {
            n = new TrieNode();
            node.next[key] = n;
            n.val = word.charAt(0);
        }
        addWord(n, word.substring(1));
            
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(root, word);
    }
    
    private boolean search(TrieNode node,String word) {
        if (node == null)
            return false;
        
        if (word.length() == 0) {
            return node.flag;
        }
        
        int keyStart = 0;
        int keyEnd = 0;
        if (word.charAt(0) == '.') {
            keyEnd = 25;
        } else {
            keyStart = word.charAt(0) - 'a';
            keyEnd = keyStart;
        }
        String key = word.substring(1);
        for (int i = keyStart; i <= keyEnd; i++) {
            if (search(node.next[i], key))
                return true;
        }
        
        return false;
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        
        return search(root, word);
    }
    
    public static void main(String args[]) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        System.out.println(w.search("."));
    }
}
