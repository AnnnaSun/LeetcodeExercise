package src.EverydayTest;
//请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
//
//给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

import java.util.ArrayDeque;
import java.util.Deque;

public class solution11_6 {
    public String interpret(String command) {
        Deque<String> deque = new ArrayDeque();
        char[] input = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n=0;
        for (int i=0;i<command.length();i++){
            if (input[i]=='G') sb.append("G");
            else if (input[i] !=')'){
                n++;
            }
            else {
                if (n==3)sb.append("al");
                if (n==1) sb.append("o");
                n=0;
            }
        }
        return sb.toString();
    }
}
