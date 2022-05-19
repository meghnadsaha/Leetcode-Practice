package com.interview.random.uber;

//        How do we instantly know the current character is invalid? HashMap?
//        How do we instantly know what's the next valid character? LinkedList?
//        But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
//        Combing them, Trie is the natural choice. Notice that:
//
//        TrieNode is all we need. search and startsWith are useless.
//        No need to store character at TrieNode. c.next[i] != null is enough.
//        Never use c1 + c2 + c3. Use StringBuilder.
//        No need to use O(n^2) extra space visited[m][n].
//        No need to use StringBuilder. Storing word itself at leaf node is enough.
//        No need to use HashSet to de-duplicate. Use "one time search" trie.


import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class WordSearchII212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) {
            TrieNode p = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null)
            return;
        root = root.next[c - 'a'];
        if (root.word != null) {//found one word
            res.add(root.word);
            root.word = null;//de-duplicate
        }

        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, root, res);
        if (j > 0)
            dfs(board, i, j - 1, root, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, root, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, root, res);


        board[i][j] = c;
    }


}