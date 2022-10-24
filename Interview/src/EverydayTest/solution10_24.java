package src.EverydayTest;
//给定一个数组nums，将其划分为两个连续子数组left和right，使得：
//
//left中的每个元素都小于或等于right中的每个元素。
//left 和right都是非空的。
//left 的长度要尽可能小。
//在完成这样的分组后返回left的长度。

public class solution10_24 {
    public static int partitionDisjoint(int[] nums) {
        int leftmax = nums[0];
        int currentpos = 0;
        int rightpos = nums.length-1;
        while (currentpos < rightpos){
            leftmax = Math.max(leftmax, nums[currentpos]);
            if (leftmax<= nums[rightpos]){
                rightpos--;
            }
            else {
                currentpos++;
            }
        }
        if (leftmax>nums[currentpos]) {
            for (int i = nums.length-1; i > currentpos; i--) {
                if (nums[i]<leftmax){
                    return i+1;
                }
            }
        }
        return currentpos+1;
    }

    public static void main(String[] args) {
        partitionDisjoint(new int[]{6,0,8,30,37,6,75,98,39,90,63,74,52,92,64});
    }
}
