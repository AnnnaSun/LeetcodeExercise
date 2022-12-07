package src.EverydayTest;

import java.util.Arrays;

//给你两个长度可能不等的整数数组nums1 和nums2。两个数组中的所有值都在1到6之间（包含1和6）。
//
//每次操作中，你可以选择 任意数组中的任意一个整数，将它变成 1到 6之间 任意的值（包含 1和 6）。
//
//请你返回使 nums1中所有数的和与nums2中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1
//
public class solution12_7 {
    public static int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1=0, sum2=0;
        for (int i: nums1){
            sum1+=i;
        }
        for (int i: nums2){
            sum2+=i;
        }
        if (sum1==sum2)return 0;
        if (sum1>sum2){
            int[] high = (int[])nums1.clone();
            int[] low = (int[])nums2.clone();
            int dif = sum1-sum2;
            return minOperations1(high, low, dif);
        }
        else {
            int[] low = (int[])nums1.clone();
            int[] high = (int[])nums2.clone();
            int dif = sum2-sum1;
            return minOperations1(high, low, dif);
        }
    }

    public static int minOperations1(int[] high, int[] low, int dif){
        int highpos = high.length-1;
        int lowpos = 0;
        int res = 0;
        while(lowpos<low.length || highpos>=0){
            if ((lowpos< low.length && highpos>=0 && high[highpos]-1 >= (6-low[lowpos])) || (lowpos==low.length)){
                res++;
                if (dif > (high[highpos]-1)) {
                    dif = dif - (high[highpos]-1);
                    highpos--;
                }
                else return res;
            }
            else if ((lowpos< low.length && highpos>=0 && (high[highpos]-1) < (6-low[lowpos])) || (highpos==-1)){
                res++;
                if (dif > (6-low[lowpos])) {
                    dif = dif-(6-low[lowpos]);
                    lowpos++;
                }
                else return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        minOperations(new int[]{6,6}, new int[]{1});
    }
}
