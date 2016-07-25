package L211_AddAndSearchWord_DataStructureDesign;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 9:19 PM 7/22/16
 * @version: 1.0
 * @description: Leetcode 211. Add and Search Word - Data structure design
 */


public class WordDictionary {

    private class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }

        public TrieNode(char c) {
            this();
            isWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    private boolean search(String word, int ix, TrieNode node) {
        if (ix >= word.length())
            return node.isWord;

        char c = word.charAt(ix);

        if (c == '.') {
            for (Map.Entry<Character, TrieNode> e : node.children.entrySet()) {
                if (search(word, ix + 1, e.getValue()))
                    return true;
            }
            return false;
        } else {
            if (!node.children.containsKey(c))
                return false;
            return search(word, ix + 1, node.children.get(c));
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("deadend");
        System.out.println(wordDictionary.search("dea.end"));
        System.out.println(wordDictionary.search("dea...."));
        System.out.println(wordDictionary.search("dead"));
    }
}
