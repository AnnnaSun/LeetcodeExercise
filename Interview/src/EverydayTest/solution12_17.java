package src.EverydayTest;

//给你一个长度为 n的二维整数数组groups，同时给你一个整数数组nums。
//
//你是否可以从 nums中选出 n个 不相交 的子数组，使得第 i个子数组与 groups[i]（下标从 0开始）完全相同，且如果i > 0，那么第(i-1)个子数组在 nums中出现的位置在第 i个子数组前面。（也就是说，这些子数组在 nums中出现的顺序需要与 groups 顺序相同）
//
//如果你可以找出这样的 n 个子数组，请你返回true ，否则返回false。
//
//如果不存在下标为 k的元素 nums[k]属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
//
public class solution12_17 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length && i < groups.length;) {
            if (check(groups[i], nums, k)) {
                k += groups[i].length;
                i++;
            } else {
                k++;
            }
        }
        return i == groups.length;
    }

    public boolean check(int[] g, int[] nums, int k) {
        if (k + g.length > nums.length) {
            return false;
        }
        for (int j = 0; j < g.length; j++) {
            if (g[j] != nums[k + j]) {
                return false;
            }
        }
        return true;
    }
}
