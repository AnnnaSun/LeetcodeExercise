package src.EverydayTest;
import java.util.HashSet;
import java.util.Set;

//给定你一个整数数组nums
//
//我们要将nums数组中的每个元素移动到A数组 或者B数组中，使得A数组和B数组不为空，并且average(A) == average(B)。
//
//如果可以完成则返回true， 否则返回 false。
//
//注意：对于数组arr, average(arr)是arr的所有元素除以arr长度的和。
//
public class splitArrayAverage {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums.length == 1) {
                return false;
            }
            int n = nums.length, m = n / 2;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            boolean isPossible = false;
            for (int i = 1; i <= m; i++) {
                if (sum * i % n == 0) {
                    isPossible = true;
                    break;
                }
            }
            if (!isPossible) {
                return false;
            }
            Set<Integer>[] dp = new Set[m + 1];
            for (int i = 0; i <= m; i++) {
                dp[i] = new HashSet<Integer>();
            }
            dp[0].add(0);
            for (int num : nums) {
                for (int i = m; i >= 1; i--) {
                    for (int x : dp[i - 1]) {
                        int curr = x + num;
                        if (curr * n == sum * i) {
                            return true;
                        }
                        dp[i].add(curr);
                    }
                }
            }
            return false;
        }

}
