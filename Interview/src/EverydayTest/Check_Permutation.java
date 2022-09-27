package src.EverydayTest;

import java.util.Arrays;

public class Check_Permutation {
    //function1: the easiest way
//时间复杂度：O(nlogn)，其中 n 为s1的长度。排序的时间复杂度为 O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlogn+n)=O(nlogn)。
//
//空间复杂度：O(logn)。排序需要O(logn) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的O(n)的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：
//这依赖于语言的细节；
//这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]
    public boolean CheckPermutation(String s1, String s2) {
        //先判断长度是否合适
        if(s1.length() != s2.length()){
            return false;
        }
        //对字符串进行排序，在比较
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0 ; i < c1.length ; i ++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

//    时间复杂度：O(n)
//空间复杂度：O(C)，其中 C = 256 为字符集大小
//    对两字符串进行词频统计，统计过程中使用变量 tot 记录词频不同的字符个数
    public boolean CheckPermutation2(String s1, String s2) {
        int n = s1.length(), m = s2.length(), tot = 0;
        if (n != m) return false;
        int[] cnts = new int[256];
        for (int i = 0; i < n; i++) {
            if (++cnts[s1.charAt(i)] == 1) tot++;
            if (--cnts[s2.charAt(i)] == 0) tot--;
        }
        return tot == 0;
    }
}
