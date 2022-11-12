package src.testList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class deleterepeat {
    public static int[] deleterepeatNum(int[] nums){
        Map<Integer, Integer> resMap = new HashMap<>();
        List newList = new ArrayList();
        for (int i=0; i<nums.length; i++){
            if (resMap.containsKey(nums[i])){
                int repeatNum = resMap.get(nums[i]);
                resMap.put(nums[i], ++repeatNum);
            }
            else {
                resMap.put(nums[i], 1);
            }
        }
        int[] keys = new int[resMap.size()];
        int i =0;
        for (int n: resMap.keySet()){
            keys[i++] = n;
        }
        for (int j =0; j<keys.length-1; j++){
            int maxindex = j;
            for (int k = j+1; k<keys.length; k++){
                if (resMap.get(keys[k])>resMap.get(keys[maxindex])){
                    maxindex=k;
                }
            }
            swap(keys, j, maxindex);
        }
        return keys;
    }
    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,3,2,4,4,4,5};
        System.out.println(deleterepeatNum(nums).toString());
    }
}
