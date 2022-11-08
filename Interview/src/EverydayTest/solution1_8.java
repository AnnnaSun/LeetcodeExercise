package src.EverydayTest;
//给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串 。
//
//请你返回words数组中一致字符串 的数目
public class solution1_8 {
    public static int countConsistentStrings(String allowed, String[] words) {
        char[] allowedchar = allowed.toCharArray();
        int result =0;
        for (String word: words){
            for (char c: allowedchar){
                word = word.replace(String.valueOf(c), "");
            }
            if (word.equals(""))result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words= new String[]{"ad","bd","aaab","baa","badab"};
        countConsistentStrings("ab", words);
    }
}
