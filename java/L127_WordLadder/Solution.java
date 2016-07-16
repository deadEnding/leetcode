package L127_WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: deadend
 * @date: 1:48 PM 7/16/16
 * @version: 1.0
 * @description: Leetcode 127. Word Ladder
 */


public class Solution {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        final String dummy = new String();
        queue.offer(beginWord);
        queue.offer(dummy);

        int level = 1;
        HashSet<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            if (currWord.equals(dummy)) {
                level++;
                if (!queue.isEmpty())
                    queue.offer(dummy);
            } else {
                char[] chars = currWord.toCharArray();
                for (int i = 0; i < currWord.length(); ++i) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z'; ++j) {
                        if (old == j)
                            continue;
                        chars[i] = j;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[i] = old;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        String[] slist = {"a", "b", "c"};
        Set<String> wordList = new HashSet<>();
        for (String s : slist) {
            wordList.add(s);
        }

        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
