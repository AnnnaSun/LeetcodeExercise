package src.EverydayTest;

import java.util.Arrays;

//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
//
//全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
//
//0 <= i < j < n
//nums[i] > nums[j]
//局部倒置 的数目等于满足下述条件的下标 i 的数目：
//
//0 <= i < n - 1
//nums[i] > nums[i + 1]
//当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
public class solution11_16 {
    class Solution {
        public boolean isIdealPermutation(int[] nums) {
            int max = nums[0];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] < max) return false;
                max = Math.max(max, nums[i - 1]);
            }
            return true;
        }

    }
}
