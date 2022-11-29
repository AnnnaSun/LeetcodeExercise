package src.EverydayTest;
//给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
//
//交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
//
//返回使 s 变成 交替字符串 所需的 最少 操作数。

public class solution11_29 {
    public static int minOperations(String s) {
        int init = 0;
        char[] schars = s.toCharArray();
        for (int i=1; i<s.length(); i++){
            if (schars[i] == schars[i-1]){
                init++;
                if (schars[i-1] == '0'){
                    schars[i]='1';
                }
                else schars[i]='0';
            }
        }
        return Math.min(init, s.length()-init);
    }

    public static void main(String[] args) {
        minOperations("10010100");
    }
}
