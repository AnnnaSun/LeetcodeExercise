package src.testList;

import java.util.Scanner;

public class minchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nums = s.split(" ");
        int k = sc.nextInt();
        int right=0, left = nums.length-1;
        int steps = 0;
        while (right< nums.length && left>0 && right!=left){
            int rightNum = Integer.parseInt(nums[right]);
            int leftNum = Integer.parseInt(nums[left]);
            if (rightNum>k)right++;
            else if (leftNum<=k)left--;
            else {
                swap(nums, right, left);
                steps++;
            }
        }
        System.out.println(steps);
    }

    public static void swap(String[] nums, int i, int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
