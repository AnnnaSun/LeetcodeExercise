package src.EverydayTest;

//给你一个下标从 0开始长度为 n的字符串num，它只包含数字。
//
//如果对于 每个0 <= i < n的下标i，都满足数位i在 num中出现了num[i]次，那么请你返回true，否则返回false。
//
public class solution23111 {
    public static boolean digitCount(String num) {
        int[] records = new int[10];
        for (char c: num.toCharArray()){
            int n = c-48;
            int temp = records[n];
            records[n] = temp+1;
        }

        for(int i=0; i<num.length(); i++){
            if ((num.charAt(i)-48) != records[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        digitCount("1210");
    }
}
