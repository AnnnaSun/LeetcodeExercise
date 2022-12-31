package src.EverydayTest;

//给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
//
//注意：
//
//如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
//s 包含至少一个出现两次的字母。
//
public class solution231_1 {
    public char repeatedCharacter(String s) {
        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            int i = chars[c-'a'];
            i+=1;
            chars[c-'a'] = i;
            if (chars[c-'a'] ==2)return c;
        }
        return 0;
    }
}
