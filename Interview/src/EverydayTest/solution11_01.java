package src.EverydayTest;
//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
//数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串
public class solution11_01 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i=0;
        while (i<Math.max(word1.length, word2.length)){
            if (i< word1.length)
                sb1.append(word1[i]);
            if (i< word2.length)
                sb2.append(word2[i]);
            i++;
        }
        if (sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}
