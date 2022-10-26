package src.EverydayTest;

import java.util.ArrayDeque;
//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
//

public class solution10_26 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        var s = new long[n + 1];
        for (var i = 0; i < n; ++i)
            s[i + 1] = s[i] + nums[i]; // 计算前缀和
        var q = new ArrayDeque<Integer>();
        for (var i = 0; i <= n; ++i) {
            var curS = s[i];
            while (!q.isEmpty() && curS - s[q.peekFirst()] >= k)
                ans = Math.min(ans, i - q.pollFirst()); // 符合条件大于等于k的值，并且同时将第一个下标抛弃，后面不会再用
            while (!q.isEmpty() && s[q.peekLast()] >= curS)
                q.pollLast(); // 最后一个值大于等于当前值的时候，不符合获取正整数的原则，最后一个值也要抛弃
            q.addLast(i);
        }
        return ans > n ? -1 : ans;
    }
}
