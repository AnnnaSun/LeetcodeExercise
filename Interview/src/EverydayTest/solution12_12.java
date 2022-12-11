package src.EverydayTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//一个字符串的 美丽值定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
//
//比方说，"abaacc"的美丽值为3 - 1 = 2。
//给你一个字符串s，请你返回它所有子字符串的美丽值之和。
//
public class solution12_12 {
    public static int beautySum(String s) {
        int sum=0;
        for (int i=0; i<s.length()-1; i++){
            HashMap<Integer, Integer> recordsMap = new HashMap<>();
            int[] records = new int[26];
            records[s.charAt(i)-'a'] =1;
            recordsMap.put(1, 1);
            int max=1, min=1;
            for (int j=i+1; j<s.length(); j++){
                char c = s.charAt(j);
                int n = records[c-'a'];
                if (n >0){
                    recordsMap.put(n,recordsMap.get(n)-1);
                }
                records[c-'a'] = n+1;
                recordsMap.put(n+1,recordsMap.getOrDefault(n+1, 0)+1);
                max = Math.max(n+1, max);
                if (recordsMap.get(min) .equals(0)){
                    min = min+1;
                }else {
                    min = Math.min(n+1, min);
                }

                sum = sum+max-min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        beautySum("aabcb");
    }
}
