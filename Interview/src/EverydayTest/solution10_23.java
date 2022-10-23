package src.EverydayTest;

//给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
//
//返回 合并后的字符串
public class solution10_23 {
    public String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder newStr = new StringBuilder();
        int i =0;
        int max = Math.max(chars1.length, chars2.length);
        while (i < max){
            if (i< chars1.length){
                newStr.append(chars1[i]);
            }
            if (i< chars2.length) {
                newStr.append(chars2[i]);
            }
            i++;
        }
        return newStr.toString();
    }
}
