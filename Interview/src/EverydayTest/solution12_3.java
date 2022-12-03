package src.EverydayTest;

//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
//
//混合字符串 由小写英文字母和数字组成。
public class solution12_3 {
    public static int secondHighest(String s) {
        int[] records = new int[10];
        for (char c: s.toCharArray()){
            int num = c-48;
            if (num<10 && num>=0){
                records[num]++;
            }
        }
        int prex = -1;
        for (int i=9;i>=0;i--){
            if (prex>-1 && records[i]>0){
                return i;
            }
            else if (records[i]>0 && prex==-1){
                prex = i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        secondHighest("dfa12321afd");
    }
}
