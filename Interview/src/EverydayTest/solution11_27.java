package src.EverydayTest;
//给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
//
//如果nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
//
//源数组中可能存在 重复项 。
//
public class solution11_27 {
    public boolean check(int[] nums) {
        int n = nums.length, x = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }//找出第一个小于前一个数的地方
        if (x == 0) {
            return true;
        }//默认没有
        for (int i = x + 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }//再次出现小于前一位数的存在的话无法轮转
        return nums[0] >= nums[n - 1];//确保最后一个数小于第一个才能顺利后续

    }
}
