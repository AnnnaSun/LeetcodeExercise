package src.EverydayTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给你一个字符串 word ，该字符串由数字和小写英文字母组成。
//
//请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
//
//返回对 word 完成替换后形成的 不同 整数的数目。
//
//只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
public class solution12_5 {
//    出现int值溢出后和第二个位数一样的情况
    public static int numDifferentIntegers(String word) {
        Set numlist1 = new HashSet();
        List<Integer> numlist = new ArrayList<>();
        StringBuilder prexString = new StringBuilder();
        int prexint = 0;
        for (int i=0; i<word.length(); i++){
            if (Character.isDigit(word.charAt(i))){
                prexString.append(word.charAt(i));
                String s = word.charAt(i)+"";
                prexint = prexint*10+Integer.parseInt(s);
                if (i==word.length()-1){
                    numlist1.add(prexint);
                }
            }
            else {
                if (!prexString.isEmpty()) {
                    prexString = new StringBuilder();
                    numlist1.add(prexint);
                    prexint =0;
                }
            }
        }
        return numlist1.size();
    }

//    第二种双指针+String加入set保证
    public int numDifferentIntegers2(String word) {
        Set<String> set = new HashSet<String>();
        int n = word.length(), p1 = 0, p2;
        while (true) {
            while (p1 < n && !Character.isDigit(word.charAt(p1))) {
                p1++;
            }
            if (p1 == n) {
                break;
            }
            p2 = p1;
            while (p2 < n && Character.isDigit(word.charAt(p2))) {
                p2++;
            }
            while (p2 - p1 > 1 && word.charAt(p1) == '0') { // 去除前导 0
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }

    public static void main(String[] args) {
        numDifferentIntegers("035985750011523523129774573439111590559325a1554234973");
    }
}
