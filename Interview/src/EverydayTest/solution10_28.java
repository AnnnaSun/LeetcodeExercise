package src.EverydayTest;
//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
public class solution10_28 {
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        for (int i =0; i<arr.length; i++){
            int min = arr[i];
            for (int j=i; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                sum+=min;
            }
        }
        final long modvalue = 1000000007;
        sum = sum%modvalue;
        return (int)sum;
    }
}
