package Medium;

import java.util.*;

public class _127 {
    private Set<String> dir;
    private Queue<String> queue1;
    private Queue<String> queue2;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dir = new HashSet<>();
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        char[] cha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (String word : wordList) {
            dir.add(word);
        }
        queue1.add(beginWord);
        int count = 1;
        Set<String> accessed = new HashSet<>();
        while (!queue1.isEmpty()) {
            count++;
            while (!queue1.isEmpty()) {
                char[] cs = queue1.remove().toCharArray();
                for (int i = 0; i < cha.length; i++) {
                    for (int j = 0; j <cs.length ; j++) {
                        char[] tmp = cs.clone();
                        tmp[j] = cha[i];
                        String s = new String(tmp);
                        if (endWord.equals(s)) {
                            return count;
                        }
                        if (!accessed.contains(s)&&dir.contains(s)) {
                            accessed.add(s);
                            queue2.add(s);
                        }
                    }
                }
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return count;
    }
}
