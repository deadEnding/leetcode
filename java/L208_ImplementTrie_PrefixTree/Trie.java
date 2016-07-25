package L208_ImplementTrie_PrefixTree;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 7:07 PM 7/22/16
 * @version: 1.0
 * @description: Leetcode 208. Implement Trie (Prefix Tree)
 */


class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(char c) {
        this();
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))
                return null;
            node = node.children.get(c);
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if (node != null && node.isWord)
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node == null)
            return false;
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deadend");
        System.out.println(trie.search("dadend"));
        System.out.println(trie.startsWith("dead"));
        System.out.println(trie.startsWith("xx"));
    }
}
