package src.EverydayTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 *
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母c），然后往其中添加相同的字母c使其长度达到 3 或以上。
 *
 * 例如，以"hello" 为例，我们可以对字母组"o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得"helllllooo"。如果S = "helllllooo"，那么查询词"hello" 是可扩张的，因为可以对它执行这两种扩张操作使得query = "hello" -> "hellooo" ->"helllllooo" = S。
 *
 * 输入一组查询单词，输出其中可扩张的单词数量。
 */
public class solution11_25 {
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int result = 0;
            char[] sc = s.toCharArray();
            for (String word: words) result += stretchyWord(sc, word.toCharArray()) ? 1 : 0;
            return result;
        }
        private boolean stretchyWord(char[] str, char[] word) {
            if (str.length < word.length) return false; // word的字符串长度不允许超过s的字符串长度
            int cp, p1 = 0, p2 = p1;
            while ((cp = p1) < str.length && p2 < word.length) {// 以str中的字符为基础
                int c1 = 0, c2 = 0;//记录在string和word中出现的次数
                while (p1 < str.length && str[p1] == str[cp]) {
                    c1++; p1++; // 在字符串s中，遍历连续的字符sc[cp]的数量
                }
                while (p2 < word.length && word[p2] == str[cp]) {
                    c2++; p2++; // 在字符串word中，遍历连续的的字符sc[cp]的数量
                }
                if ((c1 != c2 && c1 < 3) || (c1 < c2 && c1 >= 3)) return false;
            }
            return p1 == str.length && p2 == word.length; // 只有sc和wc都被遍历完毕，才返回true
        }
    }


}
