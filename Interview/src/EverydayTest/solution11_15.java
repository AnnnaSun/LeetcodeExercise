package src.EverydayTest;
//请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
//
//numberOfBoxesi 是类型 i 的箱子的数量。
//numberOfUnitsPerBoxi 是类型 i每个箱子可以装载的单元数量。
//整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。

//返回卡车可以装载单元 的 最大 总数。
//

import java.util.Arrays;

public class solution11_15 {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length, ans = 0;
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        for (int i = 0, cnt = 0; i < n && cnt < truckSize; i++) {
            int a = boxTypes[i][0], b = boxTypes[i][1], c = Math.min(a, truckSize - cnt);
            cnt += c; ans += c * b;
        }
        return ans;

    }

    public static void main(String[] args) {
        maximumUnits(new int[][]{{1,3},{2,2},{3,1}},4);
    }
}
