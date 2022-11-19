package src.EverydayTest;

import java.util.*;

public class solution11_17 {
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            Deque<String>[] d = new Deque[26];
            for (int i = 0; i < 26; ++i) {
                d[i] = new ArrayDeque<>();
            }
            for (String w : words) {
                d[w.charAt(0) - 'a'].add(w);
            }
            int ans = 0;
            for (char c : s.toCharArray()) {
                var q = d[c - 'a'];
                for (int k = q.size(); k > 0; --k) {
                    String t = q.pollFirst();
                    if (t.length() == 1) {
                        ++ans;
                    } else {
                        d[t.charAt(1) - 'a'].offer(t.substring(1));
                    }
                }
            }
            return ans;
        }

    }
}
