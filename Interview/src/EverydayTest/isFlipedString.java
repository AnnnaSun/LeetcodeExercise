package src.EverydayTest;
//字符串轮转

public class isFlipedString {

//    时间复杂度：O（n）。 空间复杂度O(n)
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        String ss = s2+s2;
        return ss.contains(s1);
    }

//    ，假设 s1轮转 i 位，则与 s2中的某一位字符 s2[j] 对应的原s1中的字符应该为s1[(i+j)modn]。在固定 i 的情况下，遍历所有 j，若对应字符都相同，则返回 true。否则，继续遍历其他候选的 i。若所有的 i都不能使s
//1变成 s2，则返回 false。
    public boolean isFlipedString2(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
