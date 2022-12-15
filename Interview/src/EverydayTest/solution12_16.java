package src.EverydayTest;

//给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
//
//返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
//
public class solution12_16 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum =0;
        for (int i: nums){
            sum+=i;
        }
        long needed = Math.abs(goal-sum);
        if (needed == 0)return 0;
        if (needed < Math.abs(limit))return 1;
        int result = (int) (needed%Math.abs(limit)>0? (needed/Math.abs(limit))+1: needed/Math.abs(limit));
        return result;
    }
}
